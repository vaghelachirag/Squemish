package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetFiRequestBusinessVerification {

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("visitDate")
    @Expose
    private var visitDate: String? = null

    @SerializedName("addressConfirmed")
    @Expose
    private var addressConfirmed: Any? = null

    @SerializedName("isPremiseOpen")
    @Expose
    private var isPremiseOpen: Any? = null

    @SerializedName("isBusinessBoardSeen")
    @Expose
    private var isBusinessBoardSeen: Any? = null

    @SerializedName("isBusinessBoardMismatch")
    @Expose
    private var isBusinessBoardMismatch: Any? = null

    @SerializedName("businessBoardMismatchReason")
    @Expose
    private var businessBoardMismatchReason: Any? = null

    @SerializedName("personMet")
    @Expose
    private var personMet: Any? = null

    @SerializedName("personMobileNo")
    @Expose
    private var personMobileNo: Any? = null

    @SerializedName("personMetDesignation")
    @Expose
    private var personMetDesignation: Any? = null

    @SerializedName("businessRunningTime")
    @Expose
    private var businessRunningTime: Any? = null

    @SerializedName("businessRunningTimeAtCurrentLocation")
    @Expose
    private var businessRunningTimeAtCurrentLocation: Any? = null

    @SerializedName("isSeenBusinessDocument")
    @Expose
    private var isSeenBusinessDocument: Any? = null

    @SerializedName("businessDocumentSeen")
    @Expose
    private var businessDocumentSeen: Any? = null

    @SerializedName("businessDocumentRemarks")
    @Expose
    private var businessDocumentRemarks: Any? = null

    @SerializedName("bussinessNature")
    @Expose
    private var bussinessNature: Any? = null

    @SerializedName("buildingOwnership")
    @Expose
    private var buildingOwnership: Any? = null

    @SerializedName("rent")
    @Expose
    private var rent: Any? = null

    @SerializedName("isPoliticalConnection")
    @Expose
    private var isPoliticalConnection: Any? = null

    @SerializedName("politicalRemarks")
    @Expose
    private var politicalRemarks: Any? = null

    @SerializedName("isMedicalHistory")
    @Expose
    private var isMedicalHistory: Any? = null

    @SerializedName("medicalHistoryRemarks")
    @Expose
    private var medicalHistoryRemarks: Any? = null

    @SerializedName("isAnyOtherLoan")
    @Expose
    private var isAnyOtherLoan: Any? = null

    @SerializedName("bankName")
    @Expose
    private var bankName: Any? = null

    @SerializedName("loanAmount")
    @Expose
    private var loanAmount: Any? = null

    @SerializedName("runningSince")
    @Expose
    private var runningSince: Any? = null

    @SerializedName("officeLocality")
    @Expose
    private var officeLocality: Any? = null

    @SerializedName("isAddressBelongsApplicant")
    @Expose
    private var isAddressBelongsApplicant: Any? = null

    @SerializedName("isAddressBelongsApplicantRemark")
    @Expose
    private var isAddressBelongsApplicantRemark: Any? = null

    @SerializedName("personMetAge")
    @Expose
    private var personMetAge: Any? = null

    @SerializedName("constitutionType")
    @Expose
    private var constitutionType: Any? = null

    @SerializedName("isQrcodeSeen")
    @Expose
    private var isQrcodeSeen: Any? = null

    @SerializedName("stockSighted")
    @Expose
    private var stockSighted: Any? = null

    @SerializedName("officeSizeUnit")
    @Expose
    private var officeSizeUnit: Any? = null

    @SerializedName("officeSetup")
    @Expose
    private var officeSetup: Any? = null

    @SerializedName("isNegativeProfile")
    @Expose
    private var isNegativeProfile: Any? = null

    @SerializedName("businessClientName")
    @Expose
    private var businessClientName: Any? = null

    @SerializedName("businessClientNameMobile")
    @Expose
    private var businessClientNameMobile: Any? = null

    @SerializedName("otherObservations")
    @Expose
    private var otherObservations: Any? = null

    @SerializedName("isAreaNegative")
    @Expose
    private var isAreaNegative: Any? = null

    @SerializedName("isAreaNegativeRemark")
    @Expose
    private var isAreaNegativeRemark: Any? = null

    @SerializedName("isCastCommunity")
    @Expose
    private var isCastCommunity: Any? = null

    @SerializedName("isCastCommunityRemark")
    @Expose
    private var isCastCommunityRemark: Any? = null

    @SerializedName("officeSize")
    @Expose
    private var officeSize: Any? = null

    @SerializedName("negativeProfileRemark")
    @Expose
    private var negativeProfileRemark: Any? = null

    @SerializedName("noOfEmployeeConfirmed")
    @Expose
    private var noOfEmployeeConfirmed: Any? = null

    @SerializedName("noOfEmployeeSeen")
    @Expose
    private var noOfEmployeeSeen: Any? = null

    @SerializedName("typeOfPremise")
    @Expose
    private var typeOfPremise: Any? = null

    @SerializedName("longitude")
    @Expose
    private var longitude: Any? = null

    @SerializedName("latitude")
    @Expose
    private var latitude: Any? = null

    @SerializedName("businessRunningTimeUnit")
    @Expose
    private var businessRunningTimeUnit: Any? = null

    @SerializedName("currentLocationBusinessRunningTimeUnit")
    @Expose
    private var currentLocationBusinessRunningTimeUnit: Any? = null

    @SerializedName("firequestDirectorDetail")
    @Expose
    private var firequestDirectorDetail: List<Any>? = null

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

    fun getAddressConfirmed(): Any? {
        return addressConfirmed
    }

    fun setAddressConfirmed(addressConfirmed: Any?) {
        this.addressConfirmed = addressConfirmed
    }

    fun getIsPremiseOpen(): Any? {
        return isPremiseOpen
    }

    fun setIsPremiseOpen(isPremiseOpen: Any?) {
        this.isPremiseOpen = isPremiseOpen
    }

    fun getIsBusinessBoardSeen(): Any? {
        return isBusinessBoardSeen
    }

    fun setIsBusinessBoardSeen(isBusinessBoardSeen: Any?) {
        this.isBusinessBoardSeen = isBusinessBoardSeen
    }

    fun getIsBusinessBoardMismatch(): Any? {
        return isBusinessBoardMismatch
    }

    fun setIsBusinessBoardMismatch(isBusinessBoardMismatch: Any?) {
        this.isBusinessBoardMismatch = isBusinessBoardMismatch
    }

    fun getBusinessBoardMismatchReason(): Any? {
        return businessBoardMismatchReason
    }

    fun setBusinessBoardMismatchReason(businessBoardMismatchReason: Any?) {
        this.businessBoardMismatchReason = businessBoardMismatchReason
    }

    fun getPersonMet(): Any? {
        return personMet
    }

    fun setPersonMet(personMet: Any?) {
        this.personMet = personMet
    }

    fun getPersonMobileNo(): Any? {
        return personMobileNo
    }

    fun setPersonMobileNo(personMobileNo: Any?) {
        this.personMobileNo = personMobileNo
    }

    fun getPersonMetDesignation(): Any? {
        return personMetDesignation
    }

    fun setPersonMetDesignation(personMetDesignation: Any?) {
        this.personMetDesignation = personMetDesignation
    }

    fun getBusinessRunningTime(): Any? {
        return businessRunningTime
    }

    fun setBusinessRunningTime(businessRunningTime: Any?) {
        this.businessRunningTime = businessRunningTime
    }

    fun getBusinessRunningTimeAtCurrentLocation(): Any? {
        return businessRunningTimeAtCurrentLocation
    }

    fun setBusinessRunningTimeAtCurrentLocation(businessRunningTimeAtCurrentLocation: Any?) {
        this.businessRunningTimeAtCurrentLocation = businessRunningTimeAtCurrentLocation
    }

    fun getIsSeenBusinessDocument(): Any? {
        return isSeenBusinessDocument
    }

    fun setIsSeenBusinessDocument(isSeenBusinessDocument: Any?) {
        this.isSeenBusinessDocument = isSeenBusinessDocument
    }

    fun getBusinessDocumentSeen(): Any? {
        return businessDocumentSeen
    }

    fun setBusinessDocumentSeen(businessDocumentSeen: Any?) {
        this.businessDocumentSeen = businessDocumentSeen
    }

    fun getBusinessDocumentRemarks(): Any? {
        return businessDocumentRemarks
    }

    fun setBusinessDocumentRemarks(businessDocumentRemarks: Any?) {
        this.businessDocumentRemarks = businessDocumentRemarks
    }

    fun getBussinessNature(): Any? {
        return bussinessNature
    }

    fun setBussinessNature(bussinessNature: Any?) {
        this.bussinessNature = bussinessNature
    }

    fun getBuildingOwnership(): Any? {
        return buildingOwnership
    }

    fun setBuildingOwnership(buildingOwnership: Any?) {
        this.buildingOwnership = buildingOwnership
    }

    fun getRent(): Any? {
        return rent
    }

    fun setRent(rent: Any?) {
        this.rent = rent
    }

    fun getIsPoliticalConnection(): Any? {
        return isPoliticalConnection
    }

    fun setIsPoliticalConnection(isPoliticalConnection: Any?) {
        this.isPoliticalConnection = isPoliticalConnection
    }

    fun getPoliticalRemarks(): Any? {
        return politicalRemarks
    }

    fun setPoliticalRemarks(politicalRemarks: Any?) {
        this.politicalRemarks = politicalRemarks
    }

    fun getIsMedicalHistory(): Any? {
        return isMedicalHistory
    }

    fun setIsMedicalHistory(isMedicalHistory: Any?) {
        this.isMedicalHistory = isMedicalHistory
    }

    fun getMedicalHistoryRemarks(): Any? {
        return medicalHistoryRemarks
    }

    fun setMedicalHistoryRemarks(medicalHistoryRemarks: Any?) {
        this.medicalHistoryRemarks = medicalHistoryRemarks
    }

    fun getIsAnyOtherLoan(): Any? {
        return isAnyOtherLoan
    }

    fun setIsAnyOtherLoan(isAnyOtherLoan: Any?) {
        this.isAnyOtherLoan = isAnyOtherLoan
    }

    fun getBankName(): Any? {
        return bankName
    }

    fun setBankName(bankName: Any?) {
        this.bankName = bankName
    }

    fun getLoanAmount(): Any? {
        return loanAmount
    }

    fun setLoanAmount(loanAmount: Any?) {
        this.loanAmount = loanAmount
    }

    fun getRunningSince(): Any? {
        return runningSince
    }

    fun setRunningSince(runningSince: Any?) {
        this.runningSince = runningSince
    }

    fun getOfficeLocality(): Any? {
        return officeLocality
    }

    fun setOfficeLocality(officeLocality: Any?) {
        this.officeLocality = officeLocality
    }

    fun getIsAddressBelongsApplicant(): Any? {
        return isAddressBelongsApplicant
    }

    fun setIsAddressBelongsApplicant(isAddressBelongsApplicant: Any?) {
        this.isAddressBelongsApplicant = isAddressBelongsApplicant
    }

    fun getIsAddressBelongsApplicantRemark(): Any? {
        return isAddressBelongsApplicantRemark
    }

    fun setIsAddressBelongsApplicantRemark(isAddressBelongsApplicantRemark: Any?) {
        this.isAddressBelongsApplicantRemark = isAddressBelongsApplicantRemark
    }

    fun getPersonMetAge(): Any? {
        return personMetAge
    }

    fun setPersonMetAge(personMetAge: Any?) {
        this.personMetAge = personMetAge
    }

    fun getConstitutionType(): Any? {
        return constitutionType
    }

    fun setConstitutionType(constitutionType: Any?) {
        this.constitutionType = constitutionType
    }

    fun getIsQrcodeSeen(): Any? {
        return isQrcodeSeen
    }

    fun setIsQrcodeSeen(isQrcodeSeen: Any?) {
        this.isQrcodeSeen = isQrcodeSeen
    }

    fun getStockSighted(): Any? {
        return stockSighted
    }

    fun setStockSighted(stockSighted: Any?) {
        this.stockSighted = stockSighted
    }

    fun getOfficeSizeUnit(): Any? {
        return officeSizeUnit
    }

    fun setOfficeSizeUnit(officeSizeUnit: Any?) {
        this.officeSizeUnit = officeSizeUnit
    }

    fun getOfficeSetup(): Any? {
        return officeSetup
    }

    fun setOfficeSetup(officeSetup: Any?) {
        this.officeSetup = officeSetup
    }

    fun getIsNegativeProfile(): Any? {
        return isNegativeProfile
    }

    fun setIsNegativeProfile(isNegativeProfile: Any?) {
        this.isNegativeProfile = isNegativeProfile
    }

    fun getBusinessClientName(): Any? {
        return businessClientName
    }

    fun setBusinessClientName(businessClientName: Any?) {
        this.businessClientName = businessClientName
    }

    fun getBusinessClientNameMobile(): Any? {
        return businessClientNameMobile
    }

    fun setBusinessClientNameMobile(businessClientNameMobile: Any?) {
        this.businessClientNameMobile = businessClientNameMobile
    }

    fun getOtherObservations(): Any? {
        return otherObservations
    }

    fun setOtherObservations(otherObservations: Any?) {
        this.otherObservations = otherObservations
    }

    fun getIsAreaNegative(): Any? {
        return isAreaNegative
    }

    fun setIsAreaNegative(isAreaNegative: Any?) {
        this.isAreaNegative = isAreaNegative
    }

    fun getIsAreaNegativeRemark(): Any? {
        return isAreaNegativeRemark
    }

    fun setIsAreaNegativeRemark(isAreaNegativeRemark: Any?) {
        this.isAreaNegativeRemark = isAreaNegativeRemark
    }

    fun getIsCastCommunity(): Any? {
        return isCastCommunity
    }

    fun setIsCastCommunity(isCastCommunity: Any?) {
        this.isCastCommunity = isCastCommunity
    }

    fun getIsCastCommunityRemark(): Any? {
        return isCastCommunityRemark
    }

    fun setIsCastCommunityRemark(isCastCommunityRemark: Any?) {
        this.isCastCommunityRemark = isCastCommunityRemark
    }

    fun getOfficeSize(): Any? {
        return officeSize
    }

    fun setOfficeSize(officeSize: Any?) {
        this.officeSize = officeSize
    }

    fun getNegativeProfileRemark(): Any? {
        return negativeProfileRemark
    }

    fun setNegativeProfileRemark(negativeProfileRemark: Any?) {
        this.negativeProfileRemark = negativeProfileRemark
    }

    fun getNoOfEmployeeConfirmed(): Any? {
        return noOfEmployeeConfirmed
    }

    fun setNoOfEmployeeConfirmed(noOfEmployeeConfirmed: Any?) {
        this.noOfEmployeeConfirmed = noOfEmployeeConfirmed
    }

    fun getNoOfEmployeeSeen(): Any? {
        return noOfEmployeeSeen
    }

    fun setNoOfEmployeeSeen(noOfEmployeeSeen: Any?) {
        this.noOfEmployeeSeen = noOfEmployeeSeen
    }

    fun getTypeOfPremise(): Any? {
        return typeOfPremise
    }

    fun setTypeOfPremise(typeOfPremise: Any?) {
        this.typeOfPremise = typeOfPremise
    }

    fun getLongitude(): Any? {
        return longitude
    }

    fun setLongitude(longitude: Any?) {
        this.longitude = longitude
    }

    fun getLatitude(): Any? {
        return latitude
    }

    fun setLatitude(latitude: Any?) {
        this.latitude = latitude
    }

    fun getBusinessRunningTimeUnit(): Any? {
        return businessRunningTimeUnit
    }

    fun setBusinessRunningTimeUnit(businessRunningTimeUnit: Any?) {
        this.businessRunningTimeUnit = businessRunningTimeUnit
    }

    fun getCurrentLocationBusinessRunningTimeUnit(): Any? {
        return currentLocationBusinessRunningTimeUnit
    }

    fun setCurrentLocationBusinessRunningTimeUnit(currentLocationBusinessRunningTimeUnit: Any?) {
        this.currentLocationBusinessRunningTimeUnit = currentLocationBusinessRunningTimeUnit
    }

    fun getFirequestDirectorDetail(): List<Any>? {
        return firequestDirectorDetail
    }

    fun setFirequestDirectorDetail(firequestDirectorDetail: List<Any>?) {
        this.firequestDirectorDetail = firequestDirectorDetail
    }

}