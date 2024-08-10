package com.example.mypraticeapplication.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mypraticeapplication.databinding.ItemDocumentBinding
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDocument
import com.example.mypraticeapplication.viewmodel.DashboardViewModel
import com.example.mypraticeapplication.viewmodel.verificationDetail.BasicInformationViewModel

class DocumentViewHolder(val binding: ItemDocumentBinding, val viewModel: BasicInformationViewModel) :  RecyclerView.ViewHolder(binding.root) {

    fun bind(data: GetVerificationDocument) {
        binding.position = adapterPosition
        binding.holder = this
        binding.itemData = data
        binding.viewmodel = viewModel
    }
}