package com.example.mypraticeapplication.model.pendingRequest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetPendingRequestData {
    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("businessId")
    @Expose
    private var businessId: Int? = null

    @SerializedName("branchId")
    @Expose
    private var branchId: Int? = null

    @SerializedName("verificationType")
    @Expose
    private var verificationType: String? = null

    @SerializedName("verificationTypeName")
    @Expose
    private var verificationTypeName: String? = null

    @SerializedName("subType")
    @Expose
    private var subType: String? = null

    @SerializedName("verificationSubTypeId")
    @Expose
    private var verificationSubTypeId: Any? = null

    @SerializedName("financeInstituteId")
    @Expose
    private var financeInstituteId: Int? = null

    @SerializedName("financialInstituteBranchId")
    @Expose
    private var financialInstituteBranchId: Int? = null

    @SerializedName("caseId")
    @Expose
    private var caseId: String? = null

    @SerializedName("caseDate")
    @Expose
    private var caseDate: String? = null

    @SerializedName("refNo")
    @Expose
    private var refNo: String? = null

    @SerializedName("refSrNo")
    @Expose
    private var refSrNo: Int? = null

    @SerializedName("secondaryType")
    @Expose
    private var secondaryType: String? = null

    @SerializedName("applicantName")
    @Expose
    private var applicantName: String? = null

    @SerializedName("applicantGender")
    @Expose
    private var applicantGender: String? = null

    @SerializedName("applicantFatherName")
    @Expose
    private var applicantFatherName: String? = null

    @SerializedName("applicantMobile")
    @Expose
    private var applicantMobile: String? = null

    @SerializedName("applicantSecondaryMobile")
    @Expose
    private var applicantSecondaryMobile: Any? = null

    @SerializedName("applicantAddress")
    @Expose
    private var applicantAddress: String? = null

    @SerializedName("applicantPinCode")
    @Expose
    private var applicantPinCode: String? = null

    @SerializedName("applicantCity")
    @Expose
    private var applicantCity: String? = null

    @SerializedName("applicantState")
    @Expose
    private var applicantState: String? = null

    @SerializedName("applicantVpo")
    @Expose
    private var applicantVpo: String? = null

    @SerializedName("applicantTehsil")
    @Expose
    private var applicantTehsil: String? = null

    @SerializedName("applicantLatitude")
    @Expose
    private var applicantLatitude: Any? = null

    @SerializedName("applicantLongitude")
    @Expose
    private var applicantLongitude: Any? = null

    @SerializedName("applicantAadhar")
    @Expose
    private var applicantAadhar: Any? = null

    @SerializedName("applicantPan")
    @Expose
    private var applicantPan: Any? = null

    @SerializedName("applicantDob")
    @Expose
    private var applicantDob: Any? = null

    @SerializedName("loanProductId")
    @Expose
    private var loanProductId: Int? = null

    @SerializedName("subLoanProduct")
    @Expose
    private var subLoanProduct: String? = null

    @SerializedName("assetName")
    @Expose
    private var assetName: Any? = null

    @SerializedName("distanceType")
    @Expose
    private var distanceType: Any? = null

    @SerializedName("prePost")
    @Expose
    private var prePost: Any? = null

    @SerializedName("businessName")
    @Expose
    private var businessName: Any? = null

    @SerializedName("loanAmount")
    @Expose
    private var loanAmount: Any? = null

    @SerializedName("triggerRemarks")
    @Expose
    private var triggerRemarks: String? = null

    @SerializedName("dedupCheck")
    @Expose
    private var dedupCheck: String? = null

    @SerializedName("dedupCheckRemarks")
    @Expose
    private var dedupCheckRemarks: String? = null

    @SerializedName("typeOfVendor")
    @Expose
    private var typeOfVendor: String? = null

    @SerializedName("typeOfBusiness")
    @Expose
    private var typeOfBusiness: String? = null

    @SerializedName("createBy")
    @Expose
    private var createBy: Int? = null

    @SerializedName("createDate")
    @Expose
    private var createDate: String? = null

    @SerializedName("modifyBy")
    @Expose
    private var modifyBy: Int? = null

    @SerializedName("modifyDate")
    @Expose
    private var modifyDate: String? = null

    @SerializedName("documentName")
    @Expose
    private var documentName: Any? = null

    @SerializedName("bankName")
    @Expose
    private var bankName: String? = null

    @SerializedName("bankAlias")
    @Expose
    private var bankAlias: String? = null

    @SerializedName("loanProductName")
    @Expose
    private var loanProductName: String? = null

    @SerializedName("fistatus")
    @Expose
    private var fistatus: Int? = null

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("ficreatedAt")
    @Expose
    private var ficreatedAt: String? = null

    @SerializedName("ficreatedBy")
    @Expose
    private var ficreatedBy: Int? = null

    @SerializedName("fiassignedAt")
    @Expose
    private var fiassignedAt: String? = null

    @SerializedName("fiassignedBy")
    @Expose
    private var fiassignedBy: Int? = null

    @SerializedName("fiverifiedAt")
    @Expose
    private var fiverifiedAt: Any? = null

    @SerializedName("employeeId")
    @Expose
    private var employeeId: Int? = null

    @SerializedName("verifiedBy")
    @Expose
    private var verifiedBy: Any? = null

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getBusinessId(): Int? {
        return businessId
    }

    fun setBusinessId(businessId: Int?) {
        this.businessId = businessId
    }

    fun getBranchId(): Int? {
        return branchId
    }

    fun setBranchId(branchId: Int?) {
        this.branchId = branchId
    }

    fun getVerificationType(): String? {
        return verificationType
    }

    fun setVerificationType(verificationType: String?) {
        this.verificationType = verificationType
    }

    fun getVerificationTypeName(): String? {
        return verificationTypeName
    }

    fun setVerificationTypeName(verificationTypeName: String?) {
        this.verificationTypeName = verificationTypeName
    }

    fun getSubType(): String? {
        return subType
    }

    fun setSubType(subType: String?) {
        this.subType = subType
    }

    fun getVerificationSubTypeId(): Any? {
        return verificationSubTypeId
    }

    fun setVerificationSubTypeId(verificationSubTypeId: Any?) {
        this.verificationSubTypeId = verificationSubTypeId
    }

    fun getFinanceInstituteId(): Int? {
        return financeInstituteId
    }

    fun setFinanceInstituteId(financeInstituteId: Int?) {
        this.financeInstituteId = financeInstituteId
    }

    fun getFinancialInstituteBranchId(): Int? {
        return financialInstituteBranchId
    }

    fun setFinancialInstituteBranchId(financialInstituteBranchId: Int?) {
        this.financialInstituteBranchId = financialInstituteBranchId
    }

    fun getCaseId(): String? {
        return caseId
    }

    fun setCaseId(caseId: String?) {
        this.caseId = caseId
    }

    fun getCaseDate(): String? {
        return caseDate
    }

    fun setCaseDate(caseDate: String?) {
        this.caseDate = caseDate
    }

    fun getRefNo(): String? {
        return refNo
    }

    fun setRefNo(refNo: String?) {
        this.refNo = refNo
    }

    fun getRefSrNo(): Int? {
        return refSrNo
    }

    fun setRefSrNo(refSrNo: Int?) {
        this.refSrNo = refSrNo
    }

    fun getSecondaryType(): String? {
        return secondaryType
    }

    fun setSecondaryType(secondaryType: String?) {
        this.secondaryType = secondaryType
    }

    fun getApplicantName(): String? {
        return applicantName
    }

    fun setApplicantName(applicantName: String?) {
        this.applicantName = applicantName
    }

    fun getApplicantGender(): String? {
        return applicantGender
    }

    fun setApplicantGender(applicantGender: String?) {
        this.applicantGender = applicantGender
    }

    fun getApplicantFatherName(): String? {
        return applicantFatherName
    }

    fun setApplicantFatherName(applicantFatherName: String?) {
        this.applicantFatherName = applicantFatherName
    }

    fun getApplicantMobile(): String? {
        return applicantMobile
    }

    fun setApplicantMobile(applicantMobile: String?) {
        this.applicantMobile = applicantMobile
    }

    fun getApplicantSecondaryMobile(): Any? {
        return applicantSecondaryMobile
    }

    fun setApplicantSecondaryMobile(applicantSecondaryMobile: Any?) {
        this.applicantSecondaryMobile = applicantSecondaryMobile
    }

    fun getApplicantAddress(): String? {
        return applicantAddress
    }

    fun setApplicantAddress(applicantAddress: String?) {
        this.applicantAddress = applicantAddress
    }

    fun getApplicantPinCode(): String? {
        return applicantPinCode
    }

    fun setApplicantPinCode(applicantPinCode: String?) {
        this.applicantPinCode = applicantPinCode
    }

    fun getApplicantCity(): String? {
        return applicantCity
    }

    fun setApplicantCity(applicantCity: String?) {
        this.applicantCity = applicantCity
    }

    fun getApplicantState(): String? {
        return applicantState
    }

    fun setApplicantState(applicantState: String?) {
        this.applicantState = applicantState
    }

    fun getApplicantVpo(): String? {
        return applicantVpo
    }

    fun setApplicantVpo(applicantVpo: String?) {
        this.applicantVpo = applicantVpo
    }

    fun getApplicantTehsil(): String? {
        return applicantTehsil
    }

    fun setApplicantTehsil(applicantTehsil: String?) {
        this.applicantTehsil = applicantTehsil
    }

    fun getApplicantLatitude(): Any? {
        return applicantLatitude
    }

    fun setApplicantLatitude(applicantLatitude: Any?) {
        this.applicantLatitude = applicantLatitude
    }

    fun getApplicantLongitude(): Any? {
        return applicantLongitude
    }

    fun setApplicantLongitude(applicantLongitude: Any?) {
        this.applicantLongitude = applicantLongitude
    }

    fun getApplicantAadhar(): Any? {
        return applicantAadhar
    }

    fun setApplicantAadhar(applicantAadhar: Any?) {
        this.applicantAadhar = applicantAadhar
    }

    fun getApplicantPan(): Any? {
        return applicantPan
    }

    fun setApplicantPan(applicantPan: Any?) {
        this.applicantPan = applicantPan
    }

    fun getApplicantDob(): Any? {
        return applicantDob
    }

    fun setApplicantDob(applicantDob: Any?) {
        this.applicantDob = applicantDob
    }

    fun getLoanProductId(): Int? {
        return loanProductId
    }

    fun setLoanProductId(loanProductId: Int?) {
        this.loanProductId = loanProductId
    }

    fun getSubLoanProduct(): String? {
        return subLoanProduct
    }

    fun setSubLoanProduct(subLoanProduct: String?) {
        this.subLoanProduct = subLoanProduct
    }

    fun getAssetName(): Any? {
        return assetName
    }

    fun setAssetName(assetName: Any?) {
        this.assetName = assetName
    }

    fun getDistanceType(): Any? {
        return distanceType
    }

    fun setDistanceType(distanceType: Any?) {
        this.distanceType = distanceType
    }

    fun getPrePost(): Any? {
        return prePost
    }

    fun setPrePost(prePost: Any?) {
        this.prePost = prePost
    }

    fun getBusinessName(): Any? {
        return businessName
    }

    fun setBusinessName(businessName: Any?) {
        this.businessName = businessName
    }

    fun getLoanAmount(): Any? {
        return loanAmount
    }

    fun setLoanAmount(loanAmount: Any?) {
        this.loanAmount = loanAmount
    }

    fun getTriggerRemarks(): String? {
        return triggerRemarks
    }

    fun setTriggerRemarks(triggerRemarks: String?) {
        this.triggerRemarks = triggerRemarks
    }

    fun getDedupCheck(): String? {
        return dedupCheck
    }

    fun setDedupCheck(dedupCheck: String?) {
        this.dedupCheck = dedupCheck
    }

    fun getDedupCheckRemarks(): String? {
        return dedupCheckRemarks
    }

    fun setDedupCheckRemarks(dedupCheckRemarks: String?) {
        this.dedupCheckRemarks = dedupCheckRemarks
    }

    fun getTypeOfVendor(): String? {
        return typeOfVendor
    }

    fun setTypeOfVendor(typeOfVendor: String?) {
        this.typeOfVendor = typeOfVendor
    }

    fun getTypeOfBusiness(): String? {
        return typeOfBusiness
    }

    fun setTypeOfBusiness(typeOfBusiness: String?) {
        this.typeOfBusiness = typeOfBusiness
    }

    fun getCreateBy(): Int? {
        return createBy
    }

    fun setCreateBy(createBy: Int?) {
        this.createBy = createBy
    }

    fun getCreateDate(): String? {
        return createDate
    }

    fun setCreateDate(createDate: String?) {
        this.createDate = createDate
    }

    fun getModifyBy(): Int? {
        return modifyBy
    }

    fun setModifyBy(modifyBy: Int?) {
        this.modifyBy = modifyBy
    }

    fun getModifyDate(): String? {
        return modifyDate
    }

    fun setModifyDate(modifyDate: String?) {
        this.modifyDate = modifyDate
    }

    fun getDocumentName(): Any? {
        return documentName
    }

    fun setDocumentName(documentName: Any?) {
        this.documentName = documentName
    }

    fun getBankName(): String? {
        return bankName
    }

    fun setBankName(bankName: String?) {
        this.bankName = bankName
    }

    fun getBankAlias(): String? {
        return bankAlias
    }

    fun setBankAlias(bankAlias: String?) {
        this.bankAlias = bankAlias
    }

    fun getLoanProductName(): String? {
        return loanProductName
    }

    fun setLoanProductName(loanProductName: String?) {
        this.loanProductName = loanProductName
    }

    fun getFistatus(): Int? {
        return fistatus
    }

    fun setFistatus(fistatus: Int?) {
        this.fistatus = fistatus
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getFicreatedAt(): String? {
        return ficreatedAt
    }

    fun setFicreatedAt(ficreatedAt: String?) {
        this.ficreatedAt = ficreatedAt
    }

    fun getFicreatedBy(): Int? {
        return ficreatedBy
    }

    fun setFicreatedBy(ficreatedBy: Int?) {
        this.ficreatedBy = ficreatedBy
    }

    fun getFiassignedAt(): String? {
        return fiassignedAt
    }

    fun setFiassignedAt(fiassignedAt: String?) {
        this.fiassignedAt = fiassignedAt
    }

    fun getFiassignedBy(): Int? {
        return fiassignedBy
    }

    fun setFiassignedBy(fiassignedBy: Int?) {
        this.fiassignedBy = fiassignedBy
    }

    fun getFiverifiedAt(): Any? {
        return fiverifiedAt
    }

    fun setFiverifiedAt(fiverifiedAt: Any?) {
        this.fiverifiedAt = fiverifiedAt
    }

    fun getEmployeeId(): Int? {
        return employeeId
    }

    fun setEmployeeId(employeeId: Int?) {
        this.employeeId = employeeId
    }

    fun getVerifiedBy(): Any? {
        return verifiedBy
    }

    fun setVerifiedBy(verifiedBy: Any?) {
        this.verifiedBy = verifiedBy
    }

}