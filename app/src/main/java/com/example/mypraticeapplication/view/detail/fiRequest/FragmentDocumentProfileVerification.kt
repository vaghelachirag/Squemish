package com.example.mypraticeapplication.view.detail.fiRequest

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypraticeapplication.databinding.FragmentDocumentProfileVerificationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.DocumentProfileVerificationViewModel


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
        documentProfileVerification.init(context)
        setObserver()
        documentProfileVerification.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }

        return binding.root
    }

    private fun setObserver() {

        // Address Confirmed
        documentProfileVerification.isAddressConfirmed.observeForever {
            try {
                setVisibility(it)
            }catch (_: Exception){
            }
        }

        // Office Open
        documentProfileVerification.isOfficeOpen.observeForever {
            if (it == true){
                binding.llAddressDetail.radioOfficeOpenYes.isChecked = true
                setHouseOpenVisibility(true)
            }
            if (it == false){
                binding.llAddressDetail.radioOfficeOpenNo.isChecked = true
                binding.llAddressDetail.inpapplicantReason.visibility =  View.GONE
                setHouseOpenVisibility(false)
            }
        }

        // Document Signed Open
        documentProfileVerification.isDocumentSigned.observeForever {
            if (it == true){
                binding.llAddressDetail.radioApplicantDocumentSignedYes.isChecked = true
                binding.llAddressDetail.llAuthorizePerson.visibility = View.VISIBLE
            }
            if (it == false){
                binding.llAddressDetail.radioApplicantDocumentSignedNo.isChecked = true
                binding.llAddressDetail.llAuthorizePerson.visibility = View.GONE
            }
        }
        // Personally Met
        documentProfileVerification.isPersonallyMet.observeForever {
            if (it == true){
                binding.llAddressDetail.radioApplicantPersonallyMetWithAuthorisedLabelYes.isChecked = true
            }
            if (it == false){
                binding.llAddressDetail.radioApplicantPersonallyMetWithAuthorisedLabelSignedNo.isChecked = true
            }
        }

        // Any Proof
        documentProfileVerification.isAnyProof.observeForever {
            if (it == true){
                binding.llAddressDetail.radioApplicantIsAnyProofLabelYes.isChecked = true
                binding.llAddressDetail.inpapplicantNameOfDocumentLabel.visibility = View.VISIBLE
            }
            if (it == false){
                binding.llAddressDetail.radioApplicantIsAnyProofLabelNo.isChecked = true
                binding.llAddressDetail.inpapplicantNameOfDocumentLabel.visibility = View.GONE
            }
        }
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
    private fun setHouseOpenVisibility(visibility: Boolean) {
        if (visibility){
            binding.llAddressDetail.llPersonMet.visibility = View.VISIBLE
            binding.llAddressDetail.llPersonallyMet.visibility = View.VISIBLE
            binding.llAddressDetail.llDocumentSigned.visibility = View.VISIBLE
            binding.llAddressDetail.llAuthorizePerson.visibility = View.VISIBLE
            binding.llAddressDetail.llPersonMet.visibility = View.VISIBLE
            binding.llAddressDetail.llAnyProofMet.visibility = View.VISIBLE
            binding.llAddressDetail.inpapplicantNameOfDocumentLabel.visibility = View.VISIBLE
            binding.llAddressDetail.llAddressConfirmed.visibility = View.VISIBLE
            binding.llAddressDetail.inpapplicantReason.visibility =  View.GONE
        }
        else{
            binding.llAddressDetail.llPersonMet.visibility = View.GONE
            binding.llAddressDetail.llPersonallyMet.visibility = View.GONE
            binding.llAddressDetail.llDocumentSigned.visibility = View.GONE
            binding.llAddressDetail.llAuthorizePerson.visibility = View.GONE
            binding.llAddressDetail.llAnyProofMet.visibility = View.GONE
            binding.llAddressDetail.inpapplicantNameOfDocumentLabel.visibility = View.GONE
            binding.llAddressDetail.llAddressConfirmed.visibility = View.VISIBLE
            binding.llAddressDetail.inpapplicantReason.visibility =  View.GONE
        }
    }

    private fun setVisibility(visibility: Boolean) {
        if (visibility){
            binding.llAddressDetail.radioAddressConfirmedYes.isChecked = true
            binding.llAddressDetail.llOfficeOpen.visibility = View.VISIBLE
            binding.llAddressDetail.llPersonMet.visibility = View.VISIBLE
            binding.llAddressDetail.llPersonallyMet.visibility = View.VISIBLE
            binding.llAddressDetail.llDocumentSigned.visibility = View.VISIBLE
            binding.llAddressDetail.llAuthorizePerson.visibility = View.VISIBLE
            binding.llAddressDetail.llPersonMet.visibility = View.VISIBLE
            binding.llAddressDetail.llAnyProofMet.visibility = View.VISIBLE
            binding.llAddressDetail.inpapplicantNameOfDocumentLabel.visibility = View.VISIBLE
            binding.llAddressDetail.llAddressConfirmed.visibility = View.VISIBLE
            binding.llAddressDetail.inpapplicantReason.visibility = View.GONE
        }
        else{
            binding.llAddressDetail.radioAddressConfirmedNo.isChecked = true
            binding.llAddressDetail.llOfficeOpen.visibility = View.GONE
            binding.llAddressDetail.llPersonMet.visibility = View.GONE
            binding.llAddressDetail.llPersonallyMet.visibility = View.GONE
            binding.llAddressDetail.llDocumentSigned.visibility = View.GONE
            binding.llAddressDetail.llAuthorizePerson.visibility = View.GONE
            binding.llAddressDetail.llAnyProofMet.visibility = View.GONE
            binding.llAddressDetail.inpapplicantNameOfDocumentLabel.visibility = View.GONE
            binding.llAddressDetail.llAddressConfirmed.visibility = View.VISIBLE
            binding.llAddressDetail.inpapplicantReason.visibility = View.VISIBLE
        }

    }
}