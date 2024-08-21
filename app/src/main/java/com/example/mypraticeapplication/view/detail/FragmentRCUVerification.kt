package com.example.mypraticeapplication.view.detail

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCUVerificationViewModel

class FragmentRCUVerification : BaseFragment(), FragmentLifecycleInterface {

    private var _binding: FragmentRcuVerificationBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    var data : String = ""
    private val rcuVerificationViewModel by lazy { RCUVerificationViewModel( context as Activity,binding) }


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
//        basicInformationModel.init(context, FragmentDetail.selectedData!!)
        rcuVerificationViewModel.init(context)
        setObserver()


        rcuVerificationViewModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    private fun setObserver() {

        // Address Confirmed
        rcuVerificationViewModel.isAddressConfirmed.observeForever {
            setVisibility(it)
        }


        // Address Belong Confirmed
        rcuVerificationViewModel.isAddressBelong.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llAddressDetail.rbAddressBelongYes.isChecked = true
                binding.llAddressDetail.inpAddressBelongRemark.visibility = View.GONE
                binding.llAddressDetail.llHouseIsOpen.visibility = View.VISIBLE
                binding.llPersonalInformation.llPersonalInformationOne.llRelationWithApplicant.visibility = View.VISIBLE
                binding.llPersonalInformation.llPersonalInformationOne.root.visibility = View.VISIBLE
                binding.llPersonalInformation.llHouseSize.visibility = View.VISIBLE
                binding.llPersonalInformation.llPersonalInformationOne.llFamilyMember.visibility = View.VISIBLE
                binding.llPersonalInformation.llPersonalInformationOne.llFamilyMemberCount.visibility = View.VISIBLE
                binding.llPersonalInformation.llPersonalInformationOne.llHouseOwnership.visibility = View.VISIBLE
                binding.llPersonalInformation.llPersonalInformationOne.llStayingAddress.visibility = View.VISIBLE
                binding.llPersonalInformation.llHouseSize.visibility = View.VISIBLE
                binding.llPersonalInformation.llPersonalInformationOne.llRent.visibility = View.VISIBLE
                binding.llPersonalInformation.llPersonalInformationOne.llAge.visibility = View.VISIBLE
            }
            else{
                binding.llAddressDetail.rbAddressBelongNo.isChecked = true
                binding.llAddressDetail.inpAddressBelongRemark.visibility = View.VISIBLE
                binding.llAddressDetail.llHouseIsOpen.visibility = View.GONE
                binding.llPersonalInformation.llPersonalInformationOne.llRelationWithApplicant.visibility = View.GONE
                binding.llPersonalInformation.llPersonalInformationOne.root.visibility = View.VISIBLE
                binding.llPersonalInformation.llHouseSize.visibility = View.VISIBLE
                binding.llPersonalInformation.llPersonalInformationOne.llFamilyMember.visibility = View.GONE
                binding.llPersonalInformation.llPersonalInformationOne.llFamilyMemberCount.visibility = View.GONE
                binding.llPersonalInformation.llPersonalInformationOne.llHouseOwnership.visibility = View.GONE
                binding.llPersonalInformation.llPersonalInformationOne.llStayingAddress.visibility = View.GONE
                binding.llPersonalInformation.llHouseSize.visibility = View.GONE
                binding.llPersonalInformation.llPersonalInformationOne.llRent.visibility = View.GONE
                binding.llPersonalInformation.llPersonalInformationOne.llAge.visibility = View.GONE
            }
        }

        // NameBoard Confirmed
        rcuVerificationViewModel.isNameboardseenattheHouse.observeForever {
            if (it == true){
                binding.llPersonalInformation.rbIsNameboardseenattheHouseYes.isChecked = true
                binding.llPersonalInformation.llNameboardMismatched.visibility = View.VISIBLE
            }
            else{
                binding.llPersonalInformation.rbIsNameboardseenattheHouseNo.isChecked = true
                binding.llPersonalInformation.llNameboardMismatched.visibility = View.GONE
            }
        }

        // Name Board Mismatched
        rcuVerificationViewModel.isNameboardmismatched.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llPersonalInformation.rbApplicantIsNameboardseenattheHouseLabelYes.isChecked = true
                binding.llPersonalInformation.inpApplicantReasonLabel.visibility = View.VISIBLE
            }
            else{
                binding.llPersonalInformation.rbApplicantIsNameboardseenattheHouseLabeleNo.isChecked = true
                binding.llPersonalInformation.inpApplicantReasonLabel.visibility = View.GONE
            }
        }

        // Major Medical History
        rcuVerificationViewModel.isMajorMedicalHistory.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.rbIsapplicanthaveanymajormedicalhistoryYes.isChecked = true
                binding.llApplicationBackground.inpMedicalHistoryRemark.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.rbIsapplicanthaveanymajormedicalhistoryNo.isChecked = true
                binding.llApplicationBackground.inpMedicalHistoryRemark.visibility = View.GONE
            }
        }


        // Political Connection
        rcuVerificationViewModel.isAnyPoliticalIssue.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.rbIsapplicanthaveanypoliticalconnectionYes.isChecked = true
                binding.llApplicationBackground.inpIsapplicanthaveanypoliticalconnectionRemark.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.rbIsapplicanthaveanypoliticalconnectionNo.isChecked = true
                binding.llApplicationBackground.inpIsapplicanthaveanypoliticalconnectionRemark.visibility = View.GONE
            }
        }


        // Political Connection
        rcuVerificationViewModel.isAnyLoanRunning.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.rbApplicantIsanyotherloanrunningLabelYes.isChecked = true
                binding.llApplicationBackground.llOtherLoan.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.rbRbApplicantIsanyotherloanrunningLabelNo.isChecked = true
                binding.llApplicationBackground.llOtherLoan.visibility = View.GONE
            }
        }

        // Political Connection
        rcuVerificationViewModel.isAreaNegative.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.rbApplicantIsAreaNegativeLabelYes.isChecked = true
                binding.llApplicationBackground.inpapplicantIsAreaNegativeLabel.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.rbApplicantIsAreaNegativeLabelNo.isChecked = true
                binding.llApplicationBackground.inpapplicantIsAreaNegativeLabel.visibility = View.GONE
            }
        }

        // Political Connection
        rcuVerificationViewModel.isCastCommunityDominatedArea.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.rbApplicantIsCastCommunityDominatedAreaYes.isChecked = true
                binding.llApplicationBackground.inpapplicantIsCastCommunityDominatedAreaLabel.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.rbApplicantIsCastCommunityDominatedAreaNo.isChecked = true
                binding.llApplicationBackground.inpapplicantIsCastCommunityDominatedAreaLabel.visibility = View.GONE
            }
        }

        // Political Connection
        rcuVerificationViewModel.isHouseOpen.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llAddressDetail.radioDurningVisitYes.isChecked = true
                binding.llPersonalInformation.llPersonalInformationOne.root.visibility = View.VISIBLE
                binding.llPersonalInformation.llHouseSize.visibility = View.VISIBLE
            }
            else{
                binding.llAddressDetail.radioDurningVisitNo.isChecked = true
                binding.llPersonalInformation.llPersonalInformationOne.root.visibility = View.GONE
                binding.llPersonalInformation.llHouseSize.visibility = View.GONE
            }
        }

        // Political Connection
        rcuVerificationViewModel.isHouseRented.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llPersonalInformation.llPersonalInformationOne.llRent.visibility = View.VISIBLE
            }
            else{
                binding.llPersonalInformation.llPersonalInformationOne.llRent.visibility = View.GONE
            }
        }
    }


    private fun setVisibility(visibility: Boolean) {
        if (visibility){
            binding.llAddressDetail.radioAddressConfirmedYes.isChecked = true
            binding.llAddressDetail.llAddressConfirmed.visibility =   View.GONE
            binding.llPersonalInformation.root.visibility = View.VISIBLE
            binding.llApplicationBackground.root.visibility = View.VISIBLE
            binding.llAddressDetail.llAddressNotConfirmed.visibility = View.VISIBLE
        }
        else{
            binding.llAddressDetail.radioAddressConfirmedNo.isChecked = true
            binding.llAddressDetail.llAddressConfirmed.visibility =   View.VISIBLE
            binding.llPersonalInformation.root.visibility = View.GONE
            binding.llApplicationBackground.root.visibility = View.GONE
            binding.llAddressDetail.llAddressNotConfirmed.visibility = View.GONE
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