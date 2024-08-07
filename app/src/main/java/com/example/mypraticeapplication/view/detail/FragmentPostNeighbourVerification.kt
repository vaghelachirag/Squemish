package com.example.mypraticeapplication.view.detail

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import com.example.mypraticeapplication.databinding.FragmentPostNeighbourVerificationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility.Companion.setAllEnabled
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.PostNeighbourVerificationViewModel


class FragmentPostNeighbourVerification  : BaseFragment(), FragmentLifecycleInterface {


    private var _binding: FragmentPostNeighbourVerificationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val postNeighbourVerificationViewModel by lazy { PostNeighbourVerificationViewModel(context as Activity,binding) }

    var data : String = ""



    companion object {
        fun newInstance(selectedData: GetVerificationDetailData?): FragmentPostNeighbourVerification {
            val bundle = Bundle()
            //  bundle.putSerializable(DATA, selectedData)
            val fragmentPostNeighbourVerification = FragmentPostNeighbourVerification()
            fragmentPostNeighbourVerification.arguments = bundle
            return fragmentPostNeighbourVerification
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPostNeighbourVerificationBinding.inflate(inflater, container, false)
        binding.viewModel = postNeighbourVerificationViewModel
        binding.lifecycleOwner = this
        context?.let { postNeighbourVerificationViewModel.init(it) }
//      basicInformationModel.init(context, FragmentDetail.selectedData!!)

        postNeighbourVerificationViewModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }
        setView()
        return binding.root
    }

    private fun setView() {
        postNeighbourVerificationViewModel.isNeighbourReconised.observeForever {
            if (it){
                binding.inpReason.visibility = View.GONE
                binding.edtReason.setText("")
            }
            else{
                binding.inpReason.visibility = View.VISIBLE
            }
        }


        if(ActivityDetail.selectedData!!.getStatus() != null){
            if(ActivityDetail.selectedData!!.getStatus() == AppConstants.statusPending){
                binding.constraintLayout.forEach { child -> child.setAllEnabled(false) }
            }
            else{
                binding.constraintLayout.forEach { child -> child.setAllEnabled(true) }
            }
        }
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