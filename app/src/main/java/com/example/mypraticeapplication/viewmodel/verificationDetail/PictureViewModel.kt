package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FragmentPhotographBinding
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.finalSubmission.GetFinalSubmissionApiResponse
import com.example.mypraticeapplication.model.getFiResidencePicture.GetFiResidencePictureData
import com.example.mypraticeapplication.model.getFiResidencePicture.GetFiResidencePictureResponse
import com.example.mypraticeapplication.model.getMenuWebUrlResponse.GetMenuURLResponse
import com.example.mypraticeapplication.model.getPreNeighbourData.GetPreNeighbourResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetFiVerificationDocument
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDocument
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.adapter.PicturesAdapter
import com.example.mypraticeapplication.view.detail.ActivityDetail
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File


class PictureViewModel(private val context: Context, private val  binding: FragmentPhotographBinding): BaseViewModel() {

    private val picturesList: MutableList<GetFiVerificationDocument> = mutableListOf()
    private var picturesAdapter: PicturesAdapter? = null
    private var picturesLiveList: MutableLiveData<ArrayList<GetFiVerificationDocument>> = MutableLiveData()


    fun getPicturesAdapter(): PicturesAdapter? = picturesAdapter


    @SuppressLint("NotifyDataSetChanged")
    fun init(context: Context?) {
        getPictureApi()
        picturesAdapter = PicturesAdapter(picturesList, this)
        picturesLiveList.observeForever {
            if (it != null) {
                picturesList.clear()
                picturesList.addAll(it)
                picturesAdapter?.notifyDataSetChanged()
                setPictureAdapter()
            }
        }
    }

    private fun getPictureApi() {

        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getFiRequestPicture(AppConstants.verificationId.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetFiResidencePictureResponse>() {
                    override fun onSuccess(response: GetFiResidencePictureResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetFiResidencePictureResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            if(t.getData() != null){
                                picturesLiveList.value = t.getData()!!
                                setPictureAdapter()
                            }
                        }else{
                            Utils().showToast(context,t.getMessage().toString())
                        }
                        Log.e("StatusCode",t.getStatus().toString())
                    }

                })
        }else{
            Utils().showToast(context,context.getString(R.string.nointernetconnection).toString())
        }
    }

    //    For Delete Survey Picture
    @SuppressLint("NotifyDataSetChanged")
    fun deleteSurveyPicture(context: Context, documentId: Int, position: Int) {

        val params = HashMap<String, Any>()
        params["FIRequestId"] = AppConstants.verificationId.toString()
        params["DocumentId"] = documentId.toString()

        when {
            !Utility.isNetworkConnected(context) -> {

            }
            else -> { isLoading.postValue(true)
                isLoading.postValue(true)
                Networking.with(context)
                    .getServices()
                    .deleteFiRequestPicture(Networking.wrapParams(params))
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe(object : CallbackObserver<GetFinalSubmissionApiResponse>() {
                        override fun onSuccess(response: GetFinalSubmissionApiResponse) {
                            isLoading.postValue(false)
                        }

                        override fun onFailed(code: Int, message: String) {
                            isLoading.postValue(false)
                        }

                        override fun onNext(t: GetFinalSubmissionApiResponse) {
                            Log.e("Status", t.getStatusCode().toString())
                            isLoading.postValue(false)
                            if (t.getStatusCode() == 200) {
                                Utils().showSnackBar(
                                    context,
                                    t.getMessage().toString(),
                                    binding.constraintLayout
                                )
                                getPictureApi()
                            } else {
                                Utils().showSnackBar(
                                    context,
                                    t.getMessage().toString(),
                                    binding.constraintLayout
                                )
                            }
                            Log.e("StatusCode", t.getStatus().toString())
                        }
                    })
            }
        }

    }


    //    For Save Survey Picture
    fun saveSurveyPicture(imgFile: File) {

        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("firequestid", AppConstants.verificationId.toString())
            .addFormDataPart("document", imgFile.name, imgFile.asRequestBody("image/*".toMediaTypeOrNull()))
            .build()


        when {
            !Utility.isNetworkConnected(context) -> {

            }
            else -> { isLoading.postValue(true)
                Networking(context)
                    .getServices()
                    .saveSurveyPictureBase(requestBody)!!.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : CallbackObserver<GetFinalSubmissionApiResponse>() {
                        override fun onSuccess(response: GetFinalSubmissionApiResponse) {
                            isLoading.postValue(false)
                        }

                        override fun onFailed(code: Int, message: String) {
                            isLoading.postValue(false)
                        }

                        override fun onNext(t: GetFinalSubmissionApiResponse) {
                            if (t.getStatusCode() == 200) {
                                isLoading.postValue(false)
                                if(t.getStatusCode() == 200){
                                    getPictureApi()
                                    Utils().showSnackBar(context,t.getMessage().toString(),binding.constraintLayout)
                                }else{
                                    Utils().showSnackBar(context,t.getMessage().toString(),binding.constraintLayout)
                                }
                            } else {
                                Utils().showSnackBar(context, t.getMessage().toString(), binding.constraintLayout)
                            }
                        }
                    })
            }
        }
    }

    private fun setPictureAdapter() {
        picturesAdapter = PicturesAdapter(picturesList, this)
        binding.rvPictures.setLayoutManager(GridLayoutManager(context as Activity, 5))
        binding.rvPictures.setAdapter(picturesAdapter)
    }
}