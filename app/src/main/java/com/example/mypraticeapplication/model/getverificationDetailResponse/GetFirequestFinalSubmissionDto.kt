package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetFirequestFinalSubmissionDto {

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("fistatus")
    @Expose
    private var fistatus: Any? = null

    @SerializedName("remarks")
    @Expose
    private var remarks: Any? = null

    @SerializedName("reportRemarks")
    @Expose
    private var reportRemarks: Any? = null

    @SerializedName("qualityRemarks")
    @Expose
    private var qualityRemarks: Any? = null

    @SerializedName("closureRemarks")
    @Expose
    private var closureRemarks: Any? = null

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getFistatus(): Any? {
        return fistatus
    }

    fun setFistatus(fistatus: Any?) {
        this.fistatus = fistatus
    }

    fun getRemarks(): Any? {
        return remarks
    }

    fun setRemarks(remarks: Any?) {
        this.remarks = remarks
    }

    fun getReportRemarks(): Any? {
        return reportRemarks
    }

    fun setReportRemarks(reportRemarks: Any?) {
        this.reportRemarks = reportRemarks
    }

    fun getQualityRemarks(): Any? {
        return qualityRemarks
    }

    fun setQualityRemarks(qualityRemarks: Any?) {
        this.qualityRemarks = qualityRemarks
    }

    fun getClosureRemarks(): Any? {
        return closureRemarks
    }

    fun setClosureRemarks(closureRemarks: Any?) {
        this.closureRemarks = closureRemarks
    }

}