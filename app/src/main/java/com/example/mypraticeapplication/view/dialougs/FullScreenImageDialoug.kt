package com.example.mypraticeapplication.view.dialougs

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FullScreenImageDialougBinding

class FullScreenImageDialoug(private var mContext: Context, private val documentPath: String?,) : Dialog(mContext, R.style.ThemeDialog)  {


    private lateinit var binding: FullScreenImageDialougBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        setCanceledOnTouchOutside(false)
        setCancelable(false)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.full_screen_image_dialoug, null, false)


        val lp = WindowManager.LayoutParams()
        lp.copyFrom(window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT - 100
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        lp.gravity = Gravity.CENTER

        window!!.setAttributes(lp)


        setContentView(binding.root)

        val options: RequestOptions = RequestOptions()
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round)

        Glide.with(context).load(documentPath).apply(options).into(binding.ivDocument)


        binding.ivClose.setOnClickListener {
            dismiss()
        }

    }

}