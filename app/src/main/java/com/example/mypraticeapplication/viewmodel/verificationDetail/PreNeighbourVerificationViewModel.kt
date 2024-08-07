package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.getPreNeighbourData.GetPreNeighbourResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetFiRequestPreNeighboutVerificationDto
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.detail.ActivityDetail
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PreNeighbourVerificationViewModel(private val context: Context) : BaseViewModel() {

    // Login Params
    var neighbour1Name : ObservableField<String> = ObservableField()
    var neighbour2Name : ObservableField<String> = ObservableField()
    var neighbour1Mobile : ObservableField<String> = ObservableField()
    var neighbour2Mobile : ObservableField<String> = ObservableField()
    var neighbour1Remark : ObservableField<String> = ObservableField()
    var neighbour2Remark : ObservableField<String> = ObservableField()
    var reason : ObservableField<String> = ObservableField()


    private var preNeighbourMutableLiveData: MutableLiveData<GetFiRequestPreNeighboutVerificationDto> = MutableLiveData()

    var isNeighbourReconised = MutableLiveData<Boolean>()
    var selectedReasonPosition =  MutableLiveData<Int>()

    @SuppressLint("SuspiciousIndentation")
    fun init(context: Context?) {
      isNeighbourReconised.value = false
      selectedReasonPosition.value = 0

        if (ActivityDetail.selectedData != null){

            neighbour1Name.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour1Name().toString()))
            neighbour1Mobile.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour1Mobile().toString()))
            neighbour1Remark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour1Remark().toString()))
            neighbour2Name.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour2Name().toString()))
            neighbour2Mobile.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour2Mobile().toString()))
            neighbour2Remark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour2Remark().toString()))
            reason.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getReason().toString()))

            isNeighbourReconised.value = ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getIsNeighbourRecognised().toString() != "false"
        }
    }

    // On Saved Clicked
    fun onSaveClicked() {
        if (selectedReasonPosition.value  == 0){
            Utils().showToast(context,"Please Select Reason")
        }
        else if (neighbour1Mobile.get().toString() == ""){
            Utils().showToast(context,"Please Enter Neighbour1 Mobile Number")
        } else if (neighbour1Mobile.get().toString().length < 10){
            Utils().showToast(context,"Please Enter Valid Neighbour1 Mobile Number")
        }
        else if (neighbour2Mobile.get().toString() == ""){
            Utils().showToast(context,"Please Enter Neighbour2 Mobile Number")
        } else if (neighbour2Mobile.get().toString().length < 10){
            Utils().showToast(context,"Please Enter Valid Neighbour2 Mobile Number")
        }
        else {
            val model = GetFiRequestPreNeighboutVerificationDto()
            model.setNeighbour1Name(neighbour1Name.get().toString())
            model.setNeighbour2Name(neighbour2Name.get().toString())
            model.setNeighbour1Mobile(neighbour1Mobile.get().toString())
            model.setNeighbour2Mobile(neighbour2Mobile.get().toString())
            model.setNeighbour1Remark(neighbour1Remark.get().toString())
            model.setNeighbour2Remark(neighbour2Remark.get().toString())
            model.setReason(reason.get().toString())
            model.setIsNeighbourRecognised(isNeighbourReconised.value.toString())
            preNeighbourMutableLiveData.value = model
            savePreNeighbourData(model)
        }
    }

    private fun savePreNeighbourData(model: GetFiRequestPreNeighboutVerificationDto) {

        val params = HashMap<String,Any>()
        params["firequestId"] = AppConstants.verificationId.toString()
        params["neighbour1Name"] = model.getNeighbour1Name().toString()
        params["neighbour2Name"] = model.getNeighbour2Name().toString()
        params["neighbour1Mobile"] = model.getNeighbour1Mobile().toString()
        params["neighbour2Mobile"] = model.getNeighbour2Mobile().toString()
        params["neighbour1Remark"] = model.getNeighbour1Remark().toString()
        params["neighbour2Remark"] = model.getNeighbour2Remark().toString()
        params["isNeighbourRecognised"] = isNeighbourReconised.value.toString()
        params["reason"] = reason.get().toString()


        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getSavePreNeighbourData(Networking.wrapParams(params))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetPreNeighbourResponse>() {
                    override fun onSuccess(response: GetPreNeighbourResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetPreNeighbourResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            Utils().showToast(context,t.getMessage().toString())
                        }else{
                            Utils().showToast(context,t.getMessage().toString())
                        }
                        Log.e("StatusCode",t.getStatus().toString())
                    }
                })
        }else{
            Utils().showToast(context,context.getString(R.string.nointernetconnection).toString())
        }
    }

    //  For Click Listener Sequence
    val clicksListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedReasonPosition.value = position
           Log.e("Selected", "Selected$position")
            if (position == 2 || position == 3){
                isNeighbourReconised.value = false
            }
            else{
                isNeighbourReconised.value = true
            }
        }
    }
}