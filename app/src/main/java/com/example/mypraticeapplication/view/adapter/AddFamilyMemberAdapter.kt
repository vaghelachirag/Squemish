package com.example.mypraticeapplication.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ItemAddFamilymemberBinding
import com.example.mypraticeapplication.model.getverificationDetailResponse.AddFamilyMemberModel
import com.example.mypraticeapplication.model.saveresidenceverification.SaveResidanceApplicantFamilyDetail
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.view.detail.ActivityDetail
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCUVerificationViewModel

class AddFamilyMemberAdapter(val context: Context, private val list: ArrayList<SaveResidanceApplicantFamilyDetail>, private val relationWithApplicantList: List<String>?, private val viewModel: RCUVerificationViewModel, private var listener: OnItemClickListener) :  RecyclerView.Adapter<AddFamilyMemberViewHolder>() {

    var isAtFirstPos: Boolean = false
    private var relationWithApplicantSpinnerAdapter: ArrayAdapter<String?>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddFamilyMemberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binder = DataBindingUtil.inflate<ItemAddFamilymemberBinding>(layoutInflater, R.layout.item_add_familymember, parent, false)
        return AddFamilyMemberViewHolder(binder)
    }

    interface OnItemClickListener {

        fun onItemClick(position: Int, )

        fun onRemoveClick(position: Int, )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AddFamilyMemberViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(list[position])

        if (!relationWithApplicantList.isNullOrEmpty()){
            relationWithApplicantSpinnerAdapter = ArrayAdapter<String?>(context, android.R.layout.simple_spinner_item, relationWithApplicantList)
            relationWithApplicantSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)
            holder.binding.spnRelation.setListAdapter(relationWithApplicantList)
        }

        if (position < list.size) {

            holder.binding.edtMemberCount.setText(list[position].getMemberCount().toString())
            holder.binding.edtEaringMemberCount.setText(list[position].getEarningMemberCount().toString())

            holder.binding.edtMemberCount.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    if (position > 1){
                        list[position - 1].memberCount = 1
                    }
                /*   list[position - 1].memberCount = Utility.getParseInteger(holder.binding.edtMemberCount.text.toString())
                    viewModel.setTotalMemberMember()*/
                }
            })
            holder.binding.edtEaringMemberCount.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (position > 1){
                        list[position - 1].earningMemberCount = Utility.getParseInteger(holder.binding.edtEaringMemberCount.text.toString())
                    }
                    else{

                    }
                    viewModel.setTotalMemberMember()

                 //   list[position].isStaticData = false
                 //  viewModel.setTotalMemberMember()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })
        }

        holder.binding.spnRelation.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                //  list[position].earningMemberCount = Utility.getParseInteger(holder.binding.edtEaringMemberCount.text.toString())
                //  viewModel.setTotalMemberMember()
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.e("Change",p0.toString())
                list[position].setRelation(p0.toString())
            }
        })

        holder.binding.btnAddDay.setOnClickListener {
            listener.onItemClick(position)
            notifyItemChanged(position + 1)
            viewModel.setTotalMemberMember()
        }

        holder.binding.btnRemoveDay.setOnClickListener {
            if (position == 1){
                this.list.removeAt(position)
                notifyItemRemoved(position)
                notifyItemChanged(this.list.size - 1)
            }
            else{
                if (this.list[position - 1].isStaticData == true) {
                    this.list.removeAt(position - 1)
                }
                notifyItemRemoved(position)
                // if (this.list.size > 0)
                notifyItemChanged(this.list.size - 1)
            }
        }

        if (position == list.size - 1)
            holder.binding.btnAddDay.visibility = View.VISIBLE
        else
            holder.binding.btnAddDay.visibility = View.GONE

        if (position == 0)
            holder.binding.btnRemoveDay.visibility = View.GONE
        else
            holder.binding.btnRemoveDay.visibility = View.VISIBLE
    }

    fun addDay() {
        val saveResidenceApplicantFamilyDetail  =  SaveResidanceApplicantFamilyDetail()
        saveResidenceApplicantFamilyDetail.setRecordId(0)
        saveResidenceApplicantFamilyDetail.setFirequestId(AppConstants.verificationId)
        saveResidenceApplicantFamilyDetail.setMemberCount(1)
        saveResidenceApplicantFamilyDetail.setEarningMemberCount(1)
        saveResidenceApplicantFamilyDetail.setRelation("Select")
        saveResidenceApplicantFamilyDetail.isStaticData  = true

        list.add(saveResidenceApplicantFamilyDetail)
    }

    fun removeDay(position: Int, ) {
        this.list.removeAt(position)
        notifyItemRemoved(position)
        // if (this.list.size > 0)
     //   notifyItemChanged(this.list.size - 1)
    }

    fun changeValue(isFirstOption: Boolean) {
        isAtFirstPos = isFirstOption
    }

    override fun getItemCount(): Int {
        return list.size
    }
}