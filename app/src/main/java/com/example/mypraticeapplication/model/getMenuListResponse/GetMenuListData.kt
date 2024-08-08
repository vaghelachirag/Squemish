package com.example.mypraticeapplication.model.getMenuListResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetMenuListData {

    @SerializedName("menuId")
    @Expose
    private var menuId: Int? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("orderNo")
    @Expose
    private var orderNo: Int? = null

    @SerializedName("parentId")
    @Expose
    private var parentId: Int? = null

    @SerializedName("isWebView")
    @Expose
    private var isWebView: Boolean? = null

    @SerializedName("icon")
    @Expose
    private var icon: String? = null

    @SerializedName("isSpecial")
    @Expose
    private var isSpecial: Boolean? = null

    fun getMenuId(): Int? {
        return menuId
    }

    fun setMenuId(menuId: Int?) {
        this.menuId = menuId
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getOrderNo(): Int? {
        return orderNo
    }

    fun setOrderNo(orderNo: Int?) {
        this.orderNo = orderNo
    }

    fun getParentId(): Int? {
        return parentId
    }

    fun setParentId(parentId: Int?) {
        this.parentId = parentId
    }

    fun getIsWebView(): Boolean? {
        return isWebView
    }

    fun setIsWebView(isWebView: Boolean?) {
        this.isWebView = isWebView
    }

    fun getIcon(): String? {
        return icon
    }

    fun setIcon(icon: String?) {
        this.icon = icon
    }

    fun getIsSpecial(): Boolean? {
        return isSpecial
    }

    fun setIsSpecial(isSpecial: Boolean?) {
        this.isSpecial = isSpecial
    }

}