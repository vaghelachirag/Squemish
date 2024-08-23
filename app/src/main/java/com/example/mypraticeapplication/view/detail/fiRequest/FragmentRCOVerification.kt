package com.example.mypraticeapplication.view.detail.fiRequest

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypraticeapplication.databinding.FragmentRcoVerificationBinding
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.view.detail.FragmentRCUVerification
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCOVerificationViewModel
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCUVerificationViewModel

class FragmentRCOVerification: BaseFragment(), FragmentLifecycleInterface {

    private var _binding: FragmentRcoVerificationBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    var data : String = ""
    private val rcuVerificationViewModel by lazy { RCOVerificationViewModel( context as Activity,binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRcoVerificationBinding.inflate(inflater, container, false)
        binding.viewModel = rcuVerificationViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    companion object {

        fun newInstance(selectedData: GetVerificationDetailData?): FragmentRCOVerification {
            val bundle = Bundle()
            //  bundle.putSerializable(DATA, selectedData)
            val fragmentRCOVerification = FragmentRCOVerification()
            fragmentRCOVerification.arguments = bundle
            return fragmentRCOVerification
        }
    }

    override fun onPauseFragment() {

    }

    override fun onResumeFragment(s: String?) {

    }
}