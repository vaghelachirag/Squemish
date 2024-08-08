package com.example.mypraticeapplication.uttils

object AppConstants {

    var StagingURL = "http://5.77.39.57:50091/api/"
    var LiveURL = "https://surveyorappapi.pickfords.com/api/"
    var TestLiveURL = "https://testsurveyorappapi.pickfords.com/api/"

    val ROOM_DB = "squemish-database"

    var verificationId = 8


    // For timeout
    var readTimeOut: Long = 15
    var connectionTimeOut: Long = 15


    // For Base URL
    var baseURL = "https://squeamish.co.in/Squeamishapi/"

   /* Status Code*/
    var StatusCode0 = "Pending"
    var StatusCode1 = "InProgress"
    var StatusCode2 = "Approved"
    var StatusCode3 = "Rejected"


    var secretKey = "MiPC9BjkCyGDFQXbSkoZcgqH3hpacKA76123J8322EpesabBDjsF23RTdsq8L123278956565452"

    var statusPending  = "ASSIGNED"

    // Database Key Name
    var AcceptReason = "AcceptReason"
    var RejectReason = "RejectReason"


    // Menu Order
    var home = 1
    var changePassword = 15
    var logout = 17

}

