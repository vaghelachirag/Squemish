package com.example.mypraticeapplication.model.getMenuWebUrlResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetMenuURLData {

    @SerializedName("url")
    @Expose
    private var url: String? = null

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }
}