package com.example.mypraticeapplication.uttils

import android.R
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.text.Html
import android.view.Gravity
import android.view.Window
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mypraticeapplication.MainActivity
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
        dialog.window!!.attributes.windowAnimations = com.example.mypraticeapplication.R.style.DialogTheme;
        dialog.setCancelable(false)
        dialog.setContentView(com.example.mypraticeapplication.R.layout.custom_alert_dialoug)

        var txtHeader  : TextView = dialog.findViewById(com.example.mypraticeapplication.R.id.tvMessage)
        txtHeader.text = strTitle

        // Button
        var buttonOk : MaterialButton = dialog.findViewById(com.example.mypraticeapplication.R.id.btnOk)
        var buttonCancel : MaterialButton = dialog.findViewById(com.example.mypraticeapplication.R.id.btnCancel)

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