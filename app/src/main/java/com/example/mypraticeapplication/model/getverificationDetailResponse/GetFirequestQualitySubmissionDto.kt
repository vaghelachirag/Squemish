package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetFirequestQualitySubmissionDto {

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("fistatus")
    @Expose
    private var fistatus: Int? = null

    @SerializedName("qualityRemarks")
    @Expose
    private var qualityRemarks: Any? = null

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

    fun getQualityRemarks(): Any? {
        return qualityRemarks
    }

    fun setQualityRemarks(qualityRemarks: Any?) {
        this.qualityRemarks = qualityRemarks
    }

}