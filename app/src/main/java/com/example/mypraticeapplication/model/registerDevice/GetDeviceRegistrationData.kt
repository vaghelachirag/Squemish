package com.example.mypraticeapplication.model.registerDevice

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetDeviceRegistrationData {

    @SerializedName("id")
    @Expose
    private var id: Int? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

}