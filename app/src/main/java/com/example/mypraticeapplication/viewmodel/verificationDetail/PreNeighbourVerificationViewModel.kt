package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FragmentPreNeighbourVerificationBinding
import com.example.mypraticeapplication.interfaces.OnItemSelected
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.getPreNeighbourData.GetPreNeighbourResponse
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetFiRequestPreNeighboutVerificationDto
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestData
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.adapter.DashboardAdapter
import com.example.mypraticeapplication.view.adapter.DocumentAdapter
import com.example.mypraticeapplication.view.detail.ActivityDetail
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PreNeighbourVerificationViewModel(private val context: Context, val binding: FragmentPreNeighbourVerificationBinding) : BaseViewModel() {

    // Login Params
    var neighbour1Name: ObservableField<String> = ObservableField()
    var neighbour2Name: ObservableField<String> = ObservableField()
    var neighbour1Mobile: ObservableField<String> = ObservableField()
    var neighbour2Mobile: ObservableField<String> = ObservableField()
    var neighbour1Remark: ObservableField<String> = ObservableField()
    var neighbour2Remark: ObservableField<String> = ObservableField()
    var reason: ObservableField<String> = ObservableField()


    private var preNeighbourMutableLiveData: MutableLiveData<GetFiRequestPreNeighboutVerificationDto> =
        MutableLiveData()

    var isNeighbourReconised = MutableLiveData<Boolean>()
    var isNeighbourReconisedText = MutableLiveData<String>()
    var selectedReasonPosition = MutableLiveData<Int>()
    var selectedItemPosition: Int = 0

    private var neighbourRecognisedList: List<String>? = null

    @SuppressLint("SuspiciousIndentation")
    fun init(context: Context?) {

        val materialStatusList =  context!!.resources.getStringArray(R.array.neighbourrecognised_array)
        neighbourRecognisedList = materialStatusList.asList()

        isNeighbourReconised.value = false
        isNeighbourReconisedText.value = ""
        selectedReasonPosition.value = 0

        if (ActivityDetail.selectedData != null) {

            neighbour1Name.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour1Name().toString()))
            neighbour1Mobile.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour1Mobile().toString()))
            neighbour1Remark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour1Remark().toString()))
            neighbour2Name.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour2Name().toString()))
            neighbour2Mobile.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour2Mobile().toString()))
            neighbour2Remark.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getNeighbour2Remark().toString()))
            reason.set(Utility.getNullToBlankString(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getReason().toString()))

            isNeighbourReconised.value =
                ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!
                    .getIsNeighbourRecognised().toString() != "false"

            setSelectedNeighbourReconised(ActivityDetail.selectedData!!.getFirequestPreNeighboutVerificationDto()!!.getIsNeighbourRecognised().toString())

            binding.spnNeighbourReconised.setListAdapter(neighbourRecognisedList)

            binding.spnNeighbourReconised.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    var position =  Utility.getPositionFromArraylist(Utility.getNullToBlankString(s.toString()),neighbourRecognisedList)
                    selectedReasonPosition.value = position
                    val neighourReconisedText = context.resources.getStringArray(R.array.neighbourrecognised_array)
                    isNeighbourReconisedText.value = neighourReconisedText[position]
                    if (position == 2 || position == 3) {
                        isNeighbourReconised.value = false
                    } else {
                        isNeighbourReconised.value = true
                    }
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })

        }
    }

    private fun setSelectedNeighbourReconised(isText: String) {
        val pos =
            context.resources.getStringArray(R.array.neighbourrecognised_array).indexOf(isText)
        if (pos >= 0) {
            selectedItemPosition = pos
        }
    }

    // On Saved Clicked
    fun onSaveClicked() {
        if (selectedReasonPosition.value == 0) {
            Utils().showSnackBar(context, "Please Select Reason", binding.constraintLayout)
        } else if (neighbour1Mobile.get().toString() == "") {
            Utils().showSnackBar(
                context,
                "Please Enter Neighbour1 Mobile Number",
                binding.constraintLayout
            )
        } else if (neighbour1Mobile.get().toString().length < 10) {
            Utils().showSnackBar(
                context,
                "Please Enter Valid Neighbour1 Mobile Number",
                binding.constraintLayout
            )
        } else if (neighbour2Mobile.get().toString() == "") {
            Utils().showSnackBar(
                context,
                "Please Enter Neighbour2 Mobile Number",
                binding.constraintLayout
            )
        } else if (neighbour2Mobile.get().toString().length < 10) {
            Utils().showSnackBar(
                context,
                "Please Enter Valid Neighbour2 Mobile Number",
                binding.constraintLayout
            )
        } else {
            val model = GetFiRequestPreNeighboutVerificationDto()
            model.setNeighbour1Name(neighbour1Name.get().toString())
            model.setNeighbour2Name(neighbour2Name.get().toString())
            model.setNeighbour1Mobile(neighbour1Mobile.get().toString())
            model.setNeighbour2Mobile(neighbour2Mobile.get().toString())
            model.setNeighbour1Remark(neighbour1Remark.get().toString())
            model.setNeighbour2Remark(neighbour2Remark.get().toString())
            model.setReason(reason.get().toString())
            model.setIsNeighbourRecognised(isNeighbourReconisedText.value.toString())
            preNeighbourMutableLiveData.value = model
            savePreNeighbourData(model)
        }
    }

        private fun savePreNeighbourData(model: GetFiRequestPreNeighboutVerificationDto) {

            val params = HashMap<String, Any>()
            params["firequestId"] = AppConstants.verificationId.toString()
            params["neighbour1Name"] = model.getNeighbour1Name().toString()
            params["neighbour2Name"] = model.getNeighbour2Name().toString()
            params["neighbour1Mobile"] = model.getNeighbour1Mobile().toString()
            params["neighbour2Mobile"] = model.getNeighbour2Mobile().toString()
            params["neighbour1Remark"] = model.getNeighbour1Remark().toString()
            params["neighbour2Remark"] = model.getNeighbour2Remark().toString()
            params["isNeighbourRecognised"] = isNeighbourReconisedText.value.toString()
            params["reason"] = reason.get().toString()


            if (Utility.isNetworkConnected(context)) {
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
                            Log.e("Status", t.getStatusCode().toString())
                            isLoading.postValue(false)
                            if (t.getStatusCode() == 200) {
                                Utils().showSnackBar(
                                    context,
                                    t.getMessage().toString(),
                                    binding.constraintLayout
                                )
                            } else {
                                Utils().showSnackBar(
                                    context,
                                    t.getMessage().toString(),
                                    binding.constraintLayout
                                )
                            }
                            Log.e("StatusCode", t.getStatus().toString())
                        }
                    })
            } else {
                Utils().showSnackBar(
                    context,
                    context.getString(R.string.nointernetconnection).toString(),
                    binding.constraintLayout
                )
            }
        }

        //  For Click Listener Sequence
        val clicksListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedReasonPosition.value = position
                val neighourReconisedText =
                    context.resources.getStringArray(R.array.neighbourrecognised_array)
                isNeighbourReconisedText.value = neighourReconisedText[position]
                if (position == 2 || position == 3) {
                    isNeighbourReconised.value = false
                } else {
                    isNeighbourReconised.value = true
                }
            }
        }


    }