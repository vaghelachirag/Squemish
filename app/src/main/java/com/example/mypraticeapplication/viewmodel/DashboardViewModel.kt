package com.example.mypraticeapplication.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.DashboardFragmentBinding
import com.example.mypraticeapplication.interfaces.OnItemSelected
import com.example.mypraticeapplication.model.base.BaseViewModel
import com.example.mypraticeapplication.model.getUserProfileData.GetUserProfileResponse
import com.example.mypraticeapplication.model.getmasterData.GetMasterApiResponse
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestData
import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestResponse
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.room.InitDb
import com.example.mypraticeapplication.room.dao.MasterDataDao
import com.example.mypraticeapplication.uttils.Session
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.adapter.DashboardAdapter
import com.example.mypraticeapplication.view.menu.DashboardFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DashboardViewModel(val context: Context, val dashboardFragment: DashboardFragment, val binding: DashboardFragmentBinding) : BaseViewModel(){

    var verificationList: ArrayList<GetPendingRequestData> = ArrayList()
    private var dashboardAdapter: DashboardAdapter? = null

    var totalVerification : MutableLiveData<Int> = MutableLiveData()

    fun getDashboardListAdapter(): DashboardAdapter? = dashboardAdapter

    private var masterDataDao: MasterDataDao? = null

    // Session Manager
    var session = Session(context)

    fun init(context: Context) {
        totalVerification.value = 0
        getPendingRequest()
        masterDataDao = InitDb.appDatabase.getMasterData()
    }

    @SuppressLint("HardwareIds")
    private fun getPendingRequest() {

        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getPendingRequest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetPendingRequestResponse>() {
                    override fun onSuccess(response: GetPendingRequestResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetPendingRequestResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                          verificationList.clear()
                          if(t.getData() != null){
                             verificationList = t.getData()!!
                              totalVerification.value = verificationList.size
                              setVerificationAdapter()
                             if (session.getIsFirstTimeKey()){
                                 CoroutineScope(Dispatchers.IO).launch {
                                     if (masterDataDao!!.getMasterDataList().size > 0){
                                         Log.e("Master",masterDataDao!!.getMasterDataList().size.toString())
                                      }
                                     else{
                                         getMasterDataApi()
                                     }
                                 }
                             }
                          }
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

   // Get Master Data Api
    private fun getMasterDataApi() {
        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getMasterApiData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetMasterApiResponse>() {
                    override fun onSuccess(response: GetMasterApiResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetMasterApiResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            if(t.getData() != null){
                                CoroutineScope(Dispatchers.IO).launch {
                                    //getUserProfileData()
                                    masterDataDao!!.insertAll(t.getData())
                                }
                            }
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

    private fun getUserProfileData() {
        if (Utility.isNetworkConnected(context)){
            isLoading.postValue(true)
            Networking.with(context)
                .getServices()
                .getUserProfileData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetUserProfileResponse>() {
                    override fun onSuccess(response: GetUserProfileResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    override fun onNext(t: GetUserProfileResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            if(t.getData() != null){
                                t.getData()!!.getUserName()?.let { session.storeUserNameKey(it) }
                                t.getData()!!.getProfilePicture()?.let { session.storeUserProfileImageKey(it) }
                                session.storeIsFirstTimeKey(false)
                            }
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

    private fun setVerificationAdapter() {
        dashboardAdapter =  DashboardAdapter(context,verificationList, this, object : OnItemSelected<GetPendingRequestData> {
            override fun onItemSelected(t: GetPendingRequestData?, position: Int) {
                Log.e("OnItem", "OnItem$position")
                dashboardFragment.redirectToDetailScreen(verificationList[position])
            }
        })
        binding.rvDashboard.setLayoutManager(LinearLayoutManager(context))
        binding.rvDashboard.setAdapter(dashboardAdapter)
    }

}