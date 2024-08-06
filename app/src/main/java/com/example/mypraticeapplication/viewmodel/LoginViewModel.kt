package com.example.mypraticeapplication.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.mypraticeapplication.R
import androidx.navigation.fragment.findNavController
import com.example.mypraticeapplication.view.LoginFragment
import com.example.mypraticeapplication.model.LoginModel
import com.example.mypraticeapplication.model.base.BaseModel
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.login.GetLoginResponseModel
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.uttils.Session
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.menu.DashboardActivity
import com.google.android.material.snackbar.Snackbar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private val context: Context, private val  loginFragment: LoginFragment) : BaseViewModel(){

    // Login Params
     var email : ObservableField<String> = ObservableField()
     var password : ObservableField<String> = ObservableField()
     private var confirmPassword : ObservableField<String> = ObservableField()
     private var signInMutableLiveData: MutableLiveData<LoginModel> = MutableLiveData()

    fun onSignInClicked() {
        val model = LoginModel()
        model.email = email.get()
        model.password = password.get()
        model.confirmPassword = confirmPassword.get()

        signInMutableLiveData.value = model

        if (model.email == null){
             Utils().showToast(context,"Please Enter Email Address")
        }
        else if (model.password == null ){
            Utils().showToast(context,"Please Enter Your Password")
        }
        else{
            callLoginAPI()
        }
    }

    @SuppressLint("HardwareIds")
    private fun callLoginAPI() {


        val params = HashMap<String,Any>()
        params["EmployeeCode"] = email.get().toString()
        params["Password"] = password.get().toString()
        params["AppId"] = "BCF97D6D0DB4C5E83107TR11"


        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .login(Networking.wrapParams(params))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetLoginResponseModel>() {
                    override fun onSuccess(response: GetLoginResponseModel) {
                        isLoading.postValue(false)
                        redirectToHome()
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetLoginResponseModel) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            var session = Session(context)
                            session.isLoggedIn = true
                            session.user = t.getData()
                            redirectToHome()
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


    /** Returns the consumer friendly device name  */
    private fun getDeviceName(): String? {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return if (model.startsWith(manufacturer)) {
            capitalize(model)
        } else capitalize(manufacturer) + " " + model
    }

    private fun capitalize(str: String): String {
        if (TextUtils.isEmpty(str)) {
            return str
        }
        val arr = str.toCharArray()
        var capitalizeNext = true
        val phrase = StringBuilder()
        for (c in arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c))
                capitalizeNext = false
                continue
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true
            }
            phrase.append(c)
        }
        return phrase.toString()
    }
    fun redirectToSignup(){
        loginFragment.findNavController().navigate(R.id.action_LoginFragment_to_SignUpFragment)
    }

    private fun redirectToHome(){
      //  loginFragment.findNavController().navigate(R.id.action_LoginFragment_to_HomeFragment)
        var intentLogin = Intent(context,DashboardActivity::class.java)
        context.startActivity(intentLogin)
    }

}