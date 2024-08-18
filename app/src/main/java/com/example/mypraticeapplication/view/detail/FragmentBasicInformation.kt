package com.example.mypraticeapplication.view.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypraticeapplication.databinding.FragmentBasicInformationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.view.menu.DashboardActivity
import com.example.mypraticeapplication.viewmodel.verificationDetail.BasicInformationViewModel

class FragmentBasicInformation  : BaseFragment(), FragmentLifecycleInterface {

    private var _binding: FragmentBasicInformationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val basicInformationModel by lazy { BasicInformationViewModel(activity as Context,binding) }

    var data : String = ""


    companion object {
        fun newInstance(selectedData: GetVerificationDetailData?): FragmentBasicInformation {
            val bundle = Bundle()
          //  bundle.putSerializable(DATA, selectedData)
            val fragmentEnquiry = FragmentBasicInformation()
            fragmentEnquiry.arguments = bundle
            return fragmentEnquiry
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBasicInformationBinding.inflate(inflater, container, false)
        binding.viewModel = basicInformationModel
        binding.lifecycleOwner = this
        context?.let { basicInformationModel.init() }
        setView()
        setAction()

        basicInformationModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }

        return binding.root
    }

    private fun setAction() {
        binding.btnAccept.setOnClickListener {
            basicInformationModel.showAcceptRejectDialoug(true)
        }
        binding.btnReject.setOnClickListener {
            basicInformationModel.showAcceptRejectDialoug(false)
        }
    }


    private fun setView() {
        if(ActivityDetail.selectedData!!.getStatus() != null){
           if(ActivityDetail.selectedData!!.getStatus() == AppConstants.statusPending){
               binding.llAcceptReject.visibility = View.VISIBLE
           }
            else{
               binding.llAcceptReject.visibility = View.GONE
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun redirectToDashboardScreen(){
      val intent = Intent(activity, DashboardActivity:: class.java)
       intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
       (activity as Activity).finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPauseFragment() {

    }

    override fun onResumeFragment(s: String?) {

    }
}