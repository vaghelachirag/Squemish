package com.example.mypraticeapplication.model.getmasterData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetMasterApiResponse {
    @SerializedName("status_Code")
    @Expose
    private var statusCode: Int? = null

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("message")
    @Expose
    private var message: Any? = null

    @SerializedName("returnUrl")
    @Expose
    private var returnUrl: Any? = null

    @SerializedName("data")
    @Expose
    private var data: List<GetMasterApiData>? = null

    @SerializedName("textData")
    @Expose
    private var textData: Any? = null

    fun getStatusCode(): Int? {
        return statusCode
    }

    fun setStatusCode(statusCode: Int?) {
        this.statusCode = statusCode
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getMessage(): Any? {
        return message
    }

    fun setMessage(message: Any?) {
        this.message = message
    }

    fun getReturnUrl(): Any? {
        return returnUrl
    }

    fun setReturnUrl(returnUrl: Any?) {
        this.returnUrl = returnUrl
    }

    fun getData(): List<GetMasterApiData>? {
        return data
    }

    fun setData(data: List<GetMasterApiData>?) {
        this.data = data
    }

    fun getTextData(): Any? {
        return textData
    }

    fun setTextData(textData: Any?) {
        this.textData = textData
    }

}