package com.example.mypraticeapplication.view.base

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.uttils.Session
import com.example.mypraticeapplication.view.dialougs.ProgressDialog


open class BaseFragment : Fragment() {
    lateinit var mContext: Context
    lateinit var mActivity: Activity
    private var progressDialog: ProgressDialog? = null
    lateinit var session: Session


    override fun onAttach(context: Context) {
        super.onAttach(context)

        mContext = context
        mActivity = context as Activity
        session = Session(mActivity)

    }

    fun showProgressbar(message: String? = requireActivity().getString(R.string.please_wait)) {
        hideProgressbar()
        if (progressDialog == null) {
            progressDialog = ProgressDialog(requireContext(), message)
        }
        progressDialog?.show()
    }


     fun hideProgressbar() {
        if (isAdded&&progressDialog != null && progressDialog?.isShowing!!) progressDialog!!.dismiss()
    }

}
