package com.example.mypraticeapplication.view.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ActivityDashboardBinding
import com.example.mypraticeapplication.uttils.Session
import com.example.mypraticeapplication.view.dialougs.ProgressDialog


open class BaseActivity : AppCompatActivity() {
    private var shouldPerformDispatchTouch = true
    private lateinit var session: Session
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        session = Session(this)
        disableAutoFill()
    }

    fun setupToolbarWithMenu(title: String? = null, binding: ActivityDashboardBinding) {
        setSupportActionBar(binding.toolbarDashboard)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
            actionBar.setDisplayHomeAsUpEnabled(false)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_nav_menup)
            if (title != null) binding.tvTitle.text = title

        }

    }

    fun showProgressbar(message: String? = getString(R.string.please_wait)) {
        hideProgressbar()
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this, message)
        }
        progressDialog?.show()
    }

    fun hideProgressbar() {
       if (progressDialog != null && progressDialog?.isShowing!!) progressDialog!!.dismiss()
    }

    fun hideProgress() {
           if (progressDialog != null && progressDialog?.isShowing!!) progressDialog!!.dismiss()
    }


    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        var ret = false
        try {
            val view = currentFocus
            ret = super.dispatchTouchEvent(event)
            if (shouldPerformDispatchTouch) {
                if (view is EditText) {
                    val w = currentFocus
                    val scrCords = IntArray(2)
                    if (w != null) {
                        w.getLocationOnScreen(scrCords)
                        val x = event.rawX + w.left - scrCords[0]
                        val y = event.rawY + w.top - scrCords[1]

                        if (event.action == MotionEvent.ACTION_UP && (x < w.left || x >= w.right || y < w.top || y > w.bottom)) {
                            val imm =
                                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                        }
                    }
                }
            }
            return ret
        } catch (e: Exception) {
            e.printStackTrace()
            return ret
        }

    }

    private fun disableAutoFill() {
        window.decorView.importantForAutofill =
            View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

}
