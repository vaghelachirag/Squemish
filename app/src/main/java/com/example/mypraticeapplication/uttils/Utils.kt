package com.example.mypraticeapplication.uttils

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.text.Html
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
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
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.view.detail.ActivityDetail
import com.example.mypraticeapplication.viewmodel.ChangePasswordViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date


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


    fun getCurrentDate(): String {
        val today = Date()
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return format.format(today)
    }

    fun drawMultilineTextToBitmap(gContext: Context, imagePath: String?, text: String?): Bitmap {
        // prepare canvas

        val resources = gContext.resources
        val scale = resources.displayMetrics.density
        val image = File(imagePath)
        val bmOptions = BitmapFactory.Options()
        var bitmap = BitmapFactory.decodeFile(image.absolutePath, bmOptions)
        bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.width, bitmap.height, true)

        var bitmapConfig = bitmap.config
        // set default bitmap config if none
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888
        }
        // resource bitmaps are imutable,
        // so we need to convert it to mutable one
        bitmap = bitmap.copy(bitmapConfig, true)

        val canvas = Canvas(bitmap)

        // new antialiased Paint
        val paint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        // text color - #3D3D3D
        paint.color = Color.WHITE
        // text size in pixels
        paint.textSize = (12 * scale).toInt().toFloat()
        // text shadow
        paint.setShadowLayer(1f, 0f, 0f, Color.WHITE)

        // set text width to canvas width minus 16dp padding
        val textWidth = canvas.width - (16 * scale).toInt()

        // init StaticLayout for text
        val textLayout = StaticLayout(
            text, paint, textWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false
        )

        // get height of multiline text
        val textHeight = textLayout.height

        // get position of text's top left corner
        val x = ((bitmap.width - textWidth) - 10).toFloat()
        val y = ((bitmap.height - textHeight) - 20).toFloat()

        // draw text to the Canvas center
        canvas.save()
        canvas.translate(x, y)
        textLayout.draw(canvas)
        canvas.restore()
        return bitmap
    }

    public  fun  setVerificationType(selectedData: GetVerificationDetailData?){
        if (ActivityDetail.selectedData != null){
            if (ActivityDetail.selectedData!!.getVerificationType() != null){
                if (ActivityDetail.selectedData!!.getVerificationType() == "RV"){
                    ActivityDetail.selectedData!!.isResidenceVerification = true
                }
                if (ActivityDetail.selectedData!!.getVerificationType() == "RV"){
                    ActivityDetail.selectedData!!.isResidenceVerification = true
                }
                if (ActivityDetail.selectedData!!.getVerificationType() == "DPV"){
                    ActivityDetail.selectedData!!.isDocumentVerification = true
                }
                else{
                    ActivityDetail.selectedData!!.isRCOVerification = true
                }
            }
        }
    }

    public fun showAlertDialog(context: Context,strTitle: String) {

        session = Session(context);

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.attributes.windowAnimations = R.style.DialogTheme;
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_alert_dialoug)

        dialog.window!!.setBackgroundDrawableResource(R.color.dialoug_main_bg);

        val txtHeader  : TextView = dialog.findViewById(R.id.tvMessage)
        txtHeader.text = strTitle

        // Button
        val buttonOk : MaterialButton = dialog.findViewById(R.id.btnOk)
        val buttonCancel : MaterialButton = dialog.findViewById(R.id.btnCancel)

        buttonOk.setOnClickListener {
            dialog.dismiss()
            session!!.clearSession()
            CoroutineScope(Dispatchers.IO).launch {
                InitDb.appDatabase.clearAllTables()
            }
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