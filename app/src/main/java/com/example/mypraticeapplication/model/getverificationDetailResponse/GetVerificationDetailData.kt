package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.example.mypraticeapplication.model.saveresidenceverification.SaveFirequestResidenceVerification
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetVerificationDetailData {

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

    @SerializedName("financeInstituteId")
    @Expose
    private var financeInstituteId: Int? = null

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
    private var distanceType: String? = null

    @SerializedName("prePost")
    @Expose
    private var prePost: String? = null

    @SerializedName("businessName")
    @Expose
    private var businessName: String? = null

    @SerializedName("loanAmount")
    @Expose
    private var loanAmount: Int? = null

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

    @SerializedName("secondaryType")
    @Expose
    private var secondaryType: String? = null

    @SerializedName("triggerRemarks")
    @Expose
    private var triggerRemarks: Any? = null

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

    @SerializedName("latitude")
    @Expose
    private var latitude: Any? = null

    @SerializedName("longitude")
    @Expose
    private var longitude: Any? = null

    @SerializedName("subType")
    @Expose
    private var subType: String? = null

    @SerializedName("documentVerificationSubTypeId")
    @Expose
    private var documentVerificationSubTypeId: Any? = null

    @SerializedName("typeOfVendor")
    @Expose
    private var typeOfVendor: Any? = null

    @SerializedName("typeOfBusiness")
    @Expose
    private var typeOfBusiness: String? = null

    @SerializedName("dedupCheck")
    @Expose
    private var dedupCheck: String? = null

    @SerializedName("dedupCheckRemarks")
    @Expose
    private var dedupCheckRemarks: Any? = null

    @SerializedName("financialInstituteBranchId")
    @Expose
    private var financialInstituteBranchId: Int? = null

    @SerializedName("bankName")
    @Expose
    private var bankName: String? = null

    @SerializedName("bankAddress")
    @Expose
    private var bankAddress: String? = null

    @SerializedName("bankCity")
    @Expose
    private var bankCity: String? = null

    @SerializedName("bankState")
    @Expose
    private var bankState: String? = null

    @SerializedName("bankPincode")
    @Expose
    private var bankPincode: String? = null

    @SerializedName("bankEmail")
    @Expose
    private var bankEmail: String? = null

    @SerializedName("bankAlias")
    @Expose
    private var bankAlias: String? = null

    @SerializedName("bankLogo")
    @Expose
    private var bankLogo: String? = null

    @SerializedName("loanProductName")
    @Expose
    private var loanProductName: String? = null

    @SerializedName("fistatus")
    @Expose
    private var fistatus: Int? = null

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

    @SerializedName("employeeId")
    @Expose
    private var employeeId: Int? = null

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("documentName")
    @Expose
    private var documentName: Any? = null

    @SerializedName("ferejectedReason")
    @Expose
    private var ferejectedReason: Any? = null

    @SerializedName("ferejectedAt")
    @Expose
    private var ferejectedAt: Any? = null

    @SerializedName("rejectReason")
    @Expose
    private var rejectReason: Any? = null

    @SerializedName("referredBy")
    @Expose
    private var referredBy: Any? = null

    @SerializedName("referredAt")
    @Expose
    private var referredAt: Any? = null

    @SerializedName("referredRemark")
    @Expose
    private var referredRemark: Any? = null

    @SerializedName("whatsappMessage")
    @Expose
    private var whatsappMessage: Any? = null

    @SerializedName("isMarkedInfo")
    @Expose
    private var isMarkedInfo: Boolean? = null

    @SerializedName("fiverifiedById")
    @Expose
    private var fiverifiedById: Any? = null

    @SerializedName("branchName")
    @Expose
    private var branchName: String? = null

    @SerializedName("branchState")
    @Expose
    private var branchState: String? = null

    @SerializedName("branchCity")
    @Expose
    private var branchCity: String? = null

    @SerializedName("ficlosedByById")
    @Expose
    private var ficlosedByById: Any? = null

    @SerializedName("otherApplicantName")
    @Expose
    private var otherApplicantName: String? = ""

    @SerializedName("verificationTypeName")
    @Expose
    private var verificationTypeName: String? = null

    @SerializedName("uniqueRefNo")
    @Expose
    private var uniqueRefNo: Any? = null

    @SerializedName("applicantBank")
    @Expose
    private var applicantBank: Any? = null

    @SerializedName("assessmentYear")
    @Expose
    private var assessmentYear: Any? = null

    @SerializedName("backendName")
    @Expose
    private var backendName: String? = null

    @SerializedName("backendMobileNo")
    @Expose
    private var backendMobileNo: String? = null

    @SerializedName("firequestBusinessVerification")
    @Expose
    private var firequestBusinessVerification: GetFiRequestBusinessVerification? = null

    @SerializedName("firequestResidenceVerification")
    @Expose
    private var firequestResidenceVerification: SaveFirequestResidenceVerification? = null

    @SerializedName("fiRequestResiBusinessVerification")
    @Expose
    private var fiRequestResiBusinessVerification: Any? = null

    @SerializedName("fiRequestOfficeVerification")
    @Expose
    private var fiRequestOfficeVerification: Any? = null

    @SerializedName("firequestVehicleVerification")
    @Expose
    private var firequestVehicleVerification: Any? = null

    @SerializedName("firequestDocumentVerification")
    @Expose
    private var firequestDocumentVerification: Any? = null

    @SerializedName("firequestDocumentProfileVerification")
    @Expose
    private var firequestDocumentProfileVerification: Any? = null

    @SerializedName("firequestInsuranceVerification")
    @Expose
    private var firequestInsuranceVerification: Any? = null

    @SerializedName("firequestEmployeeVerification")
    @Expose
    private var firequestEmployeeVerification: Any? = null

    @SerializedName("firequestVendorVerification")
    @Expose
    private var firequestVendorVerification: Any? = null

    @SerializedName("firequestAssetVerification")
    @Expose
    private var firequestAssetVerification: Any? = null

    @SerializedName("firequestPropertyVerification")
    @Expose
    private var firequestPropertyVerification: Any? = null

    @SerializedName("firequestVerificationDocuments")
    @Expose
    private var firequestVerificationDocuments: List<GetFiVerificationDocument>? = null

    @SerializedName("allocators")
    @Expose
    private var allocators: Any? = null

    @SerializedName("firequestPreNeighboutVerificationDto")
    @Expose
    private var firequestPreNeighboutVerificationDto: GetFiRequestPreNeighboutVerificationDto? = null

    @SerializedName("firequestPostNeighboutVerificationDto")
    @Expose
    private var firequestPostNeighboutVerificationDto: GetFirequestPostNeighboutVerificationDto? = null

    @SerializedName("documents")
    @Expose
    private var documents: ArrayList<GetVerificationDocument>? = null

    @SerializedName("firequestReviewSubmissionDto")
    @Expose
    private var firequestReviewSubmissionDto: GetFirequestReviewSubmissionDto? = null

    @SerializedName("firequestReferredSubmissionDto")
    @Expose
    private var firequestReferredSubmissionDto: getFirequestReferredSubmissionDto? = null

    @SerializedName("firequestFinalSubmissionDto")
    @Expose
    private var firequestFinalSubmissionDto: GetFirequestFinalSubmissionDto? = null

    @SerializedName("firequestQualitySubmissionDto")
    @Expose
    private var firequestQualitySubmissionDto: GetFirequestQualitySubmissionDto? = null

    @SerializedName("fiRequestDto")
    @Expose
    private var fiRequestDto: Any? = null

    @SerializedName("firequestSelection")
    @Expose
    private var firequestSelection: Any? = null

    @SerializedName("firequestCoApplicantDetailDto")
    @Expose
    private var firequestCoApplicantDetailDto: List<GetFirequestCoApplicantDetailDto>? = null

    @SerializedName("firequestBusinessOwnerDetailDto")
    @Expose
    private var firequestBusinessOwnerDetailDto: List<Any>? = null

    @SerializedName("ficlosureDetailDto")
    @Expose
    private var ficlosureDetailDto: Any? = null

    @SerializedName("customInputDto")
    @Expose
    private var customInputDto: Any? = null

    @SerializedName("fiactionReport")
    @Expose
    private var fiactionReport: GetFiactionReport? = null

    @SerializedName("firequestAdditionalDetailDto")
    @Expose
    private var firequestAdditionalDetailDto: GetFirequestAdditionalDetailDto? = null


    // All Verification Type
    var isResidenceVerification: Boolean = false
    var isRCOVerification: Boolean = false

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

    fun getFinanceInstituteId(): Int? {
        return financeInstituteId
    }

    fun setFinanceInstituteId(financeInstituteId: Int?) {
        this.financeInstituteId = financeInstituteId
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

    fun getDistanceType(): String? {
        return distanceType
    }

    fun setDistanceType(distanceType: String?) {
        this.distanceType = distanceType
    }

    fun getPrePost(): String? {
        return prePost
    }

    fun setPrePost(prePost: String?) {
        this.prePost = prePost
    }

    fun getBusinessName(): String? {
        return businessName
    }

    fun setBusinessName(businessName: String?) {
        this.businessName = businessName
    }

    fun getLoanAmount(): Int? {
        return loanAmount
    }

    fun setLoanAmount(loanAmount: Int?) {
        this.loanAmount = loanAmount
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

    fun getSecondaryType(): String? {
        return secondaryType
    }

    fun setSecondaryType(secondaryType: String?) {
        this.secondaryType = secondaryType
    }

    fun getTriggerRemarks(): Any? {
        return triggerRemarks
    }

    fun setTriggerRemarks(triggerRemarks: Any?) {
        this.triggerRemarks = triggerRemarks
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

    fun getLatitude(): Any? {
        return latitude
    }

    fun setLatitude(latitude: Any?) {
        this.latitude = latitude
    }

    fun getLongitude(): Any? {
        return longitude
    }

    fun setLongitude(longitude: Any?) {
        this.longitude = longitude
    }

    fun getSubType(): String? {
        return subType
    }

    fun setSubType(subType: String?) {
        this.subType = subType
    }

    fun getDocumentVerificationSubTypeId(): Any? {
        return documentVerificationSubTypeId
    }

    fun setDocumentVerificationSubTypeId(documentVerificationSubTypeId: Any?) {
        this.documentVerificationSubTypeId = documentVerificationSubTypeId
    }

    fun getTypeOfVendor(): Any? {
        return typeOfVendor
    }

    fun setTypeOfVendor(typeOfVendor: Any?) {
        this.typeOfVendor = typeOfVendor
    }

    fun getTypeOfBusiness(): String? {
        return typeOfBusiness
    }

    fun setTypeOfBusiness(typeOfBusiness: String?) {
        this.typeOfBusiness = typeOfBusiness
    }

    fun getDedupCheck(): String? {
        return dedupCheck
    }

    fun setDedupCheck(dedupCheck: String?) {
        this.dedupCheck = dedupCheck
    }

    fun getDedupCheckRemarks(): Any? {
        return dedupCheckRemarks
    }

    fun setDedupCheckRemarks(dedupCheckRemarks: Any?) {
        this.dedupCheckRemarks = dedupCheckRemarks
    }

    fun getFinancialInstituteBranchId(): Int? {
        return financialInstituteBranchId
    }

    fun setFinancialInstituteBranchId(financialInstituteBranchId: Int?) {
        this.financialInstituteBranchId = financialInstituteBranchId
    }

    fun getBankName(): String? {
        return bankName
    }

    fun setBankName(bankName: String?) {
        this.bankName = bankName
    }

    fun getBankAddress(): String? {
        return bankAddress
    }

    fun setBankAddress(bankAddress: String?) {
        this.bankAddress = bankAddress
    }

    fun getBankCity(): String? {
        return bankCity
    }

    fun setBankCity(bankCity: String?) {
        this.bankCity = bankCity
    }

    fun getBankState(): String? {
        return bankState
    }

    fun setBankState(bankState: String?) {
        this.bankState = bankState
    }

    fun getBankPincode(): String? {
        return bankPincode
    }

    fun setBankPincode(bankPincode: String?) {
        this.bankPincode = bankPincode
    }

    fun getBankEmail(): String? {
        return bankEmail
    }

    fun setBankEmail(bankEmail: String?) {
        this.bankEmail = bankEmail
    }

    fun getBankAlias(): String? {
        return bankAlias
    }

    fun setBankAlias(bankAlias: String?) {
        this.bankAlias = bankAlias
    }

    fun getBankLogo(): String? {
        return bankLogo
    }

    fun setBankLogo(bankLogo: String?) {
        this.bankLogo = bankLogo
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

    fun getEmployeeId(): Int? {
        return employeeId
    }

    fun setEmployeeId(employeeId: Int?) {
        this.employeeId = employeeId
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getDocumentName(): Any? {
        return documentName
    }

    fun setDocumentName(documentName: Any?) {
        this.documentName = documentName
    }

    fun getFerejectedReason(): Any? {
        return ferejectedReason
    }

    fun setFerejectedReason(ferejectedReason: Any?) {
        this.ferejectedReason = ferejectedReason
    }

    fun getFerejectedAt(): Any? {
        return ferejectedAt
    }

    fun setFerejectedAt(ferejectedAt: Any?) {
        this.ferejectedAt = ferejectedAt
    }

    fun getRejectReason(): Any? {
        return rejectReason
    }

    fun setRejectReason(rejectReason: Any?) {
        this.rejectReason = rejectReason
    }

    fun getReferredBy(): Any? {
        return referredBy
    }

    fun setReferredBy(referredBy: Any?) {
        this.referredBy = referredBy
    }

    fun getReferredAt(): Any? {
        return referredAt
    }

    fun setReferredAt(referredAt: Any?) {
        this.referredAt = referredAt
    }

    fun getReferredRemark(): Any? {
        return referredRemark
    }

    fun setReferredRemark(referredRemark: Any?) {
        this.referredRemark = referredRemark
    }

    fun getWhatsappMessage(): Any? {
        return whatsappMessage
    }

    fun setWhatsappMessage(whatsappMessage: Any?) {
        this.whatsappMessage = whatsappMessage
    }

    fun getIsMarkedInfo(): Boolean? {
        return isMarkedInfo
    }

    fun setIsMarkedInfo(isMarkedInfo: Boolean?) {
        this.isMarkedInfo = isMarkedInfo
    }

    fun getFiverifiedById(): Any? {
        return fiverifiedById
    }

    fun setFiverifiedById(fiverifiedById: Any?) {
        this.fiverifiedById = fiverifiedById
    }

    fun getBranchName(): String? {
        return branchName
    }

    fun setBranchName(branchName: String?) {
        this.branchName = branchName
    }

    fun getBranchState(): String? {
        return branchState
    }

    fun setBranchState(branchState: String?) {
        this.branchState = branchState
    }

    fun getBranchCity(): String? {
        return branchCity
    }

    fun setBranchCity(branchCity: String?) {
        this.branchCity = branchCity
    }

    fun getFiclosedByById(): Any? {
        return ficlosedByById
    }

    fun setFiclosedByById(ficlosedByById: Any?) {
        this.ficlosedByById = ficlosedByById
    }

    fun getOtherApplicantName(): String? {
        return otherApplicantName
    }

    fun setOtherApplicantName(otherApplicantName: String?) {
        this.otherApplicantName = otherApplicantName
    }

    fun getVerificationTypeName(): String? {
        return verificationTypeName
    }

    fun setVerificationTypeName(verificationTypeName: String?) {
        this.verificationTypeName = verificationTypeName
    }

    fun getUniqueRefNo(): Any? {
        return uniqueRefNo
    }

    fun setUniqueRefNo(uniqueRefNo: Any?) {
        this.uniqueRefNo = uniqueRefNo
    }

    fun getApplicantBank(): Any? {
        return applicantBank
    }

    fun setApplicantBank(applicantBank: Any?) {
        this.applicantBank = applicantBank
    }

    fun getAssessmentYear(): Any? {
        return assessmentYear
    }

    fun setAssessmentYear(assessmentYear: Any?) {
        this.assessmentYear = assessmentYear
    }

    fun getBackendName(): String? {
        return backendName
    }

    fun setBackendName(backendName: String?) {
        this.backendName = backendName
    }

    fun getBackendMobileNo(): String? {
        return backendMobileNo
    }

    fun setBackendMobileNo(backendMobileNo: String?) {
        this.backendMobileNo = backendMobileNo
    }

    fun getFiRequestBusinessVerification(): GetFiRequestBusinessVerification? {
        return firequestBusinessVerification
    }

    fun setFiRequestBusinessVerification(fiRequestBusinessVerification: SaveFirequestResidenceVerification?) {
        this.firequestBusinessVerification = firequestBusinessVerification
    }

    fun getFiRequestResidenceVerification(): SaveFirequestResidenceVerification? {
        return firequestResidenceVerification
    }

    fun setFiRequestResidenceVerification(fiRequestResidenceVerification: SaveFirequestResidenceVerification?) {
        this.firequestResidenceVerification = firequestResidenceVerification
    }

    fun getFiRequestResiBusinessVerification(): Any? {
        return fiRequestResiBusinessVerification
    }

    fun setFiRequestResiBusinessVerification(fiRequestResiBusinessVerification: Any?) {
        this.fiRequestResiBusinessVerification = fiRequestResiBusinessVerification
    }

    fun getFiRequestOfficeVerification(): Any? {
        return fiRequestOfficeVerification
    }

    fun setFiRequestOfficeVerification(fiRequestOfficeVerification: Any?) {
        this.fiRequestOfficeVerification = fiRequestOfficeVerification
    }

    fun getFirequestVehicleVerification(): Any? {
        return firequestVehicleVerification
    }

    fun setFirequestVehicleVerification(firequestVehicleVerification: Any?) {
        this.firequestVehicleVerification = firequestVehicleVerification
    }

    fun getFirequestDocumentVerification(): Any? {
        return firequestDocumentVerification
    }

    fun setFirequestDocumentVerification(firequestDocumentVerification: Any?) {
        this.firequestDocumentVerification = firequestDocumentVerification
    }

    fun getFirequestDocumentProfileVerification(): Any? {
        return firequestDocumentProfileVerification
    }

    fun setFirequestDocumentProfileVerification(firequestDocumentProfileVerification: Any?) {
        this.firequestDocumentProfileVerification = firequestDocumentProfileVerification
    }

    fun getFirequestInsuranceVerification(): Any? {
        return firequestInsuranceVerification
    }

    fun setFirequestInsuranceVerification(firequestInsuranceVerification: Any?) {
        this.firequestInsuranceVerification = firequestInsuranceVerification
    }

    fun getFirequestEmployeeVerification(): Any? {
        return firequestEmployeeVerification
    }

    fun setFirequestEmployeeVerification(firequestEmployeeVerification: Any?) {
        this.firequestEmployeeVerification = firequestEmployeeVerification
    }

    fun getFirequestVendorVerification(): Any? {
        return firequestVendorVerification
    }

    fun setFirequestVendorVerification(firequestVendorVerification: Any?) {
        this.firequestVendorVerification = firequestVendorVerification
    }

    fun getFirequestAssetVerification(): Any? {
        return firequestAssetVerification
    }

    fun setFirequestAssetVerification(firequestAssetVerification: Any?) {
        this.firequestAssetVerification = firequestAssetVerification
    }

    fun getFirequestPropertyVerification(): Any? {
        return firequestPropertyVerification
    }

    fun setFirequestPropertyVerification(firequestPropertyVerification: Any?) {
        this.firequestPropertyVerification = firequestPropertyVerification
    }

    fun getFirequestVerificationDocuments(): List<GetFiVerificationDocument>? {
        return firequestVerificationDocuments
    }

    fun setFirequestVerificationDocuments(firequestVerificationDocuments: List<GetFiVerificationDocument>?) {
        this.firequestVerificationDocuments = firequestVerificationDocuments
    }

    fun getAllocators(): Any? {
        return allocators
    }

    fun setAllocators(allocators: Any?) {
        this.allocators = allocators
    }

    fun getFirequestPreNeighboutVerificationDto(): GetFiRequestPreNeighboutVerificationDto? {
        return firequestPreNeighboutVerificationDto
    }

    fun setFirequestPreNeighboutVerificationDto(firequestPreNeighboutVerificationDto: GetFiRequestPreNeighboutVerificationDto?) {
        this.firequestPreNeighboutVerificationDto = firequestPreNeighboutVerificationDto
    }

    fun getFirequestPostNeighboutVerificationDto(): GetFirequestPostNeighboutVerificationDto? {
        return firequestPostNeighboutVerificationDto
    }

    fun setFirequestPostNeighboutVerificationDto(firequestPostNeighboutVerificationDto: GetFirequestPostNeighboutVerificationDto?) {
        this.firequestPostNeighboutVerificationDto = firequestPostNeighboutVerificationDto
    }

    fun getDocuments(): ArrayList<GetVerificationDocument>? {
        return documents
    }

    fun setDocuments(documents: ArrayList<GetVerificationDocument>?) {
        this.documents = documents
    }

    fun getFirequestReviewSubmissionDto(): GetFirequestReviewSubmissionDto? {
        return firequestReviewSubmissionDto
    }

    fun setFirequestReviewSubmissionDto(firequestReviewSubmissionDto: GetFirequestReviewSubmissionDto?) {
        this.firequestReviewSubmissionDto = firequestReviewSubmissionDto
    }

    fun getFirequestReferredSubmissionDto(): getFirequestReferredSubmissionDto? {
        return firequestReferredSubmissionDto
    }

    fun setFirequestReferredSubmissionDto(firequestReferredSubmissionDto: getFirequestReferredSubmissionDto?) {
        this.firequestReferredSubmissionDto = firequestReferredSubmissionDto
    }

    fun getFirequestFinalSubmissionDto(): GetFirequestFinalSubmissionDto? {
        return firequestFinalSubmissionDto
    }

    fun setFirequestFinalSubmissionDto(firequestFinalSubmissionDto: GetFirequestFinalSubmissionDto?) {
        this.firequestFinalSubmissionDto = firequestFinalSubmissionDto
    }

    fun getFirequestQualitySubmissionDto(): GetFirequestQualitySubmissionDto? {
        return firequestQualitySubmissionDto
    }

    fun setFirequestQualitySubmissionDto(firequestQualitySubmissionDto: GetFirequestQualitySubmissionDto?) {
        this.firequestQualitySubmissionDto = firequestQualitySubmissionDto
    }

    fun getFiRequestDto(): Any? {
        return fiRequestDto
    }

    fun setFiRequestDto(fiRequestDto: Any?) {
        this.fiRequestDto = fiRequestDto
    }

    fun getFirequestSelection(): Any? {
        return firequestSelection
    }

    fun setFirequestSelection(firequestSelection: Any?) {
        this.firequestSelection = firequestSelection
    }

    fun getFirequestCoApplicantDetailDto(): List<GetFirequestCoApplicantDetailDto>? {
        return firequestCoApplicantDetailDto
    }

    fun setFirequestCoApplicantDetailDto(firequestCoApplicantDetailDto: List<GetFirequestCoApplicantDetailDto>?) {
        this.firequestCoApplicantDetailDto = firequestCoApplicantDetailDto
    }

    fun getFirequestBusinessOwnerDetailDto(): List<Any>? {
        return firequestBusinessOwnerDetailDto
    }

    fun setFirequestBusinessOwnerDetailDto(firequestBusinessOwnerDetailDto: List<Any>?) {
        this.firequestBusinessOwnerDetailDto = firequestBusinessOwnerDetailDto
    }

    fun getFiclosureDetailDto(): Any? {
        return ficlosureDetailDto
    }

    fun setFiclosureDetailDto(ficlosureDetailDto: Any?) {
        this.ficlosureDetailDto = ficlosureDetailDto
    }

    fun getCustomInputDto(): Any? {
        return customInputDto
    }

    fun setCustomInputDto(customInputDto: Any?) {
        this.customInputDto = customInputDto
    }

    fun getFiactionReport(): GetFiactionReport? {
        return fiactionReport
    }

    fun setFiactionReport(fiactionReport: GetFiactionReport?) {
        this.fiactionReport = fiactionReport
    }

    fun getFirequestAdditionalDetailDto(): GetFirequestAdditionalDetailDto? {
        return firequestAdditionalDetailDto
    }

    fun setFirequestAdditionalDetailDto(firequestAdditionalDetailDto: GetFirequestAdditionalDetailDto?) {
        this.firequestAdditionalDetailDto = firequestAdditionalDetailDto
    }

}