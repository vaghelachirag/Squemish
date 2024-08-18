package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mypraticeapplication.databinding.FragmentPhotographBinding
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.finalSubmission.GetFinalSubmissionApiResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetFiVerificationDocument
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
import java.io.File


class PictureViewModel(private val context: Context, private val  binding: FragmentPhotographBinding): BaseViewModel() {

    private val picturesList: MutableList<GetFiVerificationDocument> = mutableListOf()
    private var picturesAdapter: PicturesAdapter? = null
    private var picturesLiveList: MutableLiveData<List<GetFiVerificationDocument>> = MutableLiveData()


    fun getPicturesAdapter(): PicturesAdapter? = picturesAdapter


    @SuppressLint("NotifyDataSetChanged")
    fun init(context: Context?) {
        if (ActivityDetail.selectedData != null){
            if (!ActivityDetail.selectedData!!.getFirequestVerificationDocuments().isNullOrEmpty()){
              picturesLiveList.value = (ActivityDetail.selectedData!!.getFirequestVerificationDocuments())
            }
        }
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

    //    For Save Survey Picture
    fun saveSurveyPicture(imgFile: File) {

        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("firequestid", AppConstants.verificationId.toString())
            .addFormDataPart(
                "document",
                imgFile.name,
                RequestBody.create("image/*".toMediaTypeOrNull(), imgFile)
            )
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