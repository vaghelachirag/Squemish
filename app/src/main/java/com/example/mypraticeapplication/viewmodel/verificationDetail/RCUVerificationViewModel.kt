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
import com.example.mypraticeapplication.model.getAcceptRejectResponse.GetAcceptRejectResponse
import com.example.mypraticeapplication.model.getSaveResidenceVerificationResponse.GetSaveResidenceVerificationResponse
import com.example.mypraticeapplication.model.getmasterData.GetMasterApiResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.AddFamilyMemberModel
import com.example.mypraticeapplication.model.saveresidenceverification.SaveFirequestResidenceVerification
import com.example.mypraticeapplication.model.saveresidenceverification.SaveVerificationDataDetail
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.room.dao.MasterDataDao
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.adapter.AddFamilyMemberAdapter
import com.example.mypraticeapplication.view.detail.FragmentBasicInformation
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RCUVerificationViewModel(private val context: Context, private  val binding: com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding) : BaseViewModel() {


    // Address Detail Params
    var edtLatitude: ObservableField<String> = ObservableField()
    var edtLongitude: ObservableField<String> = ObservableField()
    var edtOtherObservations: ObservableField<String> = ObservableField()
    var edtAddressBelongRemark: ObservableField<String> = ObservableField()


    var edt_Reason: ObservableField<String> = ObservableField()

    // Personal Information One
    var edPersonMet: ObservableField<String> = ObservableField()
    var edPersonMobileNumber: ObservableField<String> = ObservableField()
    var edAge: ObservableField<String> = ObservableField()
    var edtTotalFamilyMembers: ObservableField<String> = ObservableField()
    var edtTotalEarningMember: ObservableField<String> = ObservableField()
    var edtStayingAddress: ObservableField<String> = ObservableField()
    var edtKNo: ObservableField<String> = ObservableField()
    var edtElectricityBillName: ObservableField<String> = ObservableField()
    var edtUnitConsumedLastMonth: ObservableField<String> = ObservableField()
    var edtHouseSize: ObservableField<String> = ObservableField()


    // Application Background
    var edtMedicalHistoryRemark: ObservableField<String> = ObservableField()
    var edtPoliticalConnectionRemark: ObservableField<String> = ObservableField()
    var edtBankName: ObservableField<String> = ObservableField()
    var edtLoanAmount: ObservableField<String> = ObservableField()
    var edtRunningSince: ObservableField<String> = ObservableField()
    var edtIsAreaNegativeRemark : ObservableField<String> = ObservableField()
    var edtIsCastCommunityDominatedArea: ObservableField<String> = ObservableField()
    var edtOtherObservationsRemark: ObservableField<String> = ObservableField()

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

    // All Spinner Position
    var selectedHouseLocalityPosition = MutableLiveData<Int>()
    var selectedHouseLocalityItemPosition: Int = 0

    var selectedAccommodationTypePosition = MutableLiveData<Int>()
    var selectedAccommodationTypeItemPosition: Int = 0

    var selectedRelationWithApplicantPosition = MutableLiveData<Int>()
    var selectedRelationWithApplicantItemPosition: Int = 0

    var selectedMaritalStatusPosition = MutableLiveData<Int>()
    var selectedMaritalStatusItemPosition: Int = 0

    var selectedHouseOwnershipPosition = MutableLiveData<Int>()
    var selectedHouseOwnershipItemPosition: Int = 0

    var selectedYearsPosition = MutableLiveData<Int>()
    var selectedYearsItemPosition: Int = 0


    var selectedHouseSizePosition = MutableLiveData<Int>()
    var selectedHouseSizeItemPosition: Int = 0

    var selectedInvolvedNegativeProfilePosition = MutableLiveData<Int>()
    var selectedInvolvedNegativeProfileItemPosition: Int = 0



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
     Log.e("OnSave","OnSave")
        val saveVerificationDataDetail: SaveVerificationDataDetail = SaveVerificationDataDetail()
        saveVerificationDataDetail.setFirequestId(18)
        saveVerificationDataDetail.setVerificationType("RV")
        val saveFiRequestResidenceVerification: SaveFirequestResidenceVerification = SaveFirequestResidenceVerification()
        saveFiRequestResidenceVerification.setFirequestId(18)
        saveVerificationDataDetail.setFirequestResidenceVerification(saveFiRequestResidenceVerification)
        saveFiRequestResidenceVerification.setVisitDate("2024-08-14T22:32:20.503")
        saveFiRequestResidenceVerification.setAddressConfirmed(isAddressConfirmed.value)
        saveFiRequestResidenceVerification.setIsAddressBelongsApplicant(isAddressBelong.value)
        saveFiRequestResidenceVerification.setIsHouseOpen(isHouseOpen.value)
        saveFiRequestResidenceVerification.setPersonMet(edPersonMet.get().toString())
        saveFiRequestResidenceVerification.setPersonMetRelation(binding.llPersonalInformation.llPersonalInformationOne.spnapplicantRelationApplicant.selectedItem.toString())
        saveFiRequestResidenceVerification.setPersonMobileNo(edPersonMobileNumber.get().toString())
      //  saveFiRequestResidenceVerification.setStayingTime(edtStayingAddress.get().toString())
        saveFiRequestResidenceVerification.setElectricityBillOwnerName(edtElectricityBillName.get().toString())
        saveFiRequestResidenceVerification.setHouseOwnerShip(binding.llPersonalInformation.llPersonalInformationOne.spnapplicantHouseOwnershipLabel.selectedItem.toString())
        saveFiRequestResidenceVerification.setHouseLocality(binding.llPersonalInformation.spnHouseLocality.selectedItem.toString())
        saveFiRequestResidenceVerification.setIsMedicalHistory(isMajorMedicalHistory.value)
        saveFiRequestResidenceVerification.setMedicalHistoryRemarks(edtMedicalHistoryRemark.get().toString())
        saveFiRequestResidenceVerification.setIsPoliticalConnection(isAnyPoliticalIssue.value)
        saveFiRequestResidenceVerification.setPoliticalRemarks(edtPoliticalConnectionRemark.get().toString())
        saveFiRequestResidenceVerification.setIsAddressBelongsApplicant(isAddressBelong.value)
        saveFiRequestResidenceVerification.setAddressBelongsApplicantRemark(edtAddressBelongRemark.get().toString())
        saveFiRequestResidenceVerification.setPersonMetAge(Utility.getParseInteger(edAge.get().toString()))
        saveFiRequestResidenceVerification.setPersonMetMeritalStatus(binding.llPersonalInformation.llPersonalInformationOne.spnapplicantMaterialStatus.selectedItem.toString())
        saveFiRequestResidenceVerification.setTotalFamilymembers(Utility.getParseInteger(edtTotalEarningMember.get().toString()))
        saveFiRequestResidenceVerification.setTotalEarningMembers(Utility.getParseInteger(edtTotalEarningMember.get().toString()))
        saveFiRequestResidenceVerification.setKno(edtKNo.get().toString())
        saveFiRequestResidenceVerification.setLastMonthUnits(Utility.getParseInteger(edtUnitConsumedLastMonth.get().toString()))
        saveFiRequestResidenceVerification.setAccommodationType(binding.llPersonalInformation.spnAccommodationType.selectedItem.toString())
        saveFiRequestResidenceVerification.setHouseSize(Utility.getParseInteger(edtHouseSize.get().toString()))
        saveFiRequestResidenceVerification.setHouseSizeUnit(binding.llPersonalInformation.spnapplicantHouseSizeLabel.selectedItem.toString())
        saveFiRequestResidenceVerification.setIsAnyOtherLoan(isAnyLoanRunning.value)
        saveFiRequestResidenceVerification.setBankName(edtBankName.get().toString())
        saveFiRequestResidenceVerification.setLoanAmount(Utility.getParseInteger(edtLoanAmount.get().toString()))
        saveFiRequestResidenceVerification.setRunningSince(Utility.getParseInteger(edtRunningSince.get().toString()))
        saveFiRequestResidenceVerification.setIsAreaNegative(isAreaNegative.value)
        saveFiRequestResidenceVerification.setOtherObservations(edtPoliticalConnectionRemark.get().toString())
        saveFiRequestResidenceVerification.setIsCastCommunity(isCastCommunityDominatedArea.value)
        saveFiRequestResidenceVerification.setIsCastCommunityRemark(edtIsCastCommunityDominatedArea.get().toString())
        saveFiRequestResidenceVerification.setLatitude(edtLatitude.get().toString())
        saveFiRequestResidenceVerification.setLongitude(edtLongitude.get().toString())
        saveFiRequestResidenceVerification.setIsNameboardSeen(isAddressConfirmed.value)
        saveFiRequestResidenceVerification.setIsNameboardMismatch(isNameboardmismatched.value)
        saveFiRequestResidenceVerification.setNameboardMismatchReason(edt_Reason.get().toString())
        saveFiRequestResidenceVerification.setStayingTimeUnit(binding.llPersonalInformation.llPersonalInformationOne.spncurrentaddress.selectedItem.toString())


        Log.e("PersonAge",edAge.get().toString() + " "+Utility.getParseInteger(edAge.get().toString() ))
        val gson = Gson()
        val json = gson.toJson(saveVerificationDataDetail)
        Log.e("Json",json)

        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getSaveFiResidenceResponse(saveVerificationDataDetail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetSaveResidenceVerificationResponse>() {
                    override fun onSuccess(response: GetSaveResidenceVerificationResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetSaveResidenceVerificationResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            Utils().showToast(context,t.getMessage().toString())
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

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedHouseLocalityPosition.value = position
        }
    }

    //  For Click Listener Sequence
    val clicksAccommodationTypeListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedAccommodationTypePosition.value = position
        }
    }


    //  For Click Listener Relation With Applicant
    val clicksRelationWithApplicantListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedRelationWithApplicantPosition.value = position

        }
    }

    //  For Click Listener Sequence
    val clicksMaterialStatusTypeListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedMaritalStatusPosition.value = position
        }
    }


    //  For Click Listener House Ownership Type
    val clicksHouseOwnerShipTypeListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedHouseOwnershipPosition.value = position
        }
    }

    //  For Click Listener Sequence
    val clicksYearsListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedYearsPosition.value = position
        }
    }


    //  For Click Listener Sequence
    val clicksHouseSizeListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedHouseSizePosition.value = position
        }
    }

    //  For Click Listener Sequence
    val clicksInvolvedNegativeProfileListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedInvolvedNegativeProfilePosition.value = position
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