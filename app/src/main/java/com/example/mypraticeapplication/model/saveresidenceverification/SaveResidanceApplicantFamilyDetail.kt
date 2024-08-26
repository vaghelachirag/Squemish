package com.example.mypraticeapplication.model.saveresidenceverification

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class SaveResidanceApplicantFamilyDetail {


    @SerializedName("recordId")
    @Expose
    private var recordId: Int? = null

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("relation")
    @Expose
    internal var relation: String? = null

    @SerializedName("memberCount")
    @Expose
    internal var memberCount: Int? = null

    @SerializedName("earningMemberCount")
    @Expose
    internal var earningMemberCount: Int? = null

    fun getRecordId(): Int? {
        return recordId
    }

    fun setRecordId(recordId: Int?) {
        this.recordId = recordId
    }

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getRelation(): String? {
        return relation
    }

    fun setRelation(relation: String?) {
        this.relation = relation
    }

    fun getMemberCount(): Int? {
        return memberCount
    }

    fun setMemberCount(memberCount: Int?) {
        this.memberCount = memberCount
    }

    fun getEarningMemberCount(): Int? {
        return earningMemberCount
    }

    fun setEarningMemberCount(earningMemberCount: Int?) {
        this.earningMemberCount = earningMemberCount
    }

    var isStaticData: Boolean? = false
}