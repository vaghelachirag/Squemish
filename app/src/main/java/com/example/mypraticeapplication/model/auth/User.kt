package com.example.mypraticeapplication.model.auth

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User : Serializable {
    @SerializedName("UserId")
    var userId: String? = null

    @SerializedName("FirstName")
    var firstName: String? = null

    @SerializedName("MiddleName")
    var middleName: String? = null

    @SerializedName("Surname")
    var surname: String? = null

    @SerializedName("EmailAddress")
    var emailAddress: String? = null

    @SerializedName("Password")
    var password: String? = null


    @SerializedName("MobileNo")
    var mobileNo: String? = null


    @SerializedName("IsActive")
    var isActive: String? = null

    @SerializedName("CreatedBy")
    var createdBy: String? = null

    @SerializedName("Error")
    var error: String? = null

    @SerializedName("JWTToken")
    var jWTToken: String? = null
}