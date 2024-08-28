package com.example.mypraticeapplication.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.IntentSender.SendIntentException
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FragmentRcoVerificationBinding
import com.example.mypraticeapplication.databinding.TestActivityBinding
import com.example.mypraticeapplication.view.base.BaseActivity
import com.example.mypraticeapplication.viewmodel.verificationDetail.DocumentProfileVerificationViewModel
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCOVerificationViewModel
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

    var data : String = ""
 //   private val documentProfileVerificationViewModel by lazy { DocumentProfileVerificationViewModel( this,binding) }

    @SuppressLint("DiscouragedPrivateApi", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TestActivityBinding.inflate(layoutInflater)
     //   binding.viewModel = documentProfileVerificationViewModel
     //   binding.lifecycleOwner = this
        setContentView(binding.root)

    }


}