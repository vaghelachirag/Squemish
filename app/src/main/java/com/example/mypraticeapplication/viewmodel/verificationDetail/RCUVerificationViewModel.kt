package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.getmasterData.GetMasterApiResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.AddFamilyMemberModel
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.room.dao.MasterDataDao
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.adapter.AddFamilyMemberAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RCUVerificationViewModel(private val context: Context, private  val binding: com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding) : BaseViewModel() {


    // Login Params
    var edt_Applicant_Latitude_label: ObservableField<String> = ObservableField()
    var edt_Applicant_Longitude_label: ObservableField<String> = ObservableField()
    var edt_applicant_OtherObservations_label: ObservableField<String> = ObservableField()
    var edt_Remark: ObservableField<String> = ObservableField()
    var edt_Reason: ObservableField<String> = ObservableField()
    var edt_PersonMet: ObservableField<String> = ObservableField()
    var edt_PersonMetMobileNumber: ObservableField<String> = ObservableField()

    // All Variable
    var isAddressConfirmed = MutableLiveData<Boolean>()
    var isAddressBelong = MutableLiveData<Boolean>()
    var isHouseOpen = MutableLiveData<Boolean>()
    var isNameboardseenattheHouse = MutableLiveData<Boolean>()
    var isNameboardmismatched = MutableLiveData<Boolean>()
    var isMajorMedicalHistory = MutableLiveData<Boolean>()
    var isAnyPoliticalIssue = MutableLiveData<Boolean>()
    var isAnyLoanRunning = MutableLiveData<Boolean>()
    var isAreaNegative = MutableLiveData<Boolean>()
    var isCastCommunityDominatedArea = MutableLiveData<Boolean>()

    var selectedHouseLocalityPosition = MutableLiveData<Int>()
    var selectedHouseLocalityItemPosition: Int = 0

    var selectedAccommodationTypePosition = MutableLiveData<Int>()
    var selectedAccommodationTypeItemPosition: Int = 0


    private var houseLocalityList: List<String>? = null
    private var accommodationList: List<String>? = null
    private var negativeProfileList: List<String>? = null
    private var relationWithApplicantList: List<String>? = null
    private var materialStatusApplicantList: List<String>? = null
    private var houseOwnershipList: List<String>? = null

    private var houseLocalitySpinnerAdapter: ArrayAdapter<String?>? = null
    private var accommodationTypeSpinnerAdapter: ArrayAdapter<String?>? = null
    private var negativeProfileSpinnerAdapter: ArrayAdapter<String?>? = null
    private var relationWithApplicantSpinnerAdapter: ArrayAdapter<String?>? = null
    private var materialStatusApplicantSpinnerAdapter: ArrayAdapter<String?>? = null
    private var houseOwnershipApplicantSpinnerAdapter: ArrayAdapter<String?>? = null

    // Room Database
    private var masterDataDao: MasterDataDao? = null


    var addFamilyMemberList: ArrayList<AddFamilyMemberModel> = ArrayList()
    private var addFamilyMemberAdapter: AddFamilyMemberAdapter? = null

    fun init(context: Context?) {
        isAddressConfirmed.value = true
        // Room Database
        getMasterDataApi()
        masterDataDao = InitDb.appDatabase.getMasterData()
        getDataFromMasterData()
    }

    fun onSaveClicked(){

    }
    private fun addFamilyMemberData() {
        addFamilyMemberList  = ArrayList()
        addFamilyMemberList.add(AddFamilyMemberModel("10","1"))
        setCustomLayoutAddAdapter()
    }

    private fun getDataFromMasterData() {
        CoroutineScope(Dispatchers.IO).launch {
            houseLocalityList =
                masterDataDao!!.getDataByKeyName(AppConstants.houseOrPremiseLocalityType)
            accommodationList = masterDataDao!!.getDataByKeyName(AppConstants.accommodationType)
            negativeProfileList = masterDataDao!!.getDataByKeyName(AppConstants.profileType)
            relationWithApplicantList = masterDataDao!!.getDataByKeyName(AppConstants.relationType)
            materialStatusApplicantList = masterDataDao!!.getDataByKeyName(AppConstants.relationType)
            houseOwnershipList = masterDataDao!!.getDataByKeyName(AppConstants.houseOwnershipType)


            houseLocalitySpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    houseLocalityList!!
                )
            houseLocalitySpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.llPersonalInformation.spnHouseLocality.adapter = houseLocalitySpinnerAdapter


            accommodationTypeSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    accommodationList!!
                )
            accommodationTypeSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.llPersonalInformation.spnAccommodationType.adapter = accommodationTypeSpinnerAdapter

            negativeProfileSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    negativeProfileList!!
                )
            negativeProfileSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.llApplicationBackground.spnapplicantIsInvolvedinNegativeProfileLabel.adapter = negativeProfileSpinnerAdapter


            relationWithApplicantSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    relationWithApplicantList!!
                )
            relationWithApplicantSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.llPersonalInformation.llPersonalInformationOne.spnapplicantRelationApplicant.adapter = relationWithApplicantSpinnerAdapter

            houseOwnershipApplicantSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    houseOwnershipList!!
                )
            houseOwnershipApplicantSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.llPersonalInformation.llPersonalInformationOne.spnapplicantHouseOwnershipLabel.adapter = houseOwnershipApplicantSpinnerAdapter


            addFamilyMemberData()
        }
    }

    val onAddressConfirmed = RadioGroup.OnCheckedChangeListener { _, checkedId ->
        if (checkedId == R.id.radio_AddressConfirmedYes) {
            isAddressConfirmed.value = true
        }
        if (checkedId == R.id.radio_AddressConfirmedNo) {
            isAddressConfirmed.value = false
        }
        if (checkedId == R.id.rb_AddressBelongYes) {
            isAddressBelong.value = true
        }
        if (checkedId == R.id.rb_AddressBelongNo) {
            isAddressBelong.value = false
        }

        if (checkedId == R.id.rb_IsNameboardseenattheHouseYes) {
            isNameboardseenattheHouse.value = true
        }

        if (checkedId == R.id.rb_IsNameboardseenattheHouseNo) {
            isNameboardseenattheHouse.value = false
        }

        if (checkedId == R.id.rb_applicant_IsNameboardseenattheHouse_labelYes) {
            isNameboardmismatched.value = true
        }

        if (checkedId == R.id.rb_applicant_IsNameboardseenattheHouse_labeleNo) {
            isNameboardmismatched.value = false
        }
        if (checkedId == R.id.rb_IsapplicanthaveanymajormedicalhistoryYes) {
            isMajorMedicalHistory.value = true
        }

        if (checkedId == R.id.rb_IsapplicanthaveanymajormedicalhistoryNo) {
            isMajorMedicalHistory.value = false
        }

        if (checkedId == R.id.rb_IsapplicanthaveanypoliticalconnectionYes) {
            isAnyPoliticalIssue.value = true
        }

        if (checkedId == R.id.rb_IsapplicanthaveanypoliticalconnectionNo) {
            isAnyPoliticalIssue.value = false
        }

        if (checkedId == R.id.rb_applicant_Isanyotherloanrunning_label_Yes) {
            isAnyLoanRunning.value = true
        }

        if (checkedId == R.id.rb_rb_applicant_Isanyotherloanrunning_label_No) {
            isAnyLoanRunning.value = false
        }

        if (checkedId == R.id.rb_applicant_IsAreaNegative_label_Yes) {
            isAreaNegative.value = true
        }

        if (checkedId == R.id.rb_applicant_IsAreaNegative_label_No) {
            isAreaNegative.value = false
        }

        if (checkedId == R.id.rb_applicant_IsCastCommunityDominatedArea_Yes) {
            isCastCommunityDominatedArea.value = true
        }

        if (checkedId == R.id.rb_applicant_IsCastCommunityDominatedArea_No) {
            isCastCommunityDominatedArea.value = false
        }

        if (checkedId == R.id.rb_applicant_IsCastCommunityDominatedArea_Yes) {
            isCastCommunityDominatedArea.value = true
        }

        if (checkedId == R.id.rb_applicant_IsCastCommunityDominatedArea_No) {
            isCastCommunityDominatedArea.value = false
        }


        if (checkedId == R.id.radio_DurningVisitYes) {
            isHouseOpen.value = true
        }

        if (checkedId == R.id.radio_DurningVisitNo) {
            isHouseOpen.value = false
        }

    }

    //  For Click Listener Sequence
    val clicksHouseLocalityListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            selectedHouseLocalityPosition.value = position
            val neighourReconisedText =
                context.resources.getStringArray(R.array.neighbourrecognised_array)
        }
    }


    //  For Click Listener Sequence
    val clicksAccommodationTypeListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            selectedAccommodationTypePosition.value = position
            val neighourReconisedText =
                context.resources.getStringArray(R.array.neighbourrecognised_array)
        }
    }

    private fun setCustomLayoutAddAdapter() {
        addFamilyMemberAdapter =  AddFamilyMemberAdapter(context,addFamilyMemberList,relationWithApplicantList,object : AddFamilyMemberAdapter.OnItemClickListener{

            @SuppressLint("NotifyDataSetChanged")
            override fun onItemClick(position: Int) {
                Log.e("Position",position.toString())
                addFamilyMemberAdapter?.addDay()
                addFamilyMemberAdapter?.notifyDataSetChanged()
            }

            override fun onRemoveClick(position: Int) {
                if (addFamilyMemberList.size == 1) {
                    addFamilyMemberAdapter?.changeValue(true)
                } else {
                    addFamilyMemberAdapter?.changeValue(false)
                }
                addFamilyMemberAdapter?.removeDay(position)
            }

        })

        binding.llPersonalInformation.llPersonalInformationOne.addFamilyMemberRecyclerView.setLayoutManager(
            LinearLayoutManager(context)
        )
        binding.llPersonalInformation.llPersonalInformationOne.addFamilyMemberRecyclerView.setAdapter(addFamilyMemberAdapter)
    }

    // Get Master Data Api
    private fun getMasterDataApi() {
        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getMasterApiData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetMasterApiResponse>() {
                    override fun onSuccess(response: GetMasterApiResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetMasterApiResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            if(t.getData() != null){
                                CoroutineScope(Dispatchers.IO).launch {
                                    //getUserProfileData()
                                    masterDataDao!!.insertAll(t.getData())
                                }
                            }
                        }else{
                            Utils().showToast(context,t.getMessage().toString())
                        }
                        Log.e("StatusCode",t.getStatus().toString())
                    }

                })
        }else{
            Utils().showToast(context,context.getString(R.string.nointernetconnection).toString())
        }
    }
}