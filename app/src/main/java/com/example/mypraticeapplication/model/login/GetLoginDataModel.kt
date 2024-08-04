package com.example.mypraticeapplication.model.login

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class GetLoginDataModel {

    @SerializedName("userId")
    @Expose
    private var userId: Int? = null

    @SerializedName("userLogId")
    @Expose
    private var userLogId: Int? = null

    @SerializedName("emailAddress")
    @Expose
    private var emailAddress: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("userType")
    @Expose
    private var userType: String? = null

    @SerializedName("profilePicture")
    @Expose
    private var profilePicture: String? = null

    @SerializedName("token")
    @Expose
    private var token: String? = null

    @SerializedName("firebaseToken")
    @Expose
    private var firebaseToken: String? = null

    @SerializedName("lastPasswordChangeDate")
    @Expose
    private var lastPasswordChangeDate: String? = null

    @SerializedName("isPasswordChangeRequired")
    @Expose
    private var isPasswordChangeRequired: Boolean? = null

    fun getUserId(): Int? {
        return userId
    }

    fun setUserId(userId: Int?) {
        this.userId = userId
    }

    fun getUserLogId(): Int? {
        return userLogId
    }

    fun setUserLogId(userLogId: Int?) {
        this.userLogId = userLogId
    }

    fun getEmailAddress(): String? {
        return emailAddress
    }

    fun setEmailAddress(emailAddress: String?) {
        this.emailAddress = emailAddress
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getUserType(): String? {
        return userType
    }

    fun setUserType(userType: String?) {
        this.userType = userType
    }

    fun getProfilePicture(): String? {
        return profilePicture
    }

    fun setProfilePicture(profilePicture: String?) {
        this.profilePicture = profilePicture
    }

    fun getToken(): String? {
        return token
    }

    fun setToken(token: String?) {
        this.token = token
    }

    fun getFirebaseToken(): String? {
        return firebaseToken
    }

    fun setFirebaseToken(firebaseToken: String?) {
        this.firebaseToken = firebaseToken
    }

    fun getLastPasswordChangeDate(): String? {
        return lastPasswordChangeDate
    }

    fun setLastPasswordChangeDate(lastPasswordChangeDate: String?) {
        this.lastPasswordChangeDate = lastPasswordChangeDate
    }

    fun getIsPasswordChangeRequired(): Boolean? {
        return isPasswordChangeRequired
    }

    fun setIsPasswordChangeRequired(isPasswordChangeRequired: Boolean?) {
        this.isPasswordChangeRequired = isPasswordChangeRequired
    }

}