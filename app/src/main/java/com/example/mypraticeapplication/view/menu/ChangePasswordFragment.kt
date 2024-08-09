package com.example.mypraticeapplication.view.menu

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypraticeapplication.databinding.ChangePasswordFragmentBinding
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.ChangePasswordViewModel

class ChangePasswordFragment: BaseFragment() {

    private var _binding: ChangePasswordFragmentBinding? = null

    private val binding get() = _binding!!
 //   private val changePasswordViewModel by lazy { ChangePasswordViewModel(activity as Context,binding) }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ChangePasswordFragmentBinding.inflate(inflater, container, false)
      //  binding.viewModel = changePasswordViewModel
        binding.lifecycleOwner = this


       /* changePasswordViewModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }*/

        return binding.root
    }

}