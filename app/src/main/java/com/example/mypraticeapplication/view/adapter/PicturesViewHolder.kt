package com.example.mypraticeapplication.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ItemPicturesBinding
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetFiVerificationDocument
import com.example.mypraticeapplication.model.picture.PicturesModel
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.viewmodel.verificationDetail.PictureViewModel


class PicturesViewHolder(val binding: ItemPicturesBinding, val context: Context, val viewModel: PictureViewModel) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("ResourceAsColor")
    fun bind(data: GetFiVerificationDocument) {
        binding.position = adapterPosition
        binding.holder = this
        binding.itemData = data
        binding.viewmodel = viewModel



        Glide.with(context)
            .load(AppConstants.baseURLImage + data.documentPath)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(binding.ivPicture);
    }

   /* private fun deletePictureButtonClicked(id: String,position: Int,viewModel:PictureViewModel) {

    }*/

   /* fun onClickDelete(view: View, position: Int, data: PicturesModel?,viewModel:PictureViewModel) {
        deletePictureButtonClicked(data!!.surveyPicId!!,position,viewModel)
    }*/
}