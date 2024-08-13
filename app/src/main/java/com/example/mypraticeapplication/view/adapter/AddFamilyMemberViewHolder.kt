package com.example.mypraticeapplication.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mypraticeapplication.databinding.ItemAddFamilymemberBinding
import com.example.mypraticeapplication.model.getverificationDetailResponse.AddFamilyMemberModel


class AddFamilyMemberViewHolder(val binding: ItemAddFamilymemberBinding) :  RecyclerView.ViewHolder(binding.root) {
    fun bind(data: AddFamilyMemberModel) {
        binding.position = adapterPosition
        binding.holder = this
        binding.itemData = data
    }

}