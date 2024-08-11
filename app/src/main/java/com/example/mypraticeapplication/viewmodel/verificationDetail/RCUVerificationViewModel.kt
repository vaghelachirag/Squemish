package com.example.mypraticeapplication.viewmodel.verificationDetail

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.room.dao.MasterDataDao
import com.example.mypraticeapplication.uttils.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RCUVerificationViewModel(
    private val context: Context,
    private  val binding: FragmentRcuVerificationBinding
) : BaseViewModel() {


    // Login Params
    var edt_Applicant_Latitude_label: ObservableField<String> = ObservableField()
    var edt_Applicant_Longitude_label: ObservableField<String> = ObservableField()
    var edt_applicant_OtherObservations_label: ObservableField<String> = ObservableField()
    var edt_Remark: ObservableField<String> = ObservableField()
    var edt_Reason: ObservableField<String> = ObservableField()


    // All Variable
    var isAddressConfirmed = MutableLiveData<Boolean>()
    var isAddressBelong = MutableLiveData<Boolean>()
    var isHouseOpen = MutableLiveData<Boolean>()
    var isNameboardseenattheHouse = MutableLiveData<Boolean>()
    var isNameboardmismatched = MutableLiveData<Boolean>()



    var selectedHouseLocalityPosition = MutableLiveData<Int>()
    var selectedHouseLocalityItemPosition: Int = 0

    var selectedAccommodationTypePosition = MutableLiveData<Int>()
    var selectedAccommodationTypeItemPosition: Int = 0


    var houseLocalityList : List<String>? = null
    var accommodationList: List<String>? = null

    private var houseLocalitySpinnerAdapter: ArrayAdapter<String?>? = null
    private var accommodationTypeSpinnerAdapter: ArrayAdapter<String?>? = null


    // Room Database
    private var masterDataDao: MasterDataDao? = null

    fun init(context: Context?) {
        isAddressConfirmed.value =  true
        // Room Database
        masterDataDao = InitDb.appDatabase.getMasterData()
        getDataFromMasterData()
    }

    private fun getDataFromMasterData() {
        CoroutineScope(Dispatchers.IO).launch {
            houseLocalityList   =  masterDataDao!!.getDataByKeyName(AppConstants.houseOrPremiseLocalityType)
            accommodationList   =  masterDataDao!!.getDataByKeyName(AppConstants.accommodationType)

            houseLocalitySpinnerAdapter =
                ArrayAdapter<String?>(context, android.R.layout.simple_spinner_item, houseLocalityList!!)
            houseLocalitySpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.spnHouseLocality.adapter = houseLocalitySpinnerAdapter


            accommodationTypeSpinnerAdapter =
                ArrayAdapter<String?>(context, android.R.layout.simple_spinner_item, accommodationList!!)
            accommodationTypeSpinnerAdapter?.setDropDownViewResource(R.layout.custom_spinner_item)

            binding.spnAccommodationType.adapter = accommodationTypeSpinnerAdapter
        }
    }

    val onAddressConfirmed = RadioGroup.OnCheckedChangeListener { _, checkedId ->
        if (checkedId == R.id.radio_AddressConfirmedYes){
            isAddressConfirmed.value = true
        }
        if (checkedId == R.id.radio_AddressConfirmedNo){
            isAddressConfirmed.value = false
        }
        if (checkedId == R.id.rb_AddressBelongYes){
            isAddressBelong.value = true
        }
        if (checkedId == R.id.rb_AddressBelongNo){
            isAddressBelong.value = false
        }

        if (checkedId == R.id.rb_IsNameboardseenattheHouseYes){
            isNameboardseenattheHouse.value = true
        }

        if (checkedId == R.id.rb_IsNameboardseenattheHouseNo){
            isNameboardseenattheHouse.value = false
        }

        if (checkedId == R.id.rb_applicant_IsNameboardseenattheHouse_labelYes){
            isNameboardmismatched.value = true
        }

        if (checkedId == R.id.rb_applicant_IsNameboardseenattheHouse_labeleNo){
            isNameboardmismatched.value = false
        }
    }



    //  For Click Listener Sequence
    val clicksHouseLocalityListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedHouseLocalityPosition.value = position
            val neighourReconisedText = context.resources.getStringArray(R.array.neighbourrecognised_array)
        }
    }


    //  For Click Listener Sequence
    val clicksAccommodationTypeListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            selectedAccommodationTypePosition.value = position
            val neighourReconisedText = context.resources.getStringArray(R.array.neighbourrecognised_array)
        }
    }
}