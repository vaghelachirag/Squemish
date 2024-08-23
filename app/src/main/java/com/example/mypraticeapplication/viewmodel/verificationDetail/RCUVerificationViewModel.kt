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
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.getSaveResidenceVerificationResponse.GetSaveResidenceVerificationResponse
import com.example.mypraticeapplication.model.getmasterData.GetMasterApiResponse
import com.example.mypraticeapplication.model.saveresidenceverification.SaveFirequestResidenceVerification
import com.example.mypraticeapplication.model.saveresidenceverification.SaveResidanceApplicantFamilyDetail
import com.example.mypraticeapplication.model.saveresidenceverification.SaveVerificationDataDetail
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.room.dao.MasterDataDao
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.adapter.AddFamilyMemberAdapter
import com.example.mypraticeapplication.view.detail.ActivityDetail
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RCUVerificationViewModel(private val context: Context, private  val binding: FragmentRcuVerificationBinding) : BaseViewModel(){


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

  /*  Rent Variable*/
    var edtPermanentAddress: ObservableField<String> = ObservableField()
    var edtMonthlyRentAmount: ObservableField<String> = ObservableField()
    var edtLandlordName: ObservableField<String> = ObservableField()
    var edtLandlordMobileNo: ObservableField<String> = ObservableField()


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
    var isHouseRented = MutableLiveData<Boolean>()


    private var houseLocalityList: List<String>? = null
    private var accommodationList: List<String>? = null
    private var negativeProfileList: List<String>? = null
    private var relationWithApplicantList: List<String>? = null
    private var materialStatusApplicantList: List<String>? = null
    private var houseSizeUnitList: List<String>? = null
    private var stayingAddressUnitList: List<String>? = null
    private var houseOwnershipList: List<String>? = null

    private var houseLocalitySpinnerAdapter: ArrayAdapter<String?>? = null
    private var accommodationTypeSpinnerAdapter: ArrayAdapter<String?>? = null
    private var negativeProfileSpinnerAdapter: ArrayAdapter<String?>? = null
    private var relationWithApplicantSpinnerAdapter: ArrayAdapter<String?>? = null
    private var materialStatusApplicantSpinnerAdapter: ArrayAdapter<String?>? = null
    private var houseOwnershipApplicantSpinnerAdapter: ArrayAdapter<String?>? = null


    // Room Database
    private var masterDataDao: MasterDataDao? = null


    var addFamilyMemberList: ArrayList<SaveResidanceApplicantFamilyDetail> = ArrayList()
    private var addFamilyMemberAdapter: AddFamilyMemberAdapter? = null


    var relationWithApplicant = MutableLiveData<String>()
     var accommodationApplicant = MutableLiveData<String>()
     var negativeProfileApplicant = MutableLiveData<String>()
     var houseLocalityApplicant = MutableLiveData<String>()
     var materialStatusApplicant = MutableLiveData<String>()
     var houseSizeUnitApplicant = MutableLiveData<String>()
     var stayingAddressApplicant = MutableLiveData<String>()
     var houseOwnershipApplicant = MutableLiveData<String>()


    fun init(context: Context?) {
        relationWithApplicant.value = ""
        accommodationApplicant.value = ""
        negativeProfileApplicant.value = ""
        houseLocalityApplicant.value = ""
        materialStatusApplicant.value = ""
        houseSizeUnitApplicant.value = ""
        stayingAddressApplicant.value = ""
        houseOwnershipApplicant.value = ""

        masterDataDao = InitDb.appDatabase.getMasterData()
        getDataFromMasterData()
        if (ActivityDetail.selectedData !=null && ActivityDetail.selectedData!!.getFiRequestResidenceVerification() !=null){
           setSelectedData()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setSelectedData() {

        isAddressConfirmed.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getAddressConfirmed()
        isAddressBelong.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsAddressBelongsApplicant()
        isHouseOpen.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsHouseOpen()
        isNameboardseenattheHouse.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsNameboardSeen()
        isNameboardmismatched.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsNameboardMismatch()
        isMajorMedicalHistory.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsMedicalHistory()
        isAnyPoliticalIssue.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsPoliticalConnection()
        isAnyLoanRunning.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsAnyOtherLoan()
        isAreaNegative.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsAreaNegative()
        isCastCommunityDominatedArea.value =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsCastCommunity()


        edtLatitude.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getLatitude().toString()))
        edtLongitude.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getLongitude().toString()))
        edtOtherObservations.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getOtherObservations().toString()))
        edtAddressBelongRemark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getAddressBelongsApplicantRemark().toString()))
        edPersonMet.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getPersonMet().toString()))
        edPersonMobileNumber.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getPersonMobileNo().toString()))
        edtMedicalHistoryRemark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getMedicalHistoryRemarks().toString()))
        edtPoliticalConnectionRemark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getPoliticalRemarks().toString()))
        edtBankName.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getBankName().toString()))
        edtLoanAmount.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getLoanAmount().toString()))
        edtRunningSince.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getRunningSince().toString()))
        edtIsAreaNegativeRemark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getNegativeProfileRemark().toString()))
        edtIsCastCommunityDominatedArea.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsCastCommunityRemark().toString()))
        edtOtherObservationsRemark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getOtherObservations().toString()))
        edAge.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getPersonMetAge().toString()))
        edtTotalEarningMember.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getTotalEarningMembers().toString()))
        edtTotalFamilyMembers.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getTotalFamilymembers().toString()))
        edtStayingAddress.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getStayingTime().toString()))
        edtElectricityBillName.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getElectricityBillOwnerName().toString()))
        edtKNo.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getKno().toString()))
        edtUnitConsumedLastMonth.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getLastMonthUnits().toString()))
        edtHouseSize.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getHouseSize().toString()))
        edtMedicalHistoryRemark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getMedicalHistoryRemarks().toString()))
        edtPoliticalConnectionRemark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getPoliticalRemarks().toString()))
        edtBankName.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getBankName().toString()))


        relationWithApplicant.value = Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getPersonMetRelation()!!.toString())
        accommodationApplicant.value = Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getAccommodationType()!!.toString())
        negativeProfileApplicant.value =  Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getIsNegativeProfile().toString())
        houseLocalityApplicant.value = Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getHouseOwnerShip().toString())
        materialStatusApplicant.value = Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getPersonMetMeritalStatus().toString())
        houseSizeUnitApplicant.value = Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getHouseSizeUnit().toString())
        stayingAddressApplicant.value = Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getStayingTimeUnit().toString())
        houseOwnershipApplicant.value =Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getHouseOwnerShip().toString())

       // Log.e("Selected", ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getPersonMet().toString())
    }


    fun onSaveClicked(){

        if (isAddressConfirmed.value == null){
            Utils().showSnackBar(context,"Please Select Address Confirmed",binding.constraintLayout)
        }else if (isAddressBelong.value == null){
            Utils().showSnackBar(context,"Please Select Address Belong",binding.constraintLayout)
        }
        else if (isHouseOpen.value == null){
            Utils().showSnackBar(context,"Please Select House is Open",binding.constraintLayout)
        }
        else {

            val saveVerificationDataDetail: SaveVerificationDataDetail =
                SaveVerificationDataDetail()
            saveVerificationDataDetail.setFirequestId(AppConstants.verificationId)
            saveVerificationDataDetail.setVerificationType("RV")
            val saveFiRequestResidenceVerification: SaveFirequestResidenceVerification =
                SaveFirequestResidenceVerification()
            saveFiRequestResidenceVerification.setFirequestId(AppConstants.verificationId)
            saveVerificationDataDetail.setFirequestResidenceVerification(
                saveFiRequestResidenceVerification
            )
            //  saveFiRequestResidenceVerification.setVisitDate("2024-08-14T22:32:20.503")
            saveFiRequestResidenceVerification.setAddressConfirmed(isAddressConfirmed.value)
            saveFiRequestResidenceVerification.setIsAddressBelongsApplicant(isAddressBelong.value)
            saveFiRequestResidenceVerification.setIsHouseOpen(isHouseOpen.value)
            saveFiRequestResidenceVerification.setPersonMet(edPersonMet.get())
            saveFiRequestResidenceVerification.setPersonMetRelation(relationWithApplicant.value)
            saveFiRequestResidenceVerification.setPersonMobileNo(edPersonMobileNumber.get())
            saveFiRequestResidenceVerification.setStayingTime(
                Utility.getParseInteger(
                    edtStayingAddress.get().toString()
                )
            )
            saveFiRequestResidenceVerification.setElectricityBillOwnerName(edtElectricityBillName.get())
            saveFiRequestResidenceVerification.setHouseOwnerShip(binding.llPersonalInformation.llPersonalInformationOne.spnapplicantHouseOwnershipLabel.text.toString())
            saveFiRequestResidenceVerification.setHouseLocality(binding.llPersonalInformation.spnHouseLocality.text.toString())
            saveFiRequestResidenceVerification.setIsMedicalHistory(isMajorMedicalHistory.value)
            saveFiRequestResidenceVerification.setMedicalHistoryRemarks(edtMedicalHistoryRemark.get())
            saveFiRequestResidenceVerification.setIsPoliticalConnection(isAnyPoliticalIssue.value)
            saveFiRequestResidenceVerification.setPoliticalRemarks(edtPoliticalConnectionRemark.get())
            saveFiRequestResidenceVerification.setIsAddressBelongsApplicant(isAddressBelong.value)
            saveFiRequestResidenceVerification.setAddressBelongsApplicantRemark(
                edtAddressBelongRemark.get()
            )
            saveFiRequestResidenceVerification.setPersonMetAge(Utility.getParseInteger(edAge.get()))
            saveFiRequestResidenceVerification.setPersonMetMeritalStatus(binding.llPersonalInformation.llPersonalInformationOne.spnapplicantMaterialStatus.text.toString())
            saveFiRequestResidenceVerification.setTotalFamilymembers(
                Utility.getParseInteger(
                    edtTotalEarningMember.get()
                )
            )
            saveFiRequestResidenceVerification.setTotalEarningMembers(
                Utility.getParseInteger(
                    edtTotalEarningMember.get()
                )
            )
            saveFiRequestResidenceVerification.setKno(edtKNo.get())
            saveFiRequestResidenceVerification.setLastMonthUnits(
                Utility.getParseInteger(
                    edtUnitConsumedLastMonth.get()
                )
            )
            saveFiRequestResidenceVerification.setAccommodationType(binding.llPersonalInformation.spnAccommodationType.text.toString())
            saveFiRequestResidenceVerification.setHouseSize(Utility.getParseInteger(edtHouseSize.get()))
            saveFiRequestResidenceVerification.setHouseSizeUnit(binding.llPersonalInformation.spnapplicantHouseSizeLabel.text.toString())
            saveFiRequestResidenceVerification.setIsAnyOtherLoan(isAnyLoanRunning.value)
            saveFiRequestResidenceVerification.setBankName(edtBankName.get())
            saveFiRequestResidenceVerification.setLoanAmount(Utility.getParseInteger(edtLoanAmount.get()))
            saveFiRequestResidenceVerification.setRunningSince(
                Utility.getParseInteger(edtRunningSince.get())
            )
            saveFiRequestResidenceVerification.setIsAreaNegative(isAreaNegative.value)
            saveFiRequestResidenceVerification.setIsNegativeProfile(binding.llApplicationBackground.spnapplicantIsInvolvedinNegativeProfileLabel.text.toString())
            saveFiRequestResidenceVerification.setOtherObservations(edtOtherObservationsRemark.get())
            saveFiRequestResidenceVerification.setIsCastCommunity(isCastCommunityDominatedArea.value)
            saveFiRequestResidenceVerification.setIsCastCommunityRemark(edtIsCastCommunityDominatedArea.get())
            saveFiRequestResidenceVerification.setLatitude(edtLatitude.get())
            saveFiRequestResidenceVerification.setLongitude(edtLongitude.get())
            saveFiRequestResidenceVerification.setIsNameboardSeen(isAddressConfirmed.value)
            saveFiRequestResidenceVerification.setIsNameboardMismatch(isNameboardmismatched.value)
            saveFiRequestResidenceVerification.setNameboardMismatchReason(edt_Reason.get())
            saveFiRequestResidenceVerification.setStayingTimeUnit(binding.llPersonalInformation.llPersonalInformationOne.spncurrentaddress.text.toString())
            saveFiRequestResidenceVerification.setIsAreaNegativeRemark(edtIsAreaNegativeRemark.get())

            saveFiRequestResidenceVerification.setPermanentAddress(edtPermanentAddress.get())
            saveFiRequestResidenceVerification.setRent(Utility.getParseInteger(edtMonthlyRentAmount.get()))
            saveFiRequestResidenceVerification.setHouseOwnerName(edtLandlordName.get())
            saveFiRequestResidenceVerification.setHouseOwnerMobileNo(edtLandlordMobileNo.get())

            saveFiRequestResidenceVerification.setTotalFamilymembers(
                Utility.getParseInteger(
                    edtTotalFamilyMembers.get()
                )
            )
            saveFiRequestResidenceVerification.setTotalEarningMembers(
                Utility.getParseInteger(
                    edtTotalEarningMember.get()
                )
            )

            saveFiRequestResidenceVerification.setApplicantFamilyDetails(addFamilyMemberList)

            val gson = Gson()
            val json = gson.toJson(saveVerificationDataDetail)
            Log.e("Json", json)

            if (Utility.isNetworkConnected(context)) {
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
                            Log.e("Status", t.getStatusCode().toString())
                            isLoading.postValue(false)
                            if (t.getStatusCode() == 200) {
                                //   Utils().showToast(context,t.getMessage().toString())
                                Utils().showSnackBar(
                                    context,
                                    t.getMessage().toString(),
                                    binding.constraintLayout
                                )
                            } else {
                                Utils().showSnackBar(
                                    context,
                                    t.getMessage().toString(),
                                    binding.constraintLayout
                                )
                                // Utils().showToast(context,t.getMessage().toString())
                            }
                            Log.e("StatusCode", t.getStatus().toString())
                        }
                    })
            } else {
                // Utils().showToast(context,context.getString(R.string.nointernetconnection).toString())
                Utils().showSnackBar(
                    context,
                    context.getString(R.string.nointernetconnection).toString(),
                    binding.constraintLayout
                )
            }
        }
    }
    private fun addFamilyMemberData() {
        addFamilyMemberList  = ArrayList()
        val saveResidenceApplicantFamilyDetail  =  SaveResidanceApplicantFamilyDetail()
        saveResidenceApplicantFamilyDetail.setRecordId(0)
        saveResidenceApplicantFamilyDetail.setFirequestId(AppConstants.verificationId)
        saveResidenceApplicantFamilyDetail.setMemberCount(1)
        saveResidenceApplicantFamilyDetail.setEarningMemberCount(1)
        saveResidenceApplicantFamilyDetail.setRelation("Select")

        addFamilyMemberList.add(saveResidenceApplicantFamilyDetail)
        setCustomLayoutAddAdapter()
    }

    private fun getDataFromMasterData() {
        CoroutineScope(Dispatchers.IO).launch {


            houseLocalityList = masterDataDao!!.getDataByKeyName(AppConstants.houseOrPremiseLocalityType)
            accommodationList = masterDataDao!!.getDataByKeyName(AppConstants.accommodationType)
            negativeProfileList = masterDataDao!!.getDataByKeyName(AppConstants.profileType)
            relationWithApplicantList = masterDataDao!!.getDataByKeyName(AppConstants.relationType)
            houseOwnershipList = masterDataDao!!.getDataByKeyName(AppConstants.houseOwnershipType)



             val materialStatusList = context.resources.getStringArray(R.array.material_status)
             materialStatusApplicantList = materialStatusList.asList()

            val houseSizeList = context.resources.getStringArray(R.array.house_size)
            houseSizeUnitList = houseSizeList.asList()


            val stayingUnitList = context.resources.getStringArray(R.array.house_locality_array)
            stayingAddressUnitList = stayingUnitList.asList()


            binding.llPersonalInformation.spnapplicantHouseSizeLabel.setListAdapter(houseSizeUnitList!!)
            binding.llPersonalInformation.llPersonalInformationOne.spnapplicantMaterialStatus.setListAdapter(materialStatusApplicantList!!)
            binding.llPersonalInformation.llPersonalInformationOne.spncurrentaddress.setListAdapter(materialStatusApplicantList!!)

            houseLocalitySpinnerAdapter =
                ArrayAdapter<String?>(context, android.R.layout.simple_spinner_item, houseLocalityList!!)
            houseLocalitySpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.llPersonalInformation.spnHouseLocality.setListAdapter(houseLocalityList!!)


            accommodationTypeSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    accommodationList!!
                )
            accommodationTypeSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.llPersonalInformation.spnAccommodationType.setListAdapter(accommodationList!!)

            negativeProfileSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    negativeProfileList!!
                )
            negativeProfileSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.llApplicationBackground.spnapplicantIsInvolvedinNegativeProfileLabel.setListAdapter(negativeProfileList!!)


            relationWithApplicantSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    relationWithApplicantList!!
                )
            relationWithApplicantSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.llPersonalInformation.llPersonalInformationOne.spnapplicantRelationApplicant.setListAdapter(relationWithApplicantList)

            houseOwnershipApplicantSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    houseOwnershipList!!
                )
            houseOwnershipApplicantSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)
            binding.llPersonalInformation.llPersonalInformationOne.spnapplicantHouseOwnershipLabel.setListAdapter(houseOwnershipList!!)

            if(ActivityDetail.selectedData!!.getFiRequestResidenceVerification() != null){
                 if (ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getApplicantFamilyDetails() != null){
                    addFamilyMemberList =  ActivityDetail.selectedData!!.getFiRequestResidenceVerification()!!.getApplicantFamilyDetails()!!
                    setCustomLayoutAddAdapter()
                }else{
                    addFamilyMemberData()
                }
            }else{
                addFamilyMemberData()
            }
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


    public fun setTotalMemberMember(){
        var totalMember : Int = 0
        var totalEarningMember : Int = 0
        addFamilyMemberList.forEach {
            totalMember += it.getMemberCount()!!
            totalEarningMember += it.getEarningMemberCount()!!
            Log.e("TotalMember",it.getMemberCount().toString())
        }
        edtTotalFamilyMembers.set(totalMember.toString())
        edtTotalEarningMember.set(totalEarningMember.toString())
    }

    private fun setCustomLayoutAddAdapter() {
        addFamilyMemberAdapter =  AddFamilyMemberAdapter(context,addFamilyMemberList,relationWithApplicantList,this,object : AddFamilyMemberAdapter.OnItemClickListener{

            @SuppressLint("NotifyDataSetChanged")
            override fun onItemClick(position: Int) {
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

        binding.llPersonalInformation.llPersonalInformationOne.addFamilyMemberRecyclerView.setLayoutManager(LinearLayoutManager(context))
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
                            //Utils().showToast(context,t.getMessage().toString())
                            Utils().showSnackBar(context,t.getMessage().toString(),binding.constraintLayout)
                        }
                        Log.e("StatusCode",t.getStatus().toString())
                    }

                })
        }else{
            Utils().showSnackBar(context,context.getString(R.string.nointernetconnection).toString(),binding.constraintLayout)
         //   Utils().showToast(context,context.getString(R.string.nointernetconnection).toString())
        }

    }
}