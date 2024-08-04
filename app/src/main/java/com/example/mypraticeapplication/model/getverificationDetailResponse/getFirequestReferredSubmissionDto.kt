package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class getFirequestReferredSubmissionDto {

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("referredRemarks")
    @Expose
    private var referredRemarks: Any? = null

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getReferredRemarks(): Any? {
        return referredRemarks
    }

    fun setReferredRemarks(referredRemarks: Any?) {
        this.referredRemarks = referredRemarks
    }

}