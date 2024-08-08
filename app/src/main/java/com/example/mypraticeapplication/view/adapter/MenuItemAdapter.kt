package com.example.mypraticeapplication.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.LayoutMenuItemBinding
import com.example.mypraticeapplication.model.getMenuListResponse.GetMenuListData
import com.example.mypraticeapplication.viewmodel.DashboardViewModel

class MenuItemAdapter(val context: Context, private val list: ArrayList<GetMenuListData>, val viewModel: DashboardViewModel,) :  RecyclerView.Adapter<MenuItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        val binder = DataBindingUtil.inflate<LayoutMenuItemBinding>(
            layoutInflater,
            R.layout.layout_menu_item,
            parent,
            false
        )
        return MenuItemViewHolder(binder, viewModel)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MenuItemViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(list[position])

        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher_round)
            .circleCrop()
            .error(R.mipmap.ic_launcher_round)

        Glide.with(context).load(list[position].getIcon()).apply(options).into(holder.binding.ivLogo)
        holder.binding.txtMenuName.text = list[position].getName()
    }
    override fun getItemCount(): Int {
        Log.e("MenuList",list.size.toString())
        return list.size
    }
}