package com.example.mypraticeapplication.view.menu

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.DashboardFragmentBinding
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestData
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Session.Companion.DATA
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.view.detail.ActivityDetail
import com.example.mypraticeapplication.viewmodel.DashboardViewModel


class DashboardFragment: BaseFragment() {

    private var _binding: DashboardFragmentBinding? = null

    private val binding get() = _binding!!
    private val dashboardViewModel by lazy { DashboardViewModel(activity as Context,this@DashboardFragment,binding) }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DashboardFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = dashboardViewModel
        binding.lifecycleOwner = this


        dashboardViewModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }

        dashboardViewModel.totalVerification.observeForever {
            binding.totalVerificationCount.text = dashboardViewModel.totalVerification.value.toString()
        }

        return binding.root
    }

    fun  redirectToDetailScreen(getPendingRequestData: GetPendingRequestData) {
        val bundle = Bundle()
        bundle.putSerializable(DATA, getPendingRequestData.getFirequestId())
        AppConstants.verificationId = getPendingRequestData.getFirequestId()!!
        //findNavController().navigate(R.id.action_DashboardFragment_to_FragmentDetail)

        val iDetain = Intent(context,ActivityDetail::class.java)
        startActivity(iDetain)
    }

    override fun onResume() {
        super.onResume()
        dashboardViewModel.init(requireContext())
    }
}