package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class GetFirequestPostNeighboutVerificationDto {


    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("neighbour3Name")
    @Expose
    private var neighbour3Name: Any? = null

    @SerializedName("neighbour4Name")
    @Expose
    private var neighbour4Name: Any? = null

    @SerializedName("neighbour3Mobile")
    @Expose
    private var neighbour3Mobile: Any? = null

    @SerializedName("neighbour4Mobile")
    @Expose
    private var neighbour4Mobile: Any? = null

    @SerializedName("neighbour3Remark")
    @Expose
    private var neighbour3Remark: Any? = null

    @SerializedName("neighbour4Remark")
    @Expose
    private var neighbour4Remark: Any? = null

    @SerializedName("isNeighbourRecognised")
    @Expose
    private var isNeighbourRecognised: String? = ""

    @SerializedName("reason")
    @Expose
    private var reason: Any? = null

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getNeighbour3Name(): Any? {
        return neighbour3Name
    }

    fun setNeighbour3Name(neighbour3Name: Any?) {
        this.neighbour3Name = neighbour3Name
    }

    fun getNeighbour4Name(): Any? {
        return neighbour4Name
    }

    fun setNeighbour4Name(neighbour4Name: Any?) {
        this.neighbour4Name = neighbour4Name
    }

    fun getNeighbour3Mobile(): Any? {
        return neighbour3Mobile
    }

    fun setNeighbour3Mobile(neighbour3Mobile: Any?) {
        this.neighbour3Mobile = neighbour3Mobile
    }

    fun getNeighbour4Mobile(): Any? {
        return neighbour4Mobile
    }

    fun setNeighbour4Mobile(neighbour4Mobile: Any?) {
        this.neighbour4Mobile = neighbour4Mobile
    }

    fun getNeighbour3Remark(): Any? {
        return neighbour3Remark
    }

    fun setNeighbour3Remark(neighbour3Remark: Any?) {
        this.neighbour3Remark = neighbour3Remark
    }

    fun getNeighbour4Remark(): Any? {
        return neighbour4Remark
    }

    fun setNeighbour4Remark(neighbour4Remark: Any?) {
        this.neighbour4Remark = neighbour4Remark
    }

    fun getIsNeighbourRecognised(): String? {
        return isNeighbourRecognised
    }

    fun setIsNeighbourRecognised(isNeighbourRecognised: String?) {
        this.isNeighbourRecognised = isNeighbourRecognised
    }

    fun getReason(): Any? {
        return reason
    }

    fun setReason(reason: Any?) {
        this.reason = reason
    }

}