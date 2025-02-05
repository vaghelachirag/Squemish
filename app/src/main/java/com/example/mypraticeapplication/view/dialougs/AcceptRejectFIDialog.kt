package com.example.mypraticeapplication.view.dialougs

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.DialogAddInventorySubitemBinding

class AcceptRejectFIDialog(
    var mContext: Context,
    val acceptReasonList: List<String>,
    val isAcceptReject: Boolean
) : Dialog(mContext, R.style.ThemeDialog) {

    private lateinit var binding: DialogAddInventorySubitemBinding
    private var listener: OkButtonListener? = null

    private var acceptRejectListSpinnerAdapter: ArrayAdapter<String?>? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        setCanceledOnTouchOutside(false)
        setCancelable(false)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_add_inventory_subitem, null, false)

        if(isAcceptReject){
            binding.txtHeader.text = "Select Accept Reason"
        }
        else{
            binding.txtHeader.text = "Select Reject Reason"
        }

        acceptRejectListSpinnerAdapter =
            ArrayAdapter<String?>(context, android.R.layout.simple_spinner_item, acceptReasonList)
        acceptRejectListSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

        binding.spnAcceptReject.adapter = acceptRejectListSpinnerAdapter

        setContentView(binding.root)

        binding.ivClose.setOnClickListener {
            dismiss()
        }

        binding.btnSave.setOnClickListener {
            if (listener != null) {
                    listener?.onOkPressed(
                        this,
                        binding.spnAcceptReject.selectedItem.toString(),
                        isAcceptReject
                    )

                }
            }
        }
    fun setListener(listener: OkButtonListener?): AcceptRejectFIDialog {
        this.listener = listener
        return this
    }
    interface OkButtonListener {
        fun onOkPressed(acceptRejectFIDialog : AcceptRejectFIDialog, selectedReason: String?, isAcceptReject: Boolean)
    }
}