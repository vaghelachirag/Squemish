package com.example.mypraticeapplication.uttils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.text.Html
import android.view.Gravity
import android.widget.Toast


class Utils {

    fun showToast(context: Context,message: String){
        val toast = Toast.makeText(
            context,
            Html.fromHtml("<font color='#e3f2fd' ><b>$message</b></font>"),
            Toast.LENGTH_LONG
        )
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
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