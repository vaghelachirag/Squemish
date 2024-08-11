package com.example.mypraticeapplication.view
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.view.base.BaseActivity
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCUVerificationViewModel

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
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llAddressConfirmed.visibility = View.GONE
            }
            else{
                binding.llAddressConfirmed.visibility = View.VISIBLE
            }
        }


        // Address Belong Confirmed
        rcuVerificationViewModel.isAddressBelong.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.inpRemark.visibility = View.GONE
            }
            else{
                binding.inpRemark.visibility = View.VISIBLE
            }
        }


        // NameBoard Confirmed
        rcuVerificationViewModel.isNameboardseenattheHouse.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.llNameboardMismatched.visibility = View.VISIBLE
            }
            else{
                binding.llNameboardMismatched.visibility = View.GONE
            }
        }

        // NameBoard Confirmed
        rcuVerificationViewModel.isNameboardmismatched.observeForever {
            Log.e("Confirmed",it.toString())
            if (it == true){
                binding.inpApplicantReasonLabel.visibility = View.VISIBLE
            }
            else{
                binding.inpApplicantReasonLabel.visibility = View.GONE
            }
        }

    }

}