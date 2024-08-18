package com.example.mypraticeapplication.uttils

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.mypraticeapplication.R

class ImagePickerDialog(context: FragmentActivity?, private val itemClick: onItemClick) :
    AlertDialog(context) {

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_dialog_image_picker)

        val tvCamera : TextView =  findViewById(R.id.tvCamera)
        val tvGallery : TextView =  findViewById(R.id.tvGallery)


        tvCamera.setOnClickListener {
            itemClick.onCameraClicked()
            dismiss()
        }

        tvGallery.setOnClickListener {
            itemClick.onGalleryClicked()
            dismiss()
        }
    }
}

interface onItemClick {
    fun onCameraClicked()
    fun onGalleryClicked()
}