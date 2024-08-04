package com.example.mypraticeapplication.model.getverificationDetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetFiRequestPreNeighboutVerificationDto {

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("neighbour1Name")
    @Expose
    private var neighbour1Name: String = ""

    @SerializedName("neighbour2Name")
    @Expose
    private var neighbour2Name: String? = null

    @SerializedName("neighbour1Mobile")
    @Expose
    private var neighbour1Mobile: String? = null

    @SerializedName("neighbour2Mobile")
    @Expose
    private var neighbour2Mobile: String? = null

    @SerializedName("neighbour1Remark")
    @Expose
    private var neighbour1Remark: String? = null

    @SerializedName("neighbour2Remark")
    @Expose
    private var neighbour2Remark: String? = null

    @SerializedName("isNeighbourRecognised")
    @Expose
    private var isNeighbourRecognised: String? = null

    @SerializedName("reason")
    @Expose
    private var reason: Any? = null

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getNeighbour1Name(): String? {
        return neighbour1Name
    }

    fun setNeighbour1Name(neighbour1Name: String) {
        this.neighbour1Name = neighbour1Name
    }

    fun getNeighbour2Name(): String? {
        return neighbour2Name
    }

    fun setNeighbour2Name(neighbour2Name: String?) {
        this.neighbour2Name = neighbour2Name
    }


    fun getNeighbour2Mobile(): String? {
        return neighbour2Mobile
    }

    fun getNeighbour1Mobile(): String? {
        return neighbour1Mobile
    }


    fun setNeighbour2Mobile(neighbour2Mobile: String?) {
        this.neighbour2Mobile = neighbour2Mobile
    }

    fun setNeighbour1Mobile(neighbour1Mobile: String?) {
        this.neighbour1Mobile = neighbour1Mobile
    }


    fun getNeighbour1Remark(): String? {
        return neighbour1Remark
    }

    fun setNeighbour1Remark(neighbour1Remark: String?) {
        this.neighbour1Remark = neighbour1Remark
    }

    fun getNeighbour2Remark(): String? {
        return neighbour2Remark
    }

    fun setNeighbour2Remark(neighbour2Remark: String?) {
        this.neighbour2Remark = neighbour2Remark
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