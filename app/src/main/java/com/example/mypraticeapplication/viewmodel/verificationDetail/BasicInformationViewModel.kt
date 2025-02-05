package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.getAcceptRejectResponse.GetAcceptRejectResponse
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.room.dao.MasterDataDao
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.detail.ActivityDetail
import com.example.mypraticeapplication.view.detail.FragmentBasicInformation
import com.example.mypraticeapplication.view.dialougs.AcceptRejectFIDialog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BasicInformationViewModel(private val context: Context) : BaseViewModel(){

    // Login Params
    var refNo : ObservableField<String> = ObservableField()
    var caseID : ObservableField<String> = ObservableField()
    var bankName : ObservableField<String> = ObservableField()
    var verificationFor : ObservableField<String> = ObservableField()
    var verificationType : ObservableField<String> = ObservableField()
    var applicant : ObservableField<String> = ObservableField()
    var coapplicant : ObservableField<String> = ObservableField()
    var addressFor : ObservableField<String> = ObservableField()
    var applicantfathername : ObservableField<String> = ObservableField()
    var productsubproduct : ObservableField<String> = ObservableField()
    var officeName : ObservableField<String> = ObservableField()
    var prepost : ObservableField<String> = ObservableField()
    var loanAmount : ObservableField<String> = ObservableField()
    var triggers : ObservableField<String> = ObservableField()

    private var masterDataDao: MasterDataDao? = null

    var acceptReasonList: MutableList<String>? = null
    var rejectReasonList: MutableList<String>? = null


    fun init(context: Context) {

        if (ActivityDetail.selectedData != null){
            refNo.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getRefNo().toString()))
            caseID.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getCaseId().toString()))
            bankName.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getBankAlias().toString()) +" "+  Utility.getNullToBlankString(ActivityDetail.selectedData!!.getBankName().toString()))
            verificationFor.set("Applicant")
            verificationType.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getVerificationType().toString()))
            applicant.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getApplicantName().toString()) + " / "+ Utility.getNullToBlankString(ActivityDetail.selectedData!!.getApplicantFatherName().toString()))
            coapplicant.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getOtherApplicantName().toString()))
            addressFor.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getApplicantAddress().toString()) +" "+ Utility.getNullToBlankString(ActivityDetail.selectedData!!.getApplicantPinCode().toString()) +" "+  Utility.getNullToBlankString(ActivityDetail.selectedData!!.getApplicantCity().toString() +" "+ ActivityDetail.selectedData!!.getApplicantState().toString()))
            applicantfathername.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getApplicantFatherName().toString()))
            productsubproduct.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getLoanProductName().toString())  + " "+ Utility.getNullToBlankString(ActivityDetail.selectedData!!.getSubLoanProduct().toString()))
            officeName.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFiRequestOfficeVerification().toString()))
            prepost.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getPrePost().toString()))
            loanAmount.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getLoanAmount().toString()))
            triggers.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getTriggerRemarks().toString()))
        }

        // Room Database
        masterDataDao = InitDb.appDatabase.getMasterData()
        getAcceptRejectList()
    }

    private fun getAcceptRejectList() {
        CoroutineScope(Dispatchers.IO).launch {
            if (masterDataDao!!.getDataByKeyName(AppConstants.AcceptReason).isNullOrEmpty()){
                acceptReasonList   =  masterDataDao!!.getDataByKeyName(AppConstants.AcceptReason)
                rejectReasonList   =  masterDataDao!!.getDataByKeyName(AppConstants.RejectReason)
            }
        }
    }

    fun showAcceptRejectDialoug(isAccept: Boolean) {

        var reasonList: MutableList<String>? = null
        reasonList = if (isAccept){
            acceptReasonList
        } else{
            rejectReasonList
        }

        AcceptRejectFIDialog(context as Activity,reasonList!!,isAccept)
            .setListener(object : AcceptRejectFIDialog.OkButtonListener {
                override fun onOkPressed(
                    acceptRejectFIDialog: AcceptRejectFIDialog,
                    selectedReason: String?,
                    isAcceptReject: Boolean
                ) {
                    if(isAcceptReject){
                        acceptRejectFIDialog.dismiss()
                        getAcceptRejectRequestResponse(true,selectedReason)
                    }
                    else{
                        acceptRejectFIDialog.dismiss()
                        getAcceptRejectRequestResponse(false,selectedReason)
                    }
                    Log.e("Reason",selectedReason.toString())
                }

            })
            .show()
    }
   fun getAcceptRejectRequestResponse(isAccept: Boolean, selectedReason: String?){

       val params = HashMap<String,Any>()
      // params["FirequestId"] = AppConstants.verificationId.toString()
       params["FirequestId"] =  AppConstants.verificationId.toString()
       params["Reason"] = selectedReason.toString()
       params["IsAccept"] = isAccept

       if (Utility.isNetworkConnected(context)){
           isLoading.postValue(true)
           Networking.with(context)
               .getServices()
               .getAcceptRejectResponse(Networking.wrapParams(params))
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(object : CallbackObserver<GetAcceptRejectResponse>() {
                   override fun onSuccess(response: GetAcceptRejectResponse) {
                       isLoading.postValue(false)
                   }

                   override fun onFailed(code: Int, message: String) {
                       isLoading.postValue(false)
                   }

                   override fun onNext(t: GetAcceptRejectResponse) {
                       Log.e("Status",t.getStatusCode().toString())
                       isLoading.postValue(false)
                       if(t.getStatusCode() == 200){
                           Utils().showToast(context,t.getMessage().toString())
                           FragmentBasicInformation().redirectToDashboardScreen()
                       }else{
                           Utils().showToast(context,t.getMessage().toString())
                           FragmentBasicInformation().redirectToDashboardScreen()
                       }
                       Log.e("StatusCode",t.getStatus().toString())
                   }
               })
       }else{
           Utils().showToast(context,context.getString(R.string.nointernetconnection).toString())
       }
    }
}