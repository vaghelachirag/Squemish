package com.example.mypraticeapplication.model.saveresidenceverification

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class SaveFirequestResidenceVerification {

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("visitDate")
    @Expose
    private var visitDate: String? = null

    @SerializedName("addressConfirmed")
    @Expose
    private var addressConfirmed: Boolean? = null

    @SerializedName("isHouseOpen")
    @Expose
    private var isHouseOpen: Boolean? = null

    @SerializedName("personMet")
    @Expose
    private var personMet: String? = null

    @SerializedName("personMobileNo")
    @Expose
    private var personMobileNo: String? = null

    @SerializedName("personMetRelation")
    @Expose
    private var personMetRelation: String? = null

    @SerializedName("stayingTime")
    @Expose
    private var stayingTime: Int? = null

    @SerializedName("electricityBillOwnerName")
    @Expose
    private var electricityBillOwnerName: String? = null

    @SerializedName("houseOwnerShip")
    @Expose
    private var houseOwnerShip: String? = null

    @SerializedName("rent")
    @Expose
    private var rent: Any? = null

    @SerializedName("houseOwnerName")
    @Expose
    private var houseOwnerName: Any? = null

    @SerializedName("houseOwnerMobileNo")
    @Expose
    private var houseOwnerMobileNo: Any? = null

    @SerializedName("houseLocality")
    @Expose
    private var houseLocality: String? = null

    @SerializedName("isMedicalHistory")
    @Expose
    private var isMedicalHistory: Boolean? = null

    @SerializedName("medicalHistoryRemarks")
    @Expose
    private var medicalHistoryRemarks: Any? = null

    @SerializedName("isPoliticalConnection")
    @Expose
    private var isPoliticalConnection: Boolean? = null

    @SerializedName("politicalRemarks")
    @Expose
    private var politicalRemarks: String? = null

    @SerializedName("isAddressBelongsApplicant")
    @Expose
    private var isAddressBelongsApplicant: Boolean? = null

    @SerializedName("addressBelongsApplicantRemark")
    @Expose
    private var addressBelongsApplicantRemark: Any? = null

    @SerializedName("personMetAge")
    @Expose
    private var personMetAge: Int? = null

    @SerializedName("personMetMeritalStatus")
    @Expose
    private var personMetMeritalStatus: String? = null

    @SerializedName("totalFamilymembers")
    @Expose
    private var totalFamilymembers: Int? = null

    @SerializedName("totalEarningMembers")
    @Expose
    private var totalEarningMembers: Int? = null

    @SerializedName("kno")
    @Expose
    private var kno: String? = null

    @SerializedName("lastMonthUnits")
    @Expose
    private var lastMonthUnits: Int? = null

    @SerializedName("accommodationType")
    @Expose
    private var accommodationType: String? = null

    @SerializedName("houseSize")
    @Expose
    private var houseSize: Int? = null

    @SerializedName("houseSizeUnit")
    @Expose
    private var houseSizeUnit: String? = null

    @SerializedName("isAnyOtherLoan")
    @Expose
    private var isAnyOtherLoan: Boolean? = null

    @SerializedName("bankName")
    @Expose
    private var bankName: String? = null

    @SerializedName("loanAmount")
    @Expose
    private var loanAmount: Int? = null

    @SerializedName("runningSince")
    @Expose
    private var runningSince: Int? = null

    @SerializedName("isNegativeProfile")
    @Expose
    private var isNegativeProfile: String? = null

    @SerializedName("otherObservations")
    @Expose
    private var otherObservations: String? = null

    @SerializedName("permanentAddress")
    @Expose
    private var permanentAddress: Any? = null

    @SerializedName("negativeProfileRemark")
    @Expose
    private var negativeProfileRemark: Any? = null

    @SerializedName("isAreaNegative")
    @Expose
    private var isAreaNegative: Boolean? = null

    @SerializedName("isAreaNegativeRemark")
    @Expose
    private var isAreaNegativeRemark: Any? = null

    @SerializedName("isCastCommunity")
    @Expose
    private var isCastCommunity: Boolean? = null

    @SerializedName("isCastCommunityRemark")
    @Expose
    private var isCastCommunityRemark: Any? = null

    @SerializedName("longitude")
    @Expose
    private var longitude: String? = null

    @SerializedName("latitude")
    @Expose
    private var latitude: String? = null

    @SerializedName("isNameboardSeen")
    @Expose
    private var isNameboardSeen: Boolean? = null

    @SerializedName("isNameboardMismatch")
    @Expose
    private var isNameboardMismatch: Boolean? = null

    @SerializedName("nameboardMismatchReason")
    @Expose
    private var nameboardMismatchReason: String? = null

    @SerializedName("stayingTimeUnit")
    @Expose
    private var stayingTimeUnit: String? = null

    @SerializedName("applicantFamilyDetails")
    @Expose
    private var applicantFamilyDetails: List<SaveResidanceApplicantFamilyDetail>? = null

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getVisitDate(): String? {
        return visitDate
    }

    fun setVisitDate(visitDate: String?) {
        this.visitDate = visitDate
    }

    fun getAddressConfirmed(): Boolean? {
        return addressConfirmed
    }

    fun setAddressConfirmed(addressConfirmed: Boolean?) {
        this.addressConfirmed = addressConfirmed
    }

    fun getIsHouseOpen(): Boolean? {
        return isHouseOpen
    }

    fun setIsHouseOpen(isHouseOpen: Boolean?) {
        this.isHouseOpen = isHouseOpen
    }

    fun getPersonMet(): String? {
        return personMet
    }

    fun setPersonMet(personMet: String?) {
        this.personMet = personMet
    }

    fun getPersonMobileNo(): String? {
        return personMobileNo
    }

    fun setPersonMobileNo(personMobileNo: String?) {
        this.personMobileNo = personMobileNo
    }

    fun getPersonMetRelation(): String? {
        return personMetRelation
    }

    fun setPersonMetRelation(personMetRelation: String?) {
        this.personMetRelation = personMetRelation
    }

    fun getStayingTime(): Int? {
        return stayingTime
    }

    fun setStayingTime(stayingTime: Int?) {
        this.stayingTime = stayingTime
    }

    fun getElectricityBillOwnerName(): String? {
        return electricityBillOwnerName
    }

    fun setElectricityBillOwnerName(electricityBillOwnerName: String?) {
        this.electricityBillOwnerName = electricityBillOwnerName
    }

    fun getHouseOwnerShip(): String? {
        return houseOwnerShip
    }

    fun setHouseOwnerShip(houseOwnerShip: String?) {
        this.houseOwnerShip = houseOwnerShip
    }

    fun getRent(): Any? {
        return rent
    }

    fun setRent(rent: Any?) {
        this.rent = rent
    }

    fun getHouseOwnerName(): Any? {
        return houseOwnerName
    }

    fun setHouseOwnerName(houseOwnerName: Any?) {
        this.houseOwnerName = houseOwnerName
    }

    fun getHouseOwnerMobileNo(): Any? {
        return houseOwnerMobileNo
    }

    fun setHouseOwnerMobileNo(houseOwnerMobileNo: Any?) {
        this.houseOwnerMobileNo = houseOwnerMobileNo
    }

    fun getHouseLocality(): String? {
        return houseLocality
    }

    fun setHouseLocality(houseLocality: String?) {
        this.houseLocality = houseLocality
    }

    fun getIsMedicalHistory(): Boolean? {
        return isMedicalHistory
    }

    fun setIsMedicalHistory(isMedicalHistory: Boolean?) {
        this.isMedicalHistory = isMedicalHistory
    }

    fun getMedicalHistoryRemarks(): Any? {
        return medicalHistoryRemarks
    }

    fun setMedicalHistoryRemarks(medicalHistoryRemarks: Any?) {
        this.medicalHistoryRemarks = medicalHistoryRemarks
    }

    fun getIsPoliticalConnection(): Boolean? {
        return isPoliticalConnection
    }

    fun setIsPoliticalConnection(isPoliticalConnection: Boolean?) {
        this.isPoliticalConnection = isPoliticalConnection
    }

    fun getPoliticalRemarks(): String? {
        return politicalRemarks
    }

    fun setPoliticalRemarks(politicalRemarks: String?) {
        this.politicalRemarks = politicalRemarks
    }

    fun getIsAddressBelongsApplicant(): Boolean? {
        return isAddressBelongsApplicant
    }

    fun setIsAddressBelongsApplicant(isAddressBelongsApplicant: Boolean?) {
        this.isAddressBelongsApplicant = isAddressBelongsApplicant
    }

    fun getAddressBelongsApplicantRemark(): Any? {
        return addressBelongsApplicantRemark
    }

    fun setAddressBelongsApplicantRemark(addressBelongsApplicantRemark: Any?) {
        this.addressBelongsApplicantRemark = addressBelongsApplicantRemark
    }

    fun getPersonMetAge(): Int? {
        return personMetAge
    }

    fun setPersonMetAge(personMetAge: Int?) {
        this.personMetAge = personMetAge
    }

    fun getPersonMetMeritalStatus(): String? {
        return personMetMeritalStatus
    }

    fun setPersonMetMeritalStatus(personMetMeritalStatus: String?) {
        this.personMetMeritalStatus = personMetMeritalStatus
    }

    fun getTotalFamilymembers(): Int? {
        return totalFamilymembers
    }

    fun setTotalFamilymembers(totalFamilymembers: Int?) {
        this.totalFamilymembers = totalFamilymembers
    }

    fun getTotalEarningMembers(): Int? {
        return totalEarningMembers
    }

    fun setTotalEarningMembers(totalEarningMembers: Int?) {
        this.totalEarningMembers = totalEarningMembers
    }

    fun getKno(): String? {
        return kno
    }

    fun setKno(kno: String?) {
        this.kno = kno
    }

    fun getLastMonthUnits(): Int? {
        return lastMonthUnits
    }

    fun setLastMonthUnits(lastMonthUnits: Int?) {
        this.lastMonthUnits = lastMonthUnits
    }

    fun getAccommodationType(): String? {
        return accommodationType
    }

    fun setAccommodationType(accommodationType: String?) {
        this.accommodationType = accommodationType
    }

    fun getHouseSize(): Int? {
        return houseSize
    }

    fun setHouseSize(houseSize: Int?) {
        this.houseSize = houseSize
    }

    fun getHouseSizeUnit(): String? {
        return houseSizeUnit
    }

    fun setHouseSizeUnit(houseSizeUnit: String?) {
        this.houseSizeUnit = houseSizeUnit
    }

    fun getIsAnyOtherLoan(): Boolean? {
        return isAnyOtherLoan
    }

    fun setIsAnyOtherLoan(isAnyOtherLoan: Boolean?) {
        this.isAnyOtherLoan = isAnyOtherLoan
    }

    fun getBankName(): String? {
        return bankName
    }

    fun setBankName(bankName: String?) {
        this.bankName = bankName
    }

    fun getLoanAmount(): Int? {
        return loanAmount
    }

    fun setLoanAmount(loanAmount: Int?) {
        this.loanAmount = loanAmount
    }

    fun getRunningSince(): Int? {
        return runningSince
    }

    fun setRunningSince(runningSince: Int?) {
        this.runningSince = runningSince
    }

    fun getIsNegativeProfile(): String? {
        return isNegativeProfile
    }

    fun setIsNegativeProfile(isNegativeProfile: String?) {
        this.isNegativeProfile = isNegativeProfile
    }

    fun getOtherObservations(): String? {
        return otherObservations
    }

    fun setOtherObservations(otherObservations: String?) {
        this.otherObservations = otherObservations
    }

    fun getPermanentAddress(): Any? {
        return permanentAddress
    }

    fun setPermanentAddress(permanentAddress: Any?) {
        this.permanentAddress = permanentAddress
    }

    fun getNegativeProfileRemark(): Any? {
        return negativeProfileRemark
    }

    fun setNegativeProfileRemark(negativeProfileRemark: Any?) {
        this.negativeProfileRemark = negativeProfileRemark
    }

    fun getIsAreaNegative(): Boolean? {
        return isAreaNegative
    }

    fun setIsAreaNegative(isAreaNegative: Boolean?) {
        this.isAreaNegative = isAreaNegative
    }

    fun getIsAreaNegativeRemark(): Any? {
        return isAreaNegativeRemark
    }

    fun setIsAreaNegativeRemark(isAreaNegativeRemark: Any?) {
        this.isAreaNegativeRemark = isAreaNegativeRemark
    }

    fun getIsCastCommunity(): Boolean? {
        return isCastCommunity
    }

    fun setIsCastCommunity(isCastCommunity: Boolean?) {
        this.isCastCommunity = isCastCommunity
    }

    fun getIsCastCommunityRemark(): Any? {
        return isCastCommunityRemark
    }

    fun setIsCastCommunityRemark(isCastCommunityRemark: Any?) {
        this.isCastCommunityRemark = isCastCommunityRemark
    }

    fun getLongitude(): String? {
        return longitude
    }

    fun setLongitude(longitude: String?) {
        this.longitude = longitude
    }

    fun getLatitude(): String? {
        return latitude
    }

    fun setLatitude(latitude: String?) {
        this.latitude = latitude
    }

    fun getIsNameboardSeen(): Boolean? {
        return isNameboardSeen
    }

    fun setIsNameboardSeen(isNameboardSeen: Boolean?) {
        this.isNameboardSeen = isNameboardSeen
    }

    fun getIsNameboardMismatch(): Boolean? {
        return isNameboardMismatch
    }

    fun setIsNameboardMismatch(isNameboardMismatch: Boolean?) {
        this.isNameboardMismatch = isNameboardMismatch
    }

    fun getNameboardMismatchReason(): String? {
        return nameboardMismatchReason
    }

    fun setNameboardMismatchReason(nameboardMismatchReason: String?) {
        this.nameboardMismatchReason = nameboardMismatchReason
    }

    fun getStayingTimeUnit(): String? {
        return stayingTimeUnit
    }

    fun setStayingTimeUnit(stayingTimeUnit: String?) {
        this.stayingTimeUnit = stayingTimeUnit
    }

    fun getApplicantFamilyDetails(): List<SaveResidanceApplicantFamilyDetail>? {
        return applicantFamilyDetails
    }

    fun setApplicantFamilyDetails(applicantFamilyDetails: List<SaveResidanceApplicantFamilyDetail>?) {
        this.applicantFamilyDetails = applicantFamilyDetails
    }


}