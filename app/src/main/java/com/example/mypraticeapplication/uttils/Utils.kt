package com.example.mypraticeapplication.uttils

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.text.Html
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.mypraticeapplication.MainActivity
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ActivityDashboardBinding
import com.example.mypraticeapplication.databinding.ChangePasswordFragmentBinding
import com.example.mypraticeapplication.viewmodel.ChangePasswordViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar


class Utils {

    var session: Session? = null;

    fun showToast(context: Context,message: String){
        val toast = Toast.makeText(
            context,
            Html.fromHtml("<font color='#e3f2fd' ><b>$message</b></font>"),
            Toast.LENGTH_LONG
        )
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }


    public fun showAlertDialog(context: Context,strTitle: String) {

        session = Session(context);

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.attributes.windowAnimations = R.style.DialogTheme;
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_alert_dialoug)

        dialog.window!!.setBackgroundDrawableResource(R.color.dialoug_main_bg);

        var txtHeader  : TextView = dialog.findViewById(R.id.tvMessage)
        txtHeader.text = strTitle

        // Button
        var buttonOk : MaterialButton = dialog.findViewById(R.id.btnOk)
        var buttonCancel : MaterialButton = dialog.findViewById(R.id.btnCancel)

        buttonOk.setOnClickListener {
            dialog.dismiss()
            session!!.clearSession()
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
        buttonCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    public fun showChangePasswordDialog(context: Context, binding: ActivityDashboardBinding){
        val changePasswordViewModel by lazy { ChangePasswordViewModel(context as Context,binding) }

        val dialog = Dialog(context, R.style.DialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)

        val binding: ChangePasswordFragmentBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.change_password_fragment, null, false)
        dialog.setContentView(binding.root)

        binding.viewModel = changePasswordViewModel

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        lp.gravity = Gravity.CENTER

        dialog.window!!.setAttributes(lp)

        dialog.window!!.setBackgroundDrawableResource(R.color.dialoug_main_bg);


        changePasswordViewModel.isChangePasswordSuccess.observeForever {
            if (it == true){
                dialog.dismiss()
            }
        }

        var ivClose : ImageView = dialog.findViewById(R.id.iv_Close)
        var btnSave : MaterialButton = dialog.findViewById(com.example.mypraticeapplication.R.id.btnSave)

        ivClose.setOnClickListener {
            dialog.dismiss()
        }

        btnSave.setOnClickListener {
            changePasswordViewModel.callChangePasswordApi()
        }

        dialog.show()
    }

    fun  showSnackBar(context: Context, message: String, constraintLayout: ConstraintLayout){
        val snackbar = Snackbar.make(constraintLayout, message, Snackbar.LENGTH_LONG)
        snackbar.setBackgroundTint(ContextCompat.getColor(context, R.color.black))
        snackbar.show()
    }

    /**
     * Check Internet is connected or not
     */
    fun isNetworkConnected(context: Context?): Boolean {
        val connectivityManager: ConnectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT < 23) {
            val ni = connectivityManager.activeNetworkInfo
            if (ni != null) {
                return ni.isConnected && (ni.type == ConnectivityManager.TYPE_WIFI
                        || ni.type == ConnectivityManager.TYPE_MOBILE)
            }
        } else {
            val network: Network? = connectivityManager.activeNetwork
            if (network != null) {
                val networkCapabilities: NetworkCapabilities? =
                    connectivityManager.getNetworkCapabilities(network)

                return networkCapabilities!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            }
        }
        return false
    }
}