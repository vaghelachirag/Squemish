package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetFiactionReport {

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("fistatus")
    @Expose
    private var fistatus: Int? = null

    @SerializedName("createdAt")
    @Expose
    private var createdAt: String? = null

    @SerializedName("createdBy")
    @Expose
    private var createdBy: Int? = null

    @SerializedName("assignedAt")
    @Expose
    private var assignedAt: String? = null

    @SerializedName("assignedBy")
    @Expose
    private var assignedBy: Int? = null

    @SerializedName("assignedTo")
    @Expose
    private var assignedTo: Int? = null

    @SerializedName("verifiedAt")
    @Expose
    private var verifiedAt: Any? = null

    @SerializedName("verifiedBy")
    @Expose
    private var verifiedBy: Any? = null

    @SerializedName("acceptedAt")
    @Expose
    private var acceptedAt: Any? = null

    @SerializedName("acceptedBy")
    @Expose
    private var acceptedBy: Any? = null

    @SerializedName("closedAt")
    @Expose
    private var closedAt: Any? = null

    @SerializedName("closedBy")
    @Expose
    private var closedBy: Any? = null

    @SerializedName("rejectedAt")
    @Expose
    private var rejectedAt: Any? = null

    @SerializedName("rejectedBy")
    @Expose
    private var rejectedBy: Any? = null

    @SerializedName("draftedAt")
    @Expose
    private var draftedAt: String? = null

    @SerializedName("draftedBy")
    @Expose
    private var draftedBy: Int? = null

    @SerializedName("qtyAcceptedAt")
    @Expose
    private var qtyAcceptedAt: Any? = null

    @SerializedName("qtyAcceptedBy")
    @Expose
    private var qtyAcceptedBy: Any? = null

    @SerializedName("qtyDeclinedAt")
    @Expose
    private var qtyDeclinedAt: Any? = null

    @SerializedName("qtyDeclinedBy")
    @Expose
    private var qtyDeclinedBy: Any? = null

    @SerializedName("rejectReason")
    @Expose
    private var rejectReason: Any? = null

    @SerializedName("feacceptedBy")
    @Expose
    private var feacceptedBy: Int? = null

    @SerializedName("feacceptedAt")
    @Expose
    private var feacceptedAt: String? = null

    @SerializedName("ferejectedBy")
    @Expose
    private var ferejectedBy: Any? = null

    @SerializedName("ferejectedAt")
    @Expose
    private var ferejectedAt: Any? = null

    @SerializedName("ferejectedReason")
    @Expose
    private var ferejectedReason: Any? = null

    @SerializedName("feacceptReason")
    @Expose
    private var feacceptReason: String? = null

    @SerializedName("referredAt")
    @Expose
    private var referredAt: Any? = null

    @SerializedName("referredBy")
    @Expose
    private var referredBy: Any? = null

    @SerializedName("referredRemark")
    @Expose
    private var referredRemark: Any? = null

    @SerializedName("verifiedStatus")
    @Expose
    private var verifiedStatus: Any? = null

    @SerializedName("verifiedRemarks")
    @Expose
    private var verifiedRemarks: Any? = null

    @SerializedName("reviewRemarks")
    @Expose
    private var reviewRemarks: Any? = null

    @SerializedName("qualityRemarks")
    @Expose
    private var qualityRemarks: Any? = null

    @SerializedName("acceptRemarks")
    @Expose
    private var acceptRemarks: Any? = null

    @SerializedName("closureRemarks")
    @Expose
    private var closureRemarks: Any? = null

    @SerializedName("referredAcceptRemarks")
    @Expose
    private var referredAcceptRemarks: Any? = null

    @SerializedName("verifiedByNavigation")
    @Expose
    private var verifiedByNavigation: Any? = null

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

    fun getCreatedAt(): String? {
        return createdAt
    }

    fun setCreatedAt(createdAt: String?) {
        this.createdAt = createdAt
    }

    fun getCreatedBy(): Int? {
        return createdBy
    }

    fun setCreatedBy(createdBy: Int?) {
        this.createdBy = createdBy
    }

    fun getAssignedAt(): String? {
        return assignedAt
    }

    fun setAssignedAt(assignedAt: String?) {
        this.assignedAt = assignedAt
    }

    fun getAssignedBy(): Int? {
        return assignedBy
    }

    fun setAssignedBy(assignedBy: Int?) {
        this.assignedBy = assignedBy
    }

    fun getAssignedTo(): Int? {
        return assignedTo
    }

    fun setAssignedTo(assignedTo: Int?) {
        this.assignedTo = assignedTo
    }

    fun getVerifiedAt(): Any? {
        return verifiedAt
    }

    fun setVerifiedAt(verifiedAt: Any?) {
        this.verifiedAt = verifiedAt
    }

    fun getVerifiedBy(): Any? {
        return verifiedBy
    }

    fun setVerifiedBy(verifiedBy: Any?) {
        this.verifiedBy = verifiedBy
    }

    fun getAcceptedAt(): Any? {
        return acceptedAt
    }

    fun setAcceptedAt(acceptedAt: Any?) {
        this.acceptedAt = acceptedAt
    }

    fun getAcceptedBy(): Any? {
        return acceptedBy
    }

    fun setAcceptedBy(acceptedBy: Any?) {
        this.acceptedBy = acceptedBy
    }

    fun getClosedAt(): Any? {
        return closedAt
    }

    fun setClosedAt(closedAt: Any?) {
        this.closedAt = closedAt
    }

    fun getClosedBy(): Any? {
        return closedBy
    }

    fun setClosedBy(closedBy: Any?) {
        this.closedBy = closedBy
    }

    fun getRejectedAt(): Any? {
        return rejectedAt
    }

    fun setRejectedAt(rejectedAt: Any?) {
        this.rejectedAt = rejectedAt
    }

    fun getRejectedBy(): Any? {
        return rejectedBy
    }

    fun setRejectedBy(rejectedBy: Any?) {
        this.rejectedBy = rejectedBy
    }

    fun getDraftedAt(): String? {
        return draftedAt
    }

    fun setDraftedAt(draftedAt: String?) {
        this.draftedAt = draftedAt
    }

    fun getDraftedBy(): Int? {
        return draftedBy
    }

    fun setDraftedBy(draftedBy: Int?) {
        this.draftedBy = draftedBy
    }

    fun getQtyAcceptedAt(): Any? {
        return qtyAcceptedAt
    }

    fun setQtyAcceptedAt(qtyAcceptedAt: Any?) {
        this.qtyAcceptedAt = qtyAcceptedAt
    }

    fun getQtyAcceptedBy(): Any? {
        return qtyAcceptedBy
    }

    fun setQtyAcceptedBy(qtyAcceptedBy: Any?) {
        this.qtyAcceptedBy = qtyAcceptedBy
    }

    fun getQtyDeclinedAt(): Any? {
        return qtyDeclinedAt
    }

    fun setQtyDeclinedAt(qtyDeclinedAt: Any?) {
        this.qtyDeclinedAt = qtyDeclinedAt
    }

    fun getQtyDeclinedBy(): Any? {
        return qtyDeclinedBy
    }

    fun setQtyDeclinedBy(qtyDeclinedBy: Any?) {
        this.qtyDeclinedBy = qtyDeclinedBy
    }

    fun getRejectReason(): Any? {
        return rejectReason
    }

    fun setRejectReason(rejectReason: Any?) {
        this.rejectReason = rejectReason
    }

    fun getFeacceptedBy(): Int? {
        return feacceptedBy
    }

    fun setFeacceptedBy(feacceptedBy: Int?) {
        this.feacceptedBy = feacceptedBy
    }

    fun getFeacceptedAt(): String? {
        return feacceptedAt
    }

    fun setFeacceptedAt(feacceptedAt: String?) {
        this.feacceptedAt = feacceptedAt
    }

    fun getFerejectedBy(): Any? {
        return ferejectedBy
    }

    fun setFerejectedBy(ferejectedBy: Any?) {
        this.ferejectedBy = ferejectedBy
    }

    fun getFerejectedAt(): Any? {
        return ferejectedAt
    }

    fun setFerejectedAt(ferejectedAt: Any?) {
        this.ferejectedAt = ferejectedAt
    }

    fun getFerejectedReason(): Any? {
        return ferejectedReason
    }

    fun setFerejectedReason(ferejectedReason: Any?) {
        this.ferejectedReason = ferejectedReason
    }

    fun getFeacceptReason(): String? {
        return feacceptReason
    }

    fun setFeacceptReason(feacceptReason: String?) {
        this.feacceptReason = feacceptReason
    }

    fun getReferredAt(): Any? {
        return referredAt
    }

    fun setReferredAt(referredAt: Any?) {
        this.referredAt = referredAt
    }

    fun getReferredBy(): Any? {
        return referredBy
    }

    fun setReferredBy(referredBy: Any?) {
        this.referredBy = referredBy
    }

    fun getReferredRemark(): Any? {
        return referredRemark
    }

    fun setReferredRemark(referredRemark: Any?) {
        this.referredRemark = referredRemark
    }

    fun getVerifiedStatus(): Any? {
        return verifiedStatus
    }

    fun setVerifiedStatus(verifiedStatus: Any?) {
        this.verifiedStatus = verifiedStatus
    }

    fun getVerifiedRemarks(): Any? {
        return verifiedRemarks
    }

    fun setVerifiedRemarks(verifiedRemarks: Any?) {
        this.verifiedRemarks = verifiedRemarks
    }

    fun getReviewRemarks(): Any? {
        return reviewRemarks
    }

    fun setReviewRemarks(reviewRemarks: Any?) {
        this.reviewRemarks = reviewRemarks
    }

    fun getQualityRemarks(): Any? {
        return qualityRemarks
    }

    fun setQualityRemarks(qualityRemarks: Any?) {
        this.qualityRemarks = qualityRemarks
    }

    fun getAcceptRemarks(): Any? {
        return acceptRemarks
    }

    fun setAcceptRemarks(acceptRemarks: Any?) {
        this.acceptRemarks = acceptRemarks
    }

    fun getClosureRemarks(): Any? {
        return closureRemarks
    }

    fun setClosureRemarks(closureRemarks: Any?) {
        this.closureRemarks = closureRemarks
    }

    fun getReferredAcceptRemarks(): Any? {
        return referredAcceptRemarks
    }

    fun setReferredAcceptRemarks(referredAcceptRemarks: Any?) {
        this.referredAcceptRemarks = referredAcceptRemarks
    }

    fun getVerifiedByNavigation(): Any? {
        return verifiedByNavigation
    }

    fun setVerifiedByNavigation(verifiedByNavigation: Any?) {
        this.verifiedByNavigation = verifiedByNavigation
    }
}