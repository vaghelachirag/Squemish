package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetFirequestReviewSubmissionDto {

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("fistatus")
    @Expose
    private var fistatus: Int? = null

    @SerializedName("rejectReason")
    @Expose
    private var rejectReason: Any? = null

    @SerializedName("reviewRemarks")
    @Expose
    private var reviewRemarks: Any? = null

    @SerializedName("referReason")
    @Expose
    private var referReason: Any? = null

    @SerializedName("uniqueRefNo")
    @Expose
    private var uniqueRefNo: Any? = null

    @SerializedName("bankName")
    @Expose
    private var bankName: Any? = null

    @SerializedName("assessmentYear")
    @Expose
    private var assessmentYear: Any? = null

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getFistatus(): Int? {
        return fistatus
    }

    fun setFistatus(fistatus: Int?) {
        this.fistatus = fistatus
    }

    fun getRejectReason(): Any? {
        return rejectReason
    }

    fun setRejectReason(rejectReason: Any?) {
        this.rejectReason = rejectReason
    }

    fun getReviewRemarks(): Any? {
        return reviewRemarks
    }

    fun setReviewRemarks(reviewRemarks: Any?) {
        this.reviewRemarks = reviewRemarks
    }

    fun getReferReason(): Any? {
        return referReason
    }

    fun setReferReason(referReason: Any?) {
        this.referReason = referReason
    }

    fun getUniqueRefNo(): Any? {
        return uniqueRefNo
    }

    fun setUniqueRefNo(uniqueRefNo: Any?) {
        this.uniqueRefNo = uniqueRefNo
    }

    fun getBankName(): Any? {
        return bankName
    }

    fun setBankName(bankName: Any?) {
        this.bankName = bankName
    }

    fun getAssessmentYear(): Any? {
        return assessmentYear
    }

    fun setAssessmentYear(assessmentYear: Any?) {
        this.assessmentYear = assessmentYear
    }
}