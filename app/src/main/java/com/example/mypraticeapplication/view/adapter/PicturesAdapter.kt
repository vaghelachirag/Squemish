package com.example.mypraticeapplication.view.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ItemPicturesBinding
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetFiVerificationDocument
import com.example.mypraticeapplication.model.picture.PicturesModel
import com.example.mypraticeapplication.viewmodel.verificationDetail.PictureViewModel


class PicturesAdapter(val context: Context, private val list: MutableList<GetFiVerificationDocument>, val viewModel:PictureViewModel) :
    RecyclerView.Adapter<PicturesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binder = DataBindingUtil.inflate<ItemPicturesBinding>(
            layoutInflater,
            R.layout.item_pictures,
            parent,
            false
        )

        return PicturesViewHolder(binder,parent.context, viewModel)
    }

    override fun onBindViewHolder(holder: PicturesViewHolder, position: Int) {
        holder.bind(list[position])
        holder.binding.ivPicture.setOnClickListener {
            Log.e("Picture","Picture")
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(list[position].getDocumentPath()))
            context.startActivity(browserIntent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}