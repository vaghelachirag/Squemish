package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FragmentFinalSubmitBinding
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.finalSubmission.GetFinalSubmissionApiResponse
import com.example.mypraticeapplication.model.finalSubmission.SaveFinalSubmissionData
import com.example.mypraticeapplication.model.getSaveResidenceVerificationResponse.GetSaveResidenceVerificationResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.model.saveresidenceverification.SaveVerificationDataDetail
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.room.dao.MasterDataDao
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FinalSubmitViewModel(private val context: Context,private  val binding: FragmentFinalSubmitBinding): BaseViewModel(){


    var selectedReasonPosition = MutableLiveData<Int>()
    var selectedItemPosition: Int = 0

    // Room Database
    private var masterDataDao: MasterDataDao? = null

    private var finalSubmissionList: List<String>? = null
    private var finalSubmissionSpinnerAdapter: ArrayAdapter<String?>? = null

    var edtRemark: ObservableField<String> = ObservableField()


    fun init(context: Context?) {
        masterDataDao = InitDb.appDatabase.getMasterData()
        getDataFromMasterData()
    }

    public fun onSaveClicked(){
       if (edtRemark.get().toString() == "") {
            Utils().showSnackBar(context, "Please Enter Remark", binding.constraintLayout)
        }else{
            callFinalSubmitApi()
        }
    }

    private fun callFinalSubmitApi() {
        val saveFinalSubmit: SaveFinalSubmissionData = SaveFinalSubmissionData()
        saveFinalSubmit.setFIStatus(binding.spFinalSubmission.selectedItem.toString())
        saveFinalSubmit.setFIRequestId(AppConstants.verificationId)
        saveFinalSubmit.setRemarks(edtRemark.get())

        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getSaveFinalSubmissionResponse(saveFinalSubmit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetFinalSubmissionApiResponse>() {
                    override fun onSuccess(response: GetFinalSubmissionApiResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetFinalSubmissionApiResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            //   Utils().showToast(context,t.getMessage().toString())
                            Utils().showSnackBar(context,t.getMessage().toString(),binding.constraintLayout)
                        }else{
                            Utils().showSnackBar(context,t.getMessage().toString(),binding.constraintLayout)
                            // Utils().showToast(context,t.getMessage().toString())
                        }
                        Log.e("StatusCode",t.getStatus().toString())
                    }
                })
        }else{
            // Utils().showToast(context,context.getString(R.string.nointernetconnection).toString())
            Utils().showSnackBar(context,context.getString(R.string.nointernetconnection).toString(),binding.constraintLayout)
        }
    }

    private fun getDataFromMasterData() {
        CoroutineScope(Dispatchers.IO).launch {
            finalSubmissionList = masterDataDao!!.getDataByKeyName(AppConstants.finalSubmission)

            finalSubmissionSpinnerAdapter =
                ArrayAdapter<String?>(
                    context,
                    android.R.layout.simple_spinner_item,
                    finalSubmissionList!!
                )
            finalSubmissionSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.spFinalSubmission.adapter = finalSubmissionSpinnerAdapter
        }
    }

    //  For Click Listener Sequence
    val clicksListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedReasonPosition.value = position
        }
    }
}