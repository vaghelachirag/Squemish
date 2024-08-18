package com.example.mypraticeapplication.model.getFiResidencePicture

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class GetFiResidencePictureData {


    @SerializedName("documentId")
    @Expose
    private var documentId: Int? = null

    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("documentPath")
    @Expose
    private var documentPath: String? = null

    @SerializedName("documentFileName")
    @Expose
    private var documentFileName: String? = null

    @SerializedName("documentFileSize")
    @Expose
    private var documentFileSize: Int? = null

    @SerializedName("documentExtension")
    @Expose
    private var documentExtension: String? = null

    fun getDocumentId(): Int? {
        return documentId
    }

    fun setDocumentId(documentId: Int?) {
        this.documentId = documentId
    }

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getDocumentPath(): String? {
        return documentPath
    }

    fun setDocumentPath(documentPath: String?) {
        this.documentPath = documentPath
    }

    fun getDocumentFileName(): String? {
        return documentFileName
    }

    fun setDocumentFileName(documentFileName: String?) {
        this.documentFileName = documentFileName
    }

    fun getDocumentFileSize(): Int? {
        return documentFileSize
    }

    fun setDocumentFileSize(documentFileSize: Int?) {
        this.documentFileSize = documentFileSize
    }

    fun getDocumentExtension(): String? {
        return documentExtension
    }

    fun setDocumentExtension(documentExtension: String?) {
        this.documentExtension = documentExtension
    }

}