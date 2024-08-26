package com.example.mypraticeapplication.view.adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ItemAddFamilymemberBinding
import com.example.mypraticeapplication.model.saveresidenceverification.SaveResidanceApplicantFamilyDetail
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCUVerificationViewModel


@Suppress("UNUSED_EXPRESSION")
class AddFamilyMemberAdapter(
    private var additionalList: ArrayList<SaveResidanceApplicantFamilyDetail>,
    private val viewModel: RCUVerificationViewModel,
    private val clickListener: ContactClickListener,

) :
    RecyclerView.Adapter<AddFamilyMemberAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemAddFamilymemberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(model: SaveResidanceApplicantFamilyDetail, viewModel: RCUVerificationViewModel) {

            binding.edtMemberCount.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) { if (!s.isNullOrEmpty())
                    model.memberCount = Integer.parseInt(s.toString())
                    viewModel.setTotalMemberMember()
                    Log.e("Changed", "FirstName" + s.toString())
                }
            })
            false

            binding.edtEaringMemberCount.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) { if (!s.isNullOrEmpty())
                    model.earningMemberCount = Integer.parseInt(s.toString())
                    viewModel.setTotalMemberMember()
                    Log.e("Changed", "FirstName" + s.toString())
                }
            })
            false
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAddFamilymemberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemData = additionalList[position]
        holder.binding.executePendingBindings()

        holder.bindItem(additionalList[position],viewModel)

        holder.binding.btnAddDay.setOnClickListener {
            clickListener.addFamilyMember(position)
        }
        holder.binding.btnRemoveDay.setOnClickListener {
            clickListener.removeContact(position, additionalList[position].getRecordId(), holder.binding.root.context)
        }

        relationWithApplicantSpinnerAdapter = ArrayAdapter<String?>(context, android.R.layout.simple_spinner_item, relationWithApplicantList)
        relationWithApplicantSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)
        holder.binding.spnRelation.setListAdapter(relationWithApplicantList)

    }

    override fun getItemCount(): Int {
        return additionalList.size
    }

    fun updateList(additionalList: ArrayList<SaveResidanceApplicantFamilyDetail>) {
        this.additionalList = additionalList
        notifyDataSetChanged()
    }

    /**
     * Interface handles click event of Feeds ItemView
     * */
    interface ContactClickListener {
        fun removeContact(
            position: Int,
            id: Int?,
            context: Context
        )
        fun addFamilyMember(
            position: Int,
        )
    }
}