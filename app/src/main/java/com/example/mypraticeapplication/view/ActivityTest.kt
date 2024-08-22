package com.example.mypraticeapplication.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.TestActivityBinding
import com.example.mypraticeapplication.view.adapter.CustomArrayAdapter
import com.example.mypraticeapplication.view.base.BaseActivity


class ActivityTest: BaseActivity()  {

    private lateinit var binding: TestActivityBinding

    private var houseLocalitySpinnerAdapter: ArrayAdapter<String?>? = null
    private var houseLocalityList: List<String>? = null

    @SuppressLint("DiscouragedPrivateApi", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TestActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val materialStatusList =  resources.getStringArray(R.array.material_status)
        houseLocalityList = materialStatusList.asList()

        binding.tvAddressConfirmed.setListAdapter(houseLocalityList)
    }


}