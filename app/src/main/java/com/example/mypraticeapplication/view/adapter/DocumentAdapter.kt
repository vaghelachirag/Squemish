package com.example.mypraticeapplication.view.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ItemDocumentBinding
import com.example.mypraticeapplication.interfaces.OnItemSelected
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDocument
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.view.dialougs.FullScreenImageDialoug
import com.example.mypraticeapplication.viewmodel.verificationDetail.BasicInformationViewModel


class DocumentAdapter(
    val context: Context,
    private val list: ArrayList<GetVerificationDocument>,
    val viewModel: BasicInformationViewModel,
    val onItemSelected: OnItemSelected<GetVerificationDocument>
) :  RecyclerView.Adapter<DocumentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        val binder = DataBindingUtil.inflate<ItemDocumentBinding>(
            layoutInflater,
            R.layout.item_document,
            parent,
            false
        )
        return DocumentViewHolder(binder, viewModel)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DocumentViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(list[position])

        holder.binding.cardView.setOnClickListener {
            var documentURL = AppConstants.baseURLImage + list[position].getDocumentPath()
            onItemSelected.onItemSelected(list[position], position)
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(documentURL))
            context.startActivity(browserIntent)
          //  showFullScreenImageDialog(list[position].getDocumentPath())

        }

        if (list[position].getDocumentExtension() == ".png" || list[position].getDocumentExtension() == ".jpeg" || list[position].getDocumentExtension() == ".jpg"){
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)

            Glide.with(context).load( AppConstants.baseURLImage + list[position].getDocumentPath()).apply(options).into(holder.binding.ivDocument)

        }

        if (list[position].getDocumentExtension() == ".pdf"){

        }

    }

    private fun showFullScreenImageDialog(documentPath: String?) {
        FullScreenImageDialoug(context as Activity,documentPath).show()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}