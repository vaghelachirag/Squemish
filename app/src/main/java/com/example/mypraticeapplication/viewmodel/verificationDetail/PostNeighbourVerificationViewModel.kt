package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FragmentPostNeighbourVerificationBinding
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.getPreNeighbourData.GetPreNeighbourResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetFirequestPostNeighboutVerificationDto
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.detail.ActivityDetail
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostNeighbourVerificationViewModel(
    private val context: Context,
    private val  binding: FragmentPostNeighbourVerificationBinding
) : BaseViewModel() {


    // Login Params
    var neighbour3Name : ObservableField<String> = ObservableField()
    var neighbour4Name : ObservableField<String> = ObservableField()
    var neighbour3Mobile : ObservableField<String> = ObservableField()
    var neighbour4Mobile : ObservableField<String> = ObservableField()
    var neighbour3Remark : ObservableField<String> = ObservableField()
    var neighbour4Remark : ObservableField<String> = ObservableField()
    var reason : ObservableField<String> = ObservableField()

    private var postNeighbourMutableLiveData: MutableLiveData<GetFirequestPostNeighboutVerificationDto> = MutableLiveData()

    var isNeighbourReconised = MutableLiveData<Boolean>()
    var isNeighbourReconisedText = MutableLiveData<String>()
    var selectedReasonPosition = MutableLiveData<Int>()
    var selectedItemPosition: Int = 0

    fun init(context: Context?) {

        isNeighbourReconised.value = false
        isNeighbourReconisedText.value = ""
        selectedReasonPosition.value = 0

        if (ActivityDetail.selectedData != null){
            neighbour3Name.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!.getNeighbour3Name().toString()))
            neighbour3Mobile.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!.getNeighbour3Mobile().toString()))
            neighbour3Remark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!.getNeighbour3Remark().toString()))
            neighbour4Name.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!.getNeighbour4Name().toString()))
            neighbour4Mobile.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!.getNeighbour4Mobile().toString()))
            neighbour4Remark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!.getNeighbour4Remark().toString()))
            reason.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!.getReason().toString()))


            if (ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!.getIsNeighbourRecognised().toString() == "false"){
                isNeighbourReconised.value = false
            }else{
                isNeighbourReconised.value = true
            }
        }

        isNeighbourReconised.value =
            ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!
                .getIsNeighbourRecognised().toString() != "false"

        setSelectedNeighbourReconised(ActivityDetail.selectedData!!.getFirequestPostNeighboutVerificationDto()!!.getIsNeighbourRecognised().toString())
    }

    private fun setSelectedNeighbourReconised(isText: String) {
        val pos =
            context.resources.getStringArray(R.array.neighbourrecognised_array).indexOf(isText)
        if (pos >= 0) {
            selectedItemPosition = pos
        }
    }


    //  For Click Listener Sequence
    val clicksListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedReasonPosition.value = position
            val neighourReconisedText = context.resources.getStringArray(R.array.neighbourrecognised_array)
            isNeighbourReconisedText.value = neighourReconisedText[position]
            Log.e("Selected",isNeighbourReconisedText.value.toString())
            if (position == 2 || position == 3) {
                isNeighbourReconised.value = false
            } else {
                isNeighbourReconised.value = true
            }
        }
    }

    // On Saved Clicked
    fun onSaveClicked() {
        if (selectedReasonPosition.value  == 0){
         //   Utils().showToast(context,"Please Select Reason")
            Utils().showSnackBar(context,"Please Select Reason",binding.constraintLayout)
        }
        else if (neighbour3Mobile.get().toString() == ""){
            Utils().showSnackBar(context,"Please Enter Neighbour1 Mobile Number",binding.constraintLayout)
        } else if (neighbour3Mobile.get().toString().length < 10){
            Utils().showSnackBar(context,"Please Enter Valid Neighbour1 Mobile Number",binding.constraintLayout)
        }
        else if (neighbour4Mobile.get().toString() == ""){
            Utils().showSnackBar(context,"Please Enter Neighbour2 Mobile Number",binding.constraintLayout)
        } else if (neighbour4Mobile.get().toString().length < 10){
            Utils().showSnackBar(context,"Please Enter Valid Neighbour2 Mobile Number",binding.constraintLayout)
        }
        else {
            val model = GetFirequestPostNeighboutVerificationDto()
            model.setNeighbour3Name(neighbour3Name.get().toString())
            model.setNeighbour4Name(neighbour3Name.get().toString())
            model.setNeighbour3Mobile(neighbour3Mobile.get().toString())
            model.setNeighbour4Mobile(neighbour4Mobile.get().toString())
            model.setNeighbour3Remark(neighbour3Remark.get().toString())
            model.setNeighbour4Remark(neighbour4Remark.get().toString())
            model.setReason(reason.get().toString())
            model.setIsNeighbourRecognised(isNeighbourReconisedText.value)
            postNeighbourMutableLiveData.value = model
            savePostNeighbourData(model)
        }
    }

    private fun savePostNeighbourData(model: GetFirequestPostNeighboutVerificationDto) {

        val params = HashMap<String,Any>()
        params["firequestId"] = AppConstants.verificationId.toString()
        params["neighbour3Name"] = model.getNeighbour3Name().toString()
        params["neighbour4Name"] = model.getNeighbour4Name().toString()
        params["neighbour3Mobile"] = model.getNeighbour3Mobile().toString()
        params["neighbour4Mobile"] = model.getNeighbour4Mobile().toString()
        params["neighbour3Remark"] = model.getNeighbour3Remark().toString()
        params["neighbour4Remark"] = model.getNeighbour4Remark().toString()
        params["isNeighbourRecognised"] = isNeighbourReconisedText.value.toString()
        params["reason"] = reason.get().toString()


        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getSavePostNeighbourData(Networking.wrapParams(params))
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
                            Utils().showSnackBar(context,t.getMessage().toString(),binding.constraintLayout)
                        }else{
                            Utils().showSnackBar(context,t.getMessage().toString(),binding.constraintLayout)
                        }
                        Log.e("StatusCode",t.getStatus().toString())
                    }
                })
        }else{
            Utils().showSnackBar(context,context.getString(R.string.nointernetconnection).toString(),binding.constraintLayout)
        }
    }
}