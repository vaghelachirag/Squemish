package com.example.mypraticeapplication.model.saveresidenceverification

import com.example.mypraticeapplication.model.saveDocumentProfileVerification.SaveDocumentProfileVerification
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class SaveVerificationDataDetail {


    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("verificationType")
    @Expose
    private var verificationType: String? = null

    @SerializedName("firequestBusinessVerification")
    @Expose
    private var firequestBusinessVerification: Any? = null

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
    private var firequestDocumentProfileVerification: SaveDocumentProfileVerification? = null

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
    private var firequestVerificationDocuments: List<Any>? = null

    @SerializedName("allocators")
    @Expose
    private var allocators: Any? = null

    @SerializedName("firequestPreNeighboutVerificationDto")
    @Expose
    private var firequestPreNeighboutVerificationDto: Any? = null

    @SerializedName("firequestPostNeighboutVerificationDto")
    @Expose
    private var firequestPostNeighboutVerificationDto: Any? = null

    @SerializedName("documents")
    @Expose
    private var documents: List<Any>? = null

    @SerializedName("firequestReviewSubmissionDto")
    @Expose
    private var firequestReviewSubmissionDto: Any? = null

    @SerializedName("firequestReferredSubmissionDto")
    @Expose
    private var firequestReferredSubmissionDto: Any? = null

    @SerializedName("firequestFinalSubmissionDto")
    @Expose
    private var firequestFinalSubmissionDto: Any? = null

    @SerializedName("firequestQualitySubmissionDto")
    @Expose
    private var firequestQualitySubmissionDto: Any? = null

    @SerializedName("fiRequestDto")
    @Expose
    private var fiRequestDto: Any? = null

    @SerializedName("firequestSelection")
    @Expose
    private var firequestSelection: Any? = null

    @SerializedName("firequestCoApplicantDetailDto")
    @Expose
    private var firequestCoApplicantDetailDto: List<Any>? = null

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
    private var fiactionReport: Any? = null

    @SerializedName("firequestAdditionalDetailDto")
    @Expose
    private var firequestAdditionalDetailDto: Any? = null

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getVerificationType(): String? {
        return verificationType
    }

    fun setVerificationType(verificationType: String?) {
        this.verificationType = verificationType
    }

    fun getFirequestBusinessVerification(): Any? {
        return firequestBusinessVerification
    }

    fun setFirequestBusinessVerification(firequestBusinessVerification: Any?) {
        this.firequestBusinessVerification = firequestBusinessVerification
    }

    fun getFirequestResidenceVerification(): SaveFirequestResidenceVerification? {
        return firequestResidenceVerification
    }

    fun setFirequestResidenceVerification(firequestResidenceVerification: SaveFirequestResidenceVerification?) {
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

    fun getFirequestDocumentProfileVerification(): SaveDocumentProfileVerification? {
        return firequestDocumentProfileVerification
    }

    fun setFirequestDocumentProfileVerification(firequestDocumentProfileVerification: SaveDocumentProfileVerification?) {
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

    fun getFirequestVerificationDocuments(): List<Any>? {
        return firequestVerificationDocuments
    }

    fun setFirequestVerificationDocuments(firequestVerificationDocuments: List<Any>?) {
        this.firequestVerificationDocuments = firequestVerificationDocuments
    }

    fun getAllocators(): Any? {
        return allocators
    }

    fun setAllocators(allocators: Any?) {
        this.allocators = allocators
    }

    fun getFirequestPreNeighboutVerificationDto(): Any? {
        return firequestPreNeighboutVerificationDto
    }

    fun setFirequestPreNeighboutVerificationDto(firequestPreNeighboutVerificationDto: Any?) {
        this.firequestPreNeighboutVerificationDto = firequestPreNeighboutVerificationDto
    }

    fun getFirequestPostNeighboutVerificationDto(): Any? {
        return firequestPostNeighboutVerificationDto
    }

    fun setFirequestPostNeighboutVerificationDto(firequestPostNeighboutVerificationDto: Any?) {
        this.firequestPostNeighboutVerificationDto = firequestPostNeighboutVerificationDto
    }

    fun getDocuments(): List<Any>? {
        return documents
    }

    fun setDocuments(documents: List<Any>?) {
        this.documents = documents
    }

    fun getFirequestReviewSubmissionDto(): Any? {
        return firequestReviewSubmissionDto
    }

    fun setFirequestReviewSubmissionDto(firequestReviewSubmissionDto: Any?) {
        this.firequestReviewSubmissionDto = firequestReviewSubmissionDto
    }

    fun getFirequestReferredSubmissionDto(): Any? {
        return firequestReferredSubmissionDto
    }

    fun setFirequestReferredSubmissionDto(firequestReferredSubmissionDto: Any?) {
        this.firequestReferredSubmissionDto = firequestReferredSubmissionDto
    }

    fun getFirequestFinalSubmissionDto(): Any? {
        return firequestFinalSubmissionDto
    }

    fun setFirequestFinalSubmissionDto(firequestFinalSubmissionDto: Any?) {
        this.firequestFinalSubmissionDto = firequestFinalSubmissionDto
    }

    fun getFirequestQualitySubmissionDto(): Any? {
        return firequestQualitySubmissionDto
    }

    fun setFirequestQualitySubmissionDto(firequestQualitySubmissionDto: Any?) {
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

    fun getFirequestCoApplicantDetailDto(): List<Any>? {
        return firequestCoApplicantDetailDto
    }

    fun setFirequestCoApplicantDetailDto(firequestCoApplicantDetailDto: List<Any>?) {
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

    fun getFiactionReport(): Any? {
        return fiactionReport
    }

    fun setFiactionReport(fiactionReport: Any?) {
        this.fiactionReport = fiactionReport
    }

    fun getFirequestAdditionalDetailDto(): Any? {
        return firequestAdditionalDetailDto
    }

    fun setFirequestAdditionalDetailDto(firequestAdditionalDetailDto: Any?) {
        this.firequestAdditionalDetailDto = firequestAdditionalDetailDto
    }
}