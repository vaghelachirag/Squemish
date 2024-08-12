package com.example.mypraticeapplication.view
import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.transition.Visibility
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.view.base.BaseActivity
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCUVerificationViewModel


@Suppress("CAST_NEVER_SUCCEEDS")
class ActivityTest: BaseActivity()  {

    private lateinit var binding: FragmentRcuVerificationBinding

    private val rcuVerificationViewModel by lazy { RCUVerificationViewModel(this,binding) }


    @SuppressLint("DiscouragedPrivateApi", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentRcuVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = rcuVerificationViewModel
        binding.lifecycleOwner = this
        rcuVerificationViewModel.init(this)

        setObserver()


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
                binding.llAddressDetail.inpRemark.visibility = View.GONE
            }
            else{
                binding.llAddressDetail.inpRemark.visibility = View.VISIBLE
            }
        }


        // NameBoard Confirmed
        rcuVerificationViewModel.isNameboardseenattheHouse.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llPersonalInformation.llNameboardMismatched.visibility = View.VISIBLE
            }
            else{
                binding.llPersonalInformation.llNameboardMismatched.visibility = View.GONE
            }
        }

        // Name Board Mismatched
        rcuVerificationViewModel.isNameboardmismatched.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llPersonalInformation.inpApplicantReasonLabel.visibility = View.VISIBLE
            }
            else{
                binding.llPersonalInformation.inpApplicantReasonLabel.visibility = View.GONE
            }
        }

        // Major Medical History
        rcuVerificationViewModel.isMajorMedicalHistory.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.inpMedicalHistoryRemark.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.inpMedicalHistoryRemark.visibility = View.GONE
            }
        }


        // Political Connection
        rcuVerificationViewModel.isAnyPoliticalIssue.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.inpIsapplicanthaveanypoliticalconnectionRemark.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.inpIsapplicanthaveanypoliticalconnectionRemark.visibility = View.GONE
            }
        }


        // Political Connection
        rcuVerificationViewModel.isAnyLoanRunning.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.llOtherLoan.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.llOtherLoan.visibility = View.GONE
            }
        }

        // Political Connection
        rcuVerificationViewModel.isAreaNegative.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.inpapplicantIsAreaNegativeLabel.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.inpapplicantIsAreaNegativeLabel.visibility = View.GONE
            }
        }

        // Political Connection
        rcuVerificationViewModel.isCastCommunityDominatedArea.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llApplicationBackground.inpapplicantIsCastCommunityDominatedAreaLabel.visibility = View.VISIBLE
            }
            else{
                binding.llApplicationBackground.inpapplicantIsCastCommunityDominatedAreaLabel.visibility = View.GONE
            }
        }

    }

    private fun setVisibility(visibility: Boolean) {
        if (visibility){
            binding.llAddressDetail.llAddressConfirmed.visibility =   View.GONE
            binding.llPersonalInformation.root.visibility = View.VISIBLE
            binding.llApplicationBackground.root.visibility = View.VISIBLE
            binding.llAddressDetail.llAddressNotConfirmed.visibility = View.VISIBLE
        }
        else{
            binding.llAddressDetail.llAddressConfirmed.visibility =   View.VISIBLE
            binding.llPersonalInformation.root.visibility = View.GONE
            binding.llApplicationBackground.root.visibility = View.GONE
            binding.llAddressDetail.llAddressNotConfirmed.visibility = View.GONE
        }


    }

}