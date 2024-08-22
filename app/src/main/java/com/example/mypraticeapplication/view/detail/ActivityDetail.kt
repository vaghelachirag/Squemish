package com.example.mypraticeapplication.view.detail

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.mypraticeapplication.databinding.ActivityDetailBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.view.adapter.VerificationDetailViewPagerAdapter
import com.example.mypraticeapplication.view.base.BaseActivity
import com.example.mypraticeapplication.viewmodel.DetailViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale


class ActivityDetail  : BaseActivity()  {

    private lateinit var binding: ActivityDetailBinding

    private val detailViewModel by lazy { DetailViewModel(this) }

    // Location
    var locationManager: LocationManager? = null
    var locationListener: LocationListener? = null

    var geocoder: Geocoder? = null
    var addresses: List<Address>? = null

    lateinit var mFusedLocationClient: FusedLocationProviderClient

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager!!.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 0, 0f,
                    locationListener!!
                )
            }
        }
    }

    @SuppressLint("DiscouragedPrivateApi", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        geocoder = Geocoder(this, Locale.getDefault())
        locationManager = this.getSystemService(LOCATION_SERVICE) as LocationManager

        binding.lifecycleOwner = this
        detailViewModel.init(this)
        setProgressData()
        setView()
        setActionBarHeader()
        setAction()
        getUserCurrentLocation()
        binding.viewPager.setSwipeable(false)
    }

    private fun getUserCurrentLocation() {
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                Log.i("LOCATION", location.toString())
                Log.e("Location",location.toString())
                currentLat = location.latitude
                currentLong = location.longitude
                addresses = geocoder!!.getFromLocation(location.latitude, location.longitude, 1);
                if(!addresses.isNullOrEmpty()){
                    useraddress = addresses!![0].getAddressLine(0)
                    Log.e("Address",addresses.toString())
                }
                //Toast.makeText(getApplicationContext(),location.toString(),Toast.LENGTH_SHORT).show();
            }

            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
                Log.e("Location","Status Changed")
            }
            override fun onProviderEnabled(provider: String) {
                Log.e("Location","Enable")
            }
            override fun onProviderDisabled(provider: String) {
                Log.e("Location","Disable")
                Utility.showLocationAlert(this@ActivityDetail)
            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            try {
                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
                    val location: Location? = task.result
                    if (location == null) {

                    } else {
                        currentLat = location.latitude
                        currentLong = location.longitude
                        addresses = geocoder!!.getFromLocation(location.latitude, location.longitude, 1);
                        if (!addresses.isNullOrEmpty()){
                            useraddress = addresses!![0].getAddressLine(0)
                            Log.e("CurrentLocation",location.latitude.toString())
                        }
                    }
                }
                locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 10f, locationListener!!)
            }catch (_: Exception){

            }
        }
    }

    private fun setAction() {
        binding.layoutDetail.ivBack.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setActionBarHeader() {
        binding.layoutDetail.tvTitle.text = "Verification Detail"
    }

    companion object {
        public  var selectedData: GetVerificationDetailData? = null
        public  var currentLat : Double = 0.0
        public  var currentLong : Double = 0.0
        public  var useraddress : String = ""
    }

    override fun onResume() {
        super.onResume()
    //  detailViewModel.init(this)
        Log.e("OnResume","OnResume")
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setView() {
        binding.lifecycleOwner = this

       detailViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) showProgressbar()
            else if (!isLoading) hideProgressbar()
        }

        detailViewModel.isData.observeForever {
            if (detailViewModel.isData.value == true){
                //  Log.e("Verification",detailViewModel.getVerificationDetailData.getStatus().toString())
            }
        }

        detailViewModel.getVerificationDetailData.observeForever {
            Log.e("Data","Data" + detailViewModel.getVerificationDetailData.value!!.getStatus().toString())
            selectedData = detailViewModel.getVerificationDetailData.value
            setStatePageAdapter()
        }

        val tabStrip = binding.tabLayout.getChildAt(0)
        for (i in 0 until binding.tabLayout.childCount) {
            binding.tabLayout.getChildAt(i).setOnTouchListener { _, _ -> true }
        }

    }

    private fun setStatePageAdapter() {

        //  Log.e("GetVerification",detailViewModel.getVerificationDetailData.value!!.getStatus().toString())
        val viewPagerAdapter = VerificationDetailViewPagerAdapter(supportFragmentManager, 0)
        viewPagerAdapter.addFragment(FragmentBasicInformation.newInstance(selectedData), "Basic Information")
        viewPagerAdapter.addFragment(FragmentPreNeighbourVerification.newInstance(selectedData), "Pre-Neighbour Verification")
        viewPagerAdapter.addFragment(FragmentRCUVerification.newInstance(selectedData), "RCU Verification")
        viewPagerAdapter.addFragment(FragmentPhotograph.newInstance(), "Photograph")
        viewPagerAdapter.addFragment(FragmentPostNeighbourVerification.newInstance(selectedData), "Post-Neighbour Verification")
        viewPagerAdapter.addFragment(FragmentFinalSubmit.newInstance(selectedData), "Final Submit")

        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager, true)
        binding.viewPager.currentItem = 0
        binding.viewPager.isSaveEnabled = true
        binding.viewPager.offscreenPageLimit = 8

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            var currentPosition = 0
            override fun onPageSelected(newPosition: Int) {
                val fragmentToHide: FragmentLifecycleInterface =
                    viewPagerAdapter.getItem(currentPosition) as FragmentLifecycleInterface
                fragmentToHide.onPauseFragment()
                val fragmentToShow: FragmentLifecycleInterface =
                    viewPagerAdapter.getItem(newPosition) as FragmentLifecycleInterface
                fragmentToShow.onResumeFragment(null)
                currentPosition = newPosition
            }
            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {
            }
            override fun onPageScrollStateChanged(arg0: Int) {}
        })
    }


    private fun setProgressData() {
    }

}