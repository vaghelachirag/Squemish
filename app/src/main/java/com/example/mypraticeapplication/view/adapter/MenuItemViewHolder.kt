package com.example.mypraticeapplication.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mypraticeapplication.databinding.ItemDashboardBinding
import com.example.mypraticeapplication.databinding.LayoutMenuItemBinding
import com.example.mypraticeapplication.model.getMenuListResponse.GetMenuListData
import com.example.mypraticeapplication.viewmodel.DashboardViewModel

class MenuItemViewHolder(val binding: LayoutMenuItemBinding, val viewModel: DashboardViewModel) :  RecyclerView.ViewHolder(binding.root) {
    fun bind(data: GetMenuListData) {
        binding.position = adapterPosition
        binding.holder = this
        binding.itemData = data
        binding.viewmodel = viewModel
    }

}