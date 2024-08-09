package com.example.mypraticeapplication.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ActivityDashboardBinding
import com.example.mypraticeapplication.databinding.ChangePasswordFragmentBinding
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.changepassword.ChangePasswordModel
import com.example.mypraticeapplication.model.changepassword.GetChangePasswordResponse
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.uttils.Session
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ChangePasswordViewModel(val context: Context, val binding: ActivityDashboardBinding) : BaseViewModel() {


    // Session Manager
    var session = Session(context)

    // Login Params
    var oldPassword : ObservableField<String> = ObservableField()
    var newPassword : ObservableField<String> = ObservableField()
    var confirmPassword : ObservableField<String> = ObservableField()


    private var changePasswordMutableLiveData: MutableLiveData<ChangePasswordModel> = MutableLiveData()

    var isChangePasswordSuccess  = MutableLiveData<Boolean>()

    fun init(context: Context) {

    }

    @SuppressLint("HardwareIds")
    fun callChangePasswordApi() {
        val model = ChangePasswordModel()
        model.oldPassword = oldPassword.get()
        model.newPassword = newPassword.get()
        model.confirmPassword = confirmPassword.get()

        changePasswordMutableLiveData.value = model

        if (model.oldPassword == null){
            Utils().showSnackBar(context,"Please enter your Old Password",binding.constraintLayout)
        }
        else if (model.newPassword == null ){
            Utils().showSnackBar(context,"Please enter your New Password",binding.constraintLayout)
        }
        else if (model.confirmPassword == null ){
            Utils().showSnackBar(context,"Please reenter your New Password",binding.constraintLayout)
        }

        else if (model.newPassword.toString() != model.confirmPassword.toString()){
            Utils().showSnackBar(context,"Password and confirm password does not match",binding.constraintLayout)
        }

        else{
            callChangePasswordAPI()
        }
    }
    // Call Change Password API
    private fun callChangePasswordAPI(){

        val params = HashMap<String,Any>()
        params["OldPassword"] = oldPassword.get().toString()
        params["NewPassword"] = newPassword.get().toString()
        params["ConfirmPassword"] = confirmPassword.get().toString()


        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getChangePasswordApiResponse(Networking.wrapParams(params))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetChangePasswordResponse>() {
                    override fun onSuccess(response: GetChangePasswordResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetChangePasswordResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
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