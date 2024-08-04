package com.example.mypraticeapplication.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCUVerificationViewModel

class FragmentRCUVerification : BaseFragment(), FragmentLifecycleInterface {

    private var _binding: FragmentRcuVerificationBinding? = null

    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    private val postNeighbourVerificationViewModel by lazy { RCUVerificationViewModel() }

    var data : String = ""



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
        binding.viewModel = postNeighbourVerificationViewModel
        binding.lifecycleOwner = this
//        basicInformationModel.init(context, FragmentDetail.selectedData!!)
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