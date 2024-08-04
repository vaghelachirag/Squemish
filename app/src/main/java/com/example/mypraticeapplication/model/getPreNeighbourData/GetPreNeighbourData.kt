package com.example.mypraticeapplication.model.getPreNeighbourData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetPreNeighbourData {
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