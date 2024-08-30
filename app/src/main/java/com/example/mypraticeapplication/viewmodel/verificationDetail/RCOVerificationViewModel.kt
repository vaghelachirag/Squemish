package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FragmentRcoVerificationBinding
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.getMenuWebUrlResponse.GetMenuURLResponse
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.detail.ActivityDetail
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RCOVerificationViewModel(private val context: Context, private  val binding: FragmentRcoVerificationBinding) : BaseViewModel() {

    var webViewURL = MutableLiveData<String>()


    fun init(context: Context?) {
        getRcuVerificationURL("1001")
    }


    private fun getRcuVerificationURL(menuId: String) {

        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getRcuVerificationWebpage(menuId,ActivityDetail.currentLat.toString(),ActivityDetail.currentLong.toString(),AppConstants.verificationId.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetMenuURLResponse>() {
                    override fun onSuccess(response: GetMenuURLResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetMenuURLResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            if(t.getData() != null){
                                webViewURL.value = t.getData()!!.getUrl()
                                Log.e("URL",webViewURL.value.toString())
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
}