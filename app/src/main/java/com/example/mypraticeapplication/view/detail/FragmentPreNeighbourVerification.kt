package com.example.mypraticeapplication.view.detail

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import com.example.mypraticeapplication.databinding.FragmentPreNeighbourVerificationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility.Companion.setAllEnabled
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.PreNeighbourVerificationViewModel

class FragmentPreNeighbourVerification : BaseFragment(), FragmentLifecycleInterface {

    private var _binding: FragmentPreNeighbourVerificationBinding? = null

    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    private val preNeighbourVerificationViewModel by lazy { PreNeighbourVerificationViewModel(context as Activity) }

    var data : String = ""


    companion object {
        fun newInstance(selectedData: GetVerificationDetailData?): FragmentPreNeighbourVerification {
            val bundle = Bundle()
            //  bundle.putSerializable(DATA, selectedData)
            val fragmentPreNeighbourVerification = FragmentPreNeighbourVerification()
            fragmentPreNeighbourVerification.arguments = bundle
            return fragmentPreNeighbourVerification
        }
    }


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPreNeighbourVerificationBinding.inflate(inflater, container, false)
        binding.viewModel = preNeighbourVerificationViewModel
        binding.lifecycleOwner = this
        context?.let { preNeighbourVerificationViewModel.init(it) }

        preNeighbourVerificationViewModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }

        preNeighbourVerificationViewModel.isNeighbourReconised.observeForever {
            if (it){
                binding.inpReason.visibility = View.GONE
                binding.edtReason.setText("")
            }
            else{
                binding.inpReason.visibility = View.VISIBLE
            }
        }

        setView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setView() {
        if(ActivityDetail.selectedData!!.getStatus() != null){
            if(ActivityDetail.selectedData!!.getStatus() == AppConstants.statusPending){
                binding.constraintLayout.forEach { child -> child.setAllEnabled(false) }
            }
            else{
                binding.constraintLayout.forEach { child -> child.setAllEnabled(true) }
            }
        }
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