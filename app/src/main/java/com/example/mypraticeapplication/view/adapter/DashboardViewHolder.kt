package com.example.mypraticeapplication.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mypraticeapplication.databinding.ItemDashboardBinding
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestData
import com.example.mypraticeapplication.viewmodel.DashboardViewModel

class DashboardViewHolder (val binding: ItemDashboardBinding, val viewModel: DashboardViewModel) :  RecyclerView.ViewHolder(binding.root){


    fun bind(data: GetPendingRequestData) {
        binding.position = adapterPosition
        binding.holder = this
        binding.itemData = data
        binding.viewmodel = viewModel
    }
}