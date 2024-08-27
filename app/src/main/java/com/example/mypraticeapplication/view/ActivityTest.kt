package com.example.mypraticeapplication.view

import android.annotation.SuppressLint
import android.content.IntentSender.SendIntentException
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.TestActivityBinding
import com.example.mypraticeapplication.view.base.BaseActivity
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.PendingResult
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsResult
import com.google.android.gms.location.LocationSettingsStatusCodes


open class ActivityTest: BaseActivity()  {

    private lateinit var binding: TestActivityBinding

    private var houseLocalitySpinnerAdapter: ArrayAdapter<String?>? = null
    private var houseLocalityList: List<String>? = null

    private var googleApiClient: GoogleApiClient? = null
    protected val REQUEST_CHECK_SETTINGS = 0x1


    @SuppressLint("DiscouragedPrivateApi", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TestActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val materialStatusList =  resources.getStringArray(R.array.material_status)
        houseLocalityList = materialStatusList.asList()

        binding.tvAddressConfirmed.setListAdapter(houseLocalityList)

        googleApiClient = getAPIClientInstance();
        if (googleApiClient != null) {
            googleApiClient!!.connect();
        }

        requestGPSSettings()

    }

    private fun getAPIClientInstance(): GoogleApiClient {
        return GoogleApiClient.Builder(this)
            .addApi(LocationServices.API).build()
    }

    private fun requestGPSSettings() {
        val locationRequest: LocationRequest = LocationRequest.create()
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
        locationRequest.setInterval(2000)
        locationRequest.setFastestInterval(500)
        val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)
        builder.setAlwaysShow(true)
        val result: PendingResult<LocationSettingsResult> =
            LocationServices.SettingsApi.checkLocationSettings(
                googleApiClient!!, builder.build()
            )
        result.setResultCallback { result ->
            val status: Status = result.status
            when (status.statusCode) {
                LocationSettingsStatusCodes.SUCCESS -> {
                    Log.i("", "All location settings are satisfied.")
                    Toast.makeText(application, "GPS is already enable", Toast.LENGTH_SHORT)
                        .show()
                }

                LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> {
                    Log.i(
                        "",
                        "Location settings are not satisfied. Show the user a dialog to" + "upgrade location settings "
                    )
                    try {
                        status.startResolutionForResult(
                            this,
                            REQUEST_CHECK_SETTINGS
                        )
                    } catch (e: SendIntentException) {
                        Log.e("Applicationsett", e.toString())
                    }
                }

                LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                    Log.i(
                        "",
                        "Location settings are inadequate, and cannot be fixed here. Dialog " + "not created."
                    )
                    Toast.makeText(
                        application,
                        "Location settings are inadequate, and cannot be fixed here",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


}