package com.example.mypraticeapplication.model.saveDocumentProfileVerification

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SaveDocumentProfileVerification {
    @SerializedName("firequestId")
    @Expose
    private var firequestId: Int? = null

    @SerializedName("visitDate")
    @Expose
    private var visitDate: String? = null

    @SerializedName("addressConfirmed")
    @Expose
    private var addressConfirmed: Boolean? = null

    @SerializedName("reason")
    @Expose
    private var reason: Any? = null

    @SerializedName("personMet")
    @Expose
    private var personMet: Any? = null

    @SerializedName("personMetDesignation")
    @Expose
    private var personMetDesignation: Any? = null

    @SerializedName("isDocumentSigned")
    @Expose
    private var isDocumentSigned: Any? = null

    @SerializedName("authorisedPersonName")
    @Expose
    private var authorisedPersonName: Any? = null

    @SerializedName("authorisedPersonDesignation")
    @Expose
    private var authorisedPersonDesignation: Any? = null

    @SerializedName("isMetAuthorisedPerson")
    @Expose
    private var isMetAuthorisedPerson: Any? = null

    @SerializedName("isProofShown")
    @Expose
    private var isProofShown: Any? = null

    @SerializedName("documentName")
    @Expose
    private var documentName: Any? = null

    @SerializedName("otherObservations")
    @Expose
    private var otherObservations: Any? = null

    @SerializedName("longitude")
    @Expose
    private var longitude: Any? = null

    @SerializedName("latitude")
    @Expose
    private var latitude: Any? = null

    @SerializedName("isOfficeOpen")
    @Expose
    private var isOfficeOpen: Any? = null

    fun getFirequestId(): Int? {
        return firequestId
    }

    fun setFirequestId(firequestId: Int?) {
        this.firequestId = firequestId
    }

    fun getVisitDate(): String? {
        return visitDate
    }

    fun setVisitDate(visitDate: String?) {
        this.visitDate = visitDate
    }

    fun getAddressConfirmed(): Boolean? {
        return addressConfirmed
    }

    fun setAddressConfirmed(addressConfirmed: Boolean?) {
        this.addressConfirmed = addressConfirmed
    }

    fun getReason(): Any? {
        return reason
    }

    fun setReason(reason: Any?) {
        this.reason = reason
    }

    fun getPersonMet(): Any? {
        return personMet
    }

    fun setPersonMet(personMet: Any?) {
        this.personMet = personMet
    }

    fun getPersonMetDesignation(): Any? {
        return personMetDesignation
    }

    fun setPersonMetDesignation(personMetDesignation: Any?) {
        this.personMetDesignation = personMetDesignation
    }

    fun getIsDocumentSigned(): Any? {
        return isDocumentSigned
    }

    fun setIsDocumentSigned(isDocumentSigned: Any?) {
        this.isDocumentSigned = isDocumentSigned
    }

    fun getAuthorisedPersonName(): Any? {
        return authorisedPersonName
    }

    fun setAuthorisedPersonName(authorisedPersonName: Any?) {
        this.authorisedPersonName = authorisedPersonName
    }

    fun getAuthorisedPersonDesignation(): Any? {
        return authorisedPersonDesignation
    }

    fun setAuthorisedPersonDesignation(authorisedPersonDesignation: Any?) {
        this.authorisedPersonDesignation = authorisedPersonDesignation
    }

    fun getIsMetAuthorisedPerson(): Any? {
        return isMetAuthorisedPerson
    }

    fun setIsMetAuthorisedPerson(isMetAuthorisedPerson: Any?) {
        this.isMetAuthorisedPerson = isMetAuthorisedPerson
    }

    fun getIsProofShown(): Any? {
        return isProofShown
    }

    fun setIsProofShown(isProofShown: Any?) {
        this.isProofShown = isProofShown
    }

    fun getDocumentName(): Any? {
        return documentName
    }

    fun setDocumentName(documentName: Any?) {
        this.documentName = documentName
    }

    fun getOtherObservations(): Any? {
        return otherObservations
    }

    fun setOtherObservations(otherObservations: Any?) {
        this.otherObservations = otherObservations
    }

    fun getLongitude(): Any? {
        return longitude
    }

    fun setLongitude(longitude: Any?) {
        this.longitude = longitude
    }

    fun getLatitude(): Any? {
        return latitude
    }

    fun setLatitude(latitude: Any?) {
        this.latitude = latitude
    }

    fun getIsOfficeOpen(): Any? {
        return isOfficeOpen
    }

    fun setIsOfficeOpen(isOfficeOpen: Any?) {
        this.isOfficeOpen = isOfficeOpen
    }

}