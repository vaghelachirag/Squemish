package com.example.mypraticeapplication.view.detail.fiRequest

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypraticeapplication.databinding.FragmentDocumentProfileVerificationBinding
import com.example.mypraticeapplication.databinding.FragmentRcoVerificationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.DocumentProfileVerificationViewModel
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCOVerificationViewModel

class FragmentDocumentProfileVerification : BaseFragment(), FragmentLifecycleInterface {

    private var _binding: FragmentDocumentProfileVerificationBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    var data : String = ""
    private val documentProfileVerification by lazy { DocumentProfileVerificationViewModel( context as Activity,binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDocumentProfileVerificationBinding.inflate(inflater, container, false)
        binding.viewModel = documentProfileVerification
        binding.lifecycleOwner = this
        return binding.root
    }

    companion object {

        fun newInstance(selectedData: GetVerificationDetailData?): FragmentDocumentProfileVerification {
            val bundle = Bundle()
            //  bundle.putSerializable(DATA, selectedData)
            val fragmentDocumentProfileVerification = FragmentDocumentProfileVerification()
            fragmentDocumentProfileVerification.arguments = bundle
            return fragmentDocumentProfileVerification
        }
    }

    override fun onPauseFragment() {

    }

    override fun onResumeFragment(s: String?) {

    }
}