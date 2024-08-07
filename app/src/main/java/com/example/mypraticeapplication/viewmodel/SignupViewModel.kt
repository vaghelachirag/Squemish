package com.example.mypraticeapplication.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.databinding.ObservableField
import androidx.navigation.fragment.findNavController
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.SignupFragmentBinding
import com.example.mypraticeapplication.model.registerDevice.GetDeviceRegistrationResponse
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.SignupFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SignupViewModel(
    private val context: Context,
    val signupFragment: SignupFragment,
    val binding: SignupFragmentBinding
) : BaseViewModel(){

    var employeeCode : ObservableField<String> = ObservableField()
    var remark : ObservableField<String> = ObservableField()



    fun redirectToLogin(){
        signupFragment.findNavController().navigate(R.id.action_SignUpFragment_to_LoginFragment)
    }
    fun onSignUpClicked(){
      //  signupFragment.findNavController().navigate(R.id.action_SignUpFragment_to_LoginFragment)

        if (employeeCode.get() == null){
           // Utils().showToast(context,"Please Enter Employee Code")
            Utils().showSnackBar(context,"Please Enter Employee Code",binding.constraintLayout)
        }
        else{
            callSignupApi()
        }
    }
        @SuppressLint("HardwareIds")
        fun callSignupApi(){

            val deviceId = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
            val manufacturer = Build.MANUFACTURER
            val androidModel = Build.MODEL


            val params = HashMap<String,Any>()
            params["EmployeeCode"] = employeeCode.get().toString()
            params["DeviceName"] = "$manufacturer | $androidModel"
            params["DeviceUniqueId"] = deviceId
            params["Remarks"] = remark.get().toString()

            if (Utility.isNetworkConnected(context)){
                isLoading.postValue(true)
                Networking.with(context)
                    .getServices()
                    .registerUser(Networking.wrapParams(params))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : CallbackObserver<GetDeviceRegistrationResponse>() {
                        override fun onSuccess(response: GetDeviceRegistrationResponse) {
                            isLoading.postValue(false)
                        }

                        override fun onFailed(code: Int, message: String) {
                            isLoading.postValue(false)
                        }

                        override fun onNext(t: GetDeviceRegistrationResponse) {
                            Log.e("Status",t.getStatusCode().toString())
                            isLoading.postValue(false)
                            if(t.getStatusCode() == 200){
                                signupFragment.findNavController().navigate(R.id.action_SignUpFragment_to_LoginFragment)
                               // Utils().showToast(context,t.getMessage().toString())
                                Utils().showSnackBar(context,t.getMessage().toString(),binding.constraintLayout)
                            }else{
                                Utils().showSnackBar(context,t.getMessage().toString(),binding.constraintLayout)
                               // Utils().showToast(context,t.getMessage().toString())
                            }
                            Log.e("StatusCode",t.getStatus().toString())
                        }

                    })
            }else{
              //  Utils().showToast(context,context.getString(R.string.nointernetconnection).toString())
                Utils().showSnackBar(context,context.getString(R.string.nointernetconnection).toString(),binding.constraintLayout)
            }
        }
}