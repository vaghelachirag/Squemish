package com.example.mypraticeapplication.view.detail

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCUVerificationViewModel

class FragmentPhotograph: BaseFragment(), FragmentLifecycleInterface {


    private var _binding: FragmentRcuVerificationBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    var data : String = ""
    private val rcuVerificationViewModel by lazy { RCUVerificationViewModel( context as Activity,binding) }

    private val locationPermissionCode = 2


    companion object {
        fun newInstance(selectedData: GetVerificationDetailData?): FragmentRCUVerification {
            val bundle = Bundle()
            //  bundle.putSerializable(DATA, selectedData)
            val fragmentRCUVerification = FragmentRCUVerification()
            fragmentRCUVerification.arguments = bundle
            return fragmentRCUVerification
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRcuVerificationBinding.inflate(inflater, container, false)
        binding.viewModel = rcuVerificationViewModel
        binding.lifecycleOwner = this
        rcuVerificationViewModel.init(context)


        rcuVerificationViewModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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