package com.example.mypraticeapplication.model.finalSubmission

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class SaveFinalSubmissionData {
    @SerializedName("FIRequestId")
    @Expose
    private var fIRequestId: Int? = null

    @SerializedName("FIStatus")
    @Expose
    private var fIStatus: String? = null

    @SerializedName("Remarks")
    @Expose
    private var remarks: String? = null

    fun getFIRequestId(): Int? {
        return fIRequestId
    }

    fun setFIRequestId(fIRequestId: Int?) {
        this.fIRequestId = fIRequestId
    }

    fun getFIStatus(): String? {
        return fIStatus
    }

    fun setFIStatus(fIStatus: String?) {
        this.fIStatus = fIStatus
    }

    fun getRemarks(): String? {
        return remarks
    }

    fun setRemarks(remarks: String?) {
        this.remarks = remarks
    }


}