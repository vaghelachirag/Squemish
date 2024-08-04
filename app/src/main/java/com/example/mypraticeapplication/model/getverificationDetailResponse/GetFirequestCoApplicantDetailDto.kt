package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetFirequestCoApplicantDetailDto {
    @SerializedName("coApplicantId")
    @Expose
    private var coApplicantId: Int? = null

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("coApplicantName")
    @Expose
    private var coApplicantName: String? = null

    @SerializedName("mobileNo")
    @Expose
    private var mobileNo: Any? = null

    @SerializedName("relation")
    @Expose
    private var relation: Any? = null

    @SerializedName("applicantType")
    @Expose
    private var applicantType: String? = null

    @SerializedName("verificationRemarks")
    @Expose
    private var verificationRemarks: Any? = null

    fun getCoApplicantId(): Int? {
        return coApplicantId
    }

    fun setCoApplicantId(coApplicantId: Int?) {
        this.coApplicantId = coApplicantId
    }

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getCoApplicantName(): String? {
        return coApplicantName
    }

    fun setCoApplicantName(coApplicantName: String?) {
        this.coApplicantName = coApplicantName
    }

    fun getMobileNo(): Any? {
        return mobileNo
    }

    fun setMobileNo(mobileNo: Any?) {
        this.mobileNo = mobileNo
    }

    fun getRelation(): Any? {
        return relation
    }

    fun setRelation(relation: Any?) {
        this.relation = relation
    }

    fun getApplicantType(): String? {
        return applicantType
    }

    fun setApplicantType(applicantType: String?) {
        this.applicantType = applicantType
    }

    fun getVerificationRemarks(): Any? {
        return verificationRemarks
    }

    fun setVerificationRemarks(verificationRemarks: Any?) {
        this.verificationRemarks = verificationRemarks
    }

}