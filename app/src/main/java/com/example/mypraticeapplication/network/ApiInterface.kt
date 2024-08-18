package com.example.mypraticeapplication.network

import com.example.mypraticeapplication.model.changepassword.GetChangePasswordResponse
import com.example.mypraticeapplication.model.finalSubmission.GetFinalSubmissionApiResponse
import com.example.mypraticeapplication.model.finalSubmission.SaveFinalSubmissionData
import com.example.mypraticeapplication.model.getAcceptRejectResponse.GetAcceptRejectResponse
import com.example.mypraticeapplication.model.getFiResidencePicture.GetFiResidencePictureResponse
import com.example.mypraticeapplication.model.getMenuListResponse.GetMenuListResponse
import com.example.mypraticeapplication.model.getMenuWebUrlResponse.GetMenuURLResponse
import com.example.mypraticeapplication.model.getPreNeighbourData.GetPreNeighbourResponse
import com.example.mypraticeapplication.model.getSaveResidenceVerificationResponse.GetSaveResidenceVerificationResponse
import com.example.mypraticeapplication.model.getUserProfileData.GetUserProfileResponse
import com.example.mypraticeapplication.model.getmasterData.GetMasterApiResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDocument
import com.example.mypraticeapplication.model.login.GetLoginResponseModel
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestResponse
import com.example.mypraticeapplication.model.registerDevice.GetDeviceRegistrationResponse
import com.example.mypraticeapplication.model.saveresidenceverification.SaveVerificationDataDetail
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
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

    @POST("api/user/changePassword")
    fun getChangePasswordApiResponse(@Body requestBody: RequestBody): Observable<GetChangePasswordResponse>

    @GET("api/MobileAppMenu/GetWebViewUrl")
    fun getMenuURLResponse(@Query("menuId") menuId: String): Observable<GetMenuURLResponse>

    @POST("api/FiRequest/SaveVerification")
    fun getSaveFiResidenceResponse(@Body requestBody: SaveVerificationDataDetail): Observable<GetSaveResidenceVerificationResponse>


    @POST("api/FiRequest/SaveFirequestFinalSubmission")
    fun getSaveFinalSubmissionResponse(@Body requestBody: SaveFinalSubmissionData): Observable<GetFinalSubmissionApiResponse>


    @POST("api/FiRequest/SaveMobileAppFIDocument")
    fun saveSurveyPictureBase(@Body body: RequestBody): Observable<GetFinalSubmissionApiResponse?>?


    @POST("api/FiRequest/RemoveMobileAppFIDocument")
    fun deleteFiRequestPicture(@Body body: RequestBody): Observable<GetFinalSubmissionApiResponse?>?


    @GET("api/FiRequest/GetFIDocuments")
    fun getFiRequestPicture(@Query("FIRequestId") fiRequestId: String): Observable<GetFiResidencePictureResponse>
}