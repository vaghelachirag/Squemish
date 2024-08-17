package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.R.id
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.util.Base64
import com.example.mypraticeapplication.databinding.FragmentPhotographBinding
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.finalSubmission.GetFinalSubmissionApiResponse
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.ByteArrayOutputStream
import java.io.File


class PictureViewModel(private val context: Context, private val  binding: FragmentPhotographBinding): BaseViewModel() {


    fun init(context: Context?) {

    }

    //    For Save Survey Picture
    fun saveSurveyPicture(data: Bitmap, path: String, imgFile: File) {

        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("firequestid", AppConstants.verificationId.toString())
            .addFormDataPart(
                "document",
                imgFile.name,
                RequestBody.create("image/*".toMediaTypeOrNull(), imgFile)
            )
            .build()


     if (!Utility.isNetworkConnected(context)) {

        }else{ isLoading.postValue(true)
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

    private fun getByteArrayFromImageURL(bitmap: Bitmap): String? {
        val stream = ByteArrayOutputStream()
        bitmap.compress(CompressFormat.JPEG, 70, stream)
        // get the base 64 string
        return Base64.encodeToString(stream.toByteArray(), Base64.DEFAULT)
    }
}