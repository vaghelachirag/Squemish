package com.example.mypraticeapplication.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.AdapterViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ItemDashboardBinding
import com.example.mypraticeapplication.interfaces.OnItemSelected
import com.example.mypraticeapplication.model.DashboardModel
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestData
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.viewmodel.DashboardViewModel

class DashboardAdapter(val context: Context, private val list: ArrayList<GetPendingRequestData>, val viewModel: DashboardViewModel, val onItemSelected: OnItemSelected<GetPendingRequestData>,) :  RecyclerView.Adapter<DashboardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        val binder = DataBindingUtil.inflate<ItemDashboardBinding>(
            layoutInflater,
            R.layout.item_dashboard,
            parent,
            false
        )
        return DashboardViewHolder(binder, viewModel)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DashboardViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(list[position])

        holder.binding.cardView.setOnClickListener {
            onItemSelected.onItemSelected(list[position], position)
        }

        holder.binding.txtApplicateName.text =  list[position].getApplicantName()  + " [Applicant]"
        holder.binding.txtAddress.text = list[position].getApplicantAddress() + ", "+list[position].getApplicantCity() +  ", "+ list[position].getApplicantPinCode() + ", "+  list[position].getApplicantState()
    }
    override fun getItemCount(): Int {
        return list.size
    }
}