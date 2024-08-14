package com.example.mypraticeapplication.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ItemAddFamilymemberBinding
import com.example.mypraticeapplication.model.getverificationDetailResponse.AddFamilyMemberModel


class AddFamilyMemberAdapter(
    val context: Context,
    private val list: ArrayList<AddFamilyMemberModel>,
    private val relationWithApplicantList: List<String>?,
    private var listener: OnItemClickListener
) :  RecyclerView.Adapter<AddFamilyMemberViewHolder>() {

    var isAtFirstPos: Boolean = false
    private var relationWithApplicantSpinnerAdapter: ArrayAdapter<String?>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddFamilyMemberViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binder = DataBindingUtil.inflate<ItemAddFamilymemberBinding>(layoutInflater, R.layout.item_add_familymember, parent, false)
        return AddFamilyMemberViewHolder(binder)

    }

    interface OnItemClickListener {

        fun onItemClick(position: Int, )

        fun onRemoveClick(
            position: Int,
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AddFamilyMemberViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(list[position])


        if (relationWithApplicantList!!.isNotEmpty()){
            relationWithApplicantSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    relationWithApplicantList
                )
            relationWithApplicantSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            holder.binding.spnRelation.adapter = relationWithApplicantSpinnerAdapter
        }



        holder.binding.btnAddDay.setOnClickListener {
            listener.onItemClick(position)
        }

        holder.binding.btnRemoveDay.setOnClickListener {
            if (position > 0){
                listener.onRemoveClick(position)
            }
        }

        if (position == list.size - 1)
            holder.binding.btnAddDay.visibility = View.VISIBLE
        else
            holder.binding.btnAddDay.visibility = View.GONE

    }

    fun addDay() {
        list.add(
            AddFamilyMemberModel(
                "10",
                "50",
            )
        )
    }

    fun removeDay(position: Int, ) {
        this.list.removeAt(position)
        notifyItemRemoved(position)
        // if (this.list.size > 0)
        notifyItemChanged(this.list.size - 1)
    }

    fun changeValue(isFirstOption: Boolean) {
        isAtFirstPos = isFirstOption
    }

    override fun getItemCount(): Int {
        return list.size
    }
}