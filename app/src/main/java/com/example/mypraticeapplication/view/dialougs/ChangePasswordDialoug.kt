package com.example.mypraticeapplication.view.dialougs

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ChangePasswordFragmentBinding

class ChangePasswordDialoug(private var mContext: Context,) : Dialog(mContext, R.style.ThemeDialog)  {

    private lateinit var binding: ChangePasswordFragmentBinding
    private var listener: OkButtonListener? = null


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        setCanceledOnTouchOutside(false)
        setCancelable(false)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.change_password_fragment, null, false)


        window!!.setBackgroundDrawableResource(R.color.dialoug_main_bg);

        binding.btnSave.setOnClickListener {
            if (listener != null) {
                listener?.onOkPressed(
                    this,
                )

            }
        }
    }
    fun setListener(listener: OkButtonListener?): ChangePasswordDialoug {
        this.listener = listener
        return this
    }
    interface OkButtonListener {
        fun onOkPressed(acceptRejectFIDialog : ChangePasswordDialoug)
    }
}