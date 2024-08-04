package com.example.mypraticeapplication.model.getmasterData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mypraticeapplication.room.DbConfig
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = DbConfig.MASTER_DATA_TABLE)
class GetMasterApiData {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @ColumnInfo(name = "SrNo")
    @SerializedName("srNo")
    @Expose
    private var srNo: Int? = null

    @ColumnInfo(name = "KeyName")
    @SerializedName("keyName")
    @Expose
    private var keyName: String? = null

    @ColumnInfo(name = "DisplayText")
    @SerializedName("displayText")
    @Expose
    private var displayText: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getSrNo(): Int? {
        return srNo
    }

    fun setSrNo(srNo: Int?) {
        this.srNo = srNo
    }

    fun getKeyName(): String? {
        return keyName
    }

    fun setKeyName(keyName: String?) {
        this.keyName = keyName
    }

    fun getDisplayText(): String? {
        return displayText
    }

    fun setDisplayText(displayText: String?) {
        this.displayText = displayText
    }

}