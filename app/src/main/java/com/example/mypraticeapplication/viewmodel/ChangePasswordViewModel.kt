package com.example.mypraticeapplication.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.DashboardFragmentBinding
import com.example.mypraticeapplication.interfaces.OnItemSelected
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.getUserProfileData.GetUserProfileResponse
import com.example.mypraticeapplication.model.getmasterData.GetMasterApiResponse
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestData
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestResponse
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.uttils.Session
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ChangePasswordViewModel (val context: Context) : BaseViewModel() {

    var verificationList: ArrayList<GetPendingRequestData> = ArrayList()

    // Session Manager
    var session = Session(context)

    fun init(context: Context) {

    }

    @SuppressLint("HardwareIds")
    private fun getPendingRequest() {

        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getPendingRequest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetPendingRequestResponse>() {
                    override fun onSuccess(response: GetPendingRequestResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetPendingRequestResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            verificationList.clear()
                            if(t.getData() != null){
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