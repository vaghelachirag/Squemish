package com.example.mypraticeapplication.model.getUserProfileData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class GetUserProfileData {

    @SerializedName("userId")
    @Expose
    private var userId: Int? = null

    @SerializedName("businessId")
    @Expose
    private var businessId: Int? = null

    @SerializedName("userName")
    @Expose
    private var userName: String? = null

    @SerializedName("userAddress")
    @Expose
    private var userAddress: String? = null

    @SerializedName("userCity")
    @Expose
    private var userCity: String? = null

    @SerializedName("userState")
    @Expose
    private var userState: String? = null

    @SerializedName("userPIN")
    @Expose
    private var userPIN: String? = null

    @SerializedName("userMobileNo")
    @Expose
    private var userMobileNo: String? = null

    @SerializedName("userEmail")
    @Expose
    private var userEmail: String? = null

    @SerializedName("userPassword")
    @Expose
    private var userPassword: String? = null

    @SerializedName("userType")
    @Expose
    private var userType: String? = null

    @SerializedName("profilePicture")
    @Expose
    private var profilePicture: String? = null

    @SerializedName("isActive")
    @Expose
    private var isActive: Boolean? = null

    @SerializedName("userSignature")
    @Expose
    private var userSignature: String? = null

    @SerializedName("employeeId")
    @Expose
    private var employeeId: Int? = null

    @SerializedName("leadId")
    @Expose
    private var leadId: Any? = null

    @SerializedName("lastPasswordChangeDate")
    @Expose
    private var lastPasswordChangeDate: String? = null

    fun getUserId(): Int? {
        return userId
    }

    fun setUserId(userId: Int?) {
        this.userId = userId
    }

    fun getBusinessId(): Int? {
        return businessId
    }

    fun setBusinessId(businessId: Int?) {
        this.businessId = businessId
    }

    fun getUserName(): String? {
        return userName
    }

    fun setUserName(userName: String?) {
        this.userName = userName
    }

    fun getUserAddress(): String? {
        return userAddress
    }

    fun setUserAddress(userAddress: String?) {
        this.userAddress = userAddress
    }

    fun getUserCity(): String? {
        return userCity
    }

    fun setUserCity(userCity: String?) {
        this.userCity = userCity
    }

    fun getUserState(): String? {
        return userState
    }

    fun setUserState(userState: String?) {
        this.userState = userState
    }

    fun getUserPIN(): String? {
        return userPIN
    }

    fun setUserPIN(userPIN: String?) {
        this.userPIN = userPIN
    }

    fun getUserMobileNo(): String? {
        return userMobileNo
    }

    fun setUserMobileNo(userMobileNo: String?) {
        this.userMobileNo = userMobileNo
    }

    fun getUserEmail(): String? {
        return userEmail
    }

    fun setUserEmail(userEmail: String?) {
        this.userEmail = userEmail
    }

    fun getUserPassword(): String? {
        return userPassword
    }

    fun setUserPassword(userPassword: String?) {
        this.userPassword = userPassword
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

    fun getIsActive(): Boolean? {
        return isActive
    }

    fun setIsActive(isActive: Boolean?) {
        this.isActive = isActive
    }

    fun getUserSignature(): String? {
        return userSignature
    }

    fun setUserSignature(userSignature: String?) {
        this.userSignature = userSignature
    }

    fun getEmployeeId(): Int? {
        return employeeId
    }

    fun setEmployeeId(employeeId: Int?) {
        this.employeeId = employeeId
    }

    fun getLeadId(): Any? {
        return leadId
    }

    fun setLeadId(leadId: Any?) {
        this.leadId = leadId
    }

    fun getLastPasswordChangeDate(): String? {
        return lastPasswordChangeDate
    }

    fun setLastPasswordChangeDate(lastPasswordChangeDate: String?) {
        this.lastPasswordChangeDate = lastPasswordChangeDate
    }

}