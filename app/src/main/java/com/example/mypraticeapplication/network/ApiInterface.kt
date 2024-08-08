package com.example.mypraticeapplication.network

import com.example.mypraticeapplication.model.getAcceptRejectResponse.GetAcceptRejectResponse
import com.example.mypraticeapplication.model.getMenuListResponse.GetMenuListResponse
import com.example.mypraticeapplication.model.getPreNeighbourData.GetPreNeighbourData
import com.example.mypraticeapplication.model.getPreNeighbourData.GetPreNeighbourResponse
import com.example.mypraticeapplication.model.getUserProfileData.GetUserProfileResponse
import com.example.mypraticeapplication.model.getmasterData.GetMasterApiResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetFiRequestPreNeighboutVerificationDto
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetFirequestPostNeighboutVerificationDto
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailResponse
import com.example.mypraticeapplication.model.registerDevice.GetDeviceRegistrationResponse
import com.example.mypraticeapplication.model.login.GetLoginResponseModel
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestResponse
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @Headers("secret-key: MiPC9BjkCyGDFQXbSkoZcgqH3hpacKA76123J8322EpesabBDjsF23RTdsq8L123278956565452")
    @POST("api/login/mobileuserlogin")
    fun login(@Body requestBody: RequestBody): Observable<GetLoginResponseModel>

    @Headers("secret-key: MiPC9BjkCyGDFQXbSkoZcgqH3hpacKA76123J8322EpesabBDjsF23RTdsq8L123278956565452")
    @POST("api/MobileRegistrationRequest/Save")
    fun registerUser(@Body requestBody: RequestBody): Observable<GetDeviceRegistrationResponse>

    @GET("api/FIRequestVerificationView/GetPendingVerification")
    fun getPendingRequest(): Observable<GetPendingRequestResponse>

    @GET("api/MasterData/GetAllMaster")
    fun getMasterApiData(): Observable<GetMasterApiResponse>

    @GET("api/FiRequest/GetVerificationRecord")
    fun getVerificationRequestDetail(@Query("FIRequestId") requestId: String): Observable<GetVerificationDetailResponse>


    @POST("api/FiRequest/FIAcceptReject")
    fun getAcceptRejectResponse(@Body requestBody: RequestBody): Observable<GetAcceptRejectResponse>

    @POST("api/FiRequest/SavePreNeighbourDetail")
    fun getSavePreNeighbourData(@Body requestBody: RequestBody): Observable<GetPreNeighbourResponse>

    @POST("api/FiRequest/SavePostNeighbourDetail")
    fun getSavePostNeighbourData(@Body requestBody: RequestBody): Observable<GetPreNeighbourResponse>


    @GET("api/user/GetProfileRecord")
    fun getUserProfileData(): Observable<GetUserProfileResponse>


    @GET("api/MobileAppMenu/GetRecords")
    fun getMenuListResponse(): Observable<GetMenuListResponse>
}