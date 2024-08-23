package com.example.mypraticeapplication.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import com.example.mypraticeapplication.databinding.FragmentFinalSubmitBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility.Companion.setAllEnabled
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.FinalSubmitViewModel

class FragmentFinalSubmit  : BaseFragment(), FragmentLifecycleInterface {

    private var _binding: FragmentFinalSubmitBinding? = null

    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    private val finalSubmitViewModel by lazy { context?.let { FinalSubmitViewModel(it,binding) } }

    var data : String = ""



    companion object {
        fun newInstance(selectedData: GetVerificationDetailData?): FragmentFinalSubmit {
            val bundle = Bundle()
            //  bundle.putSerializable(DATA, selectedData)
            val fragmentFinalSubmit = FragmentFinalSubmit()
            fragmentFinalSubmit.arguments = bundle
            return fragmentFinalSubmit
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFinalSubmitBinding.inflate(inflater, container, false)
        binding.viewModel = finalSubmitViewModel
        binding.lifecycleOwner = this
        finalSubmitViewModel!!.init(context)
        setView()
        return binding.root
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        finalSubmitViewModel!!.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
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