package com.example.mypraticeapplication.view

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mypraticeapplication.databinding.TestActivityBinding
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


        val materialStatusList =  resources.getStringArray(com.example.mypraticeapplication.R.array.material_status)
        houseLocalityList = materialStatusList.asList()

        houseLocalitySpinnerAdapter = object : ArrayAdapter<String?>(
            this,
            R.layout.simple_spinner_item, houseLocalityList!!
        ) {
            override fun getDropDownView(
                position: Int,
                convertView: View,
                parent: ViewGroup
            ): View {
                var v: View? = null
                if (position == 0) {
                    val tv = TextView(context)
                    tv.setHeight(0)
                    tv.visibility = View.GONE
                    v = tv
                } else {
                    v = super.getDropDownView(position, null, parent)
                }
                parent.isVerticalScrollBarEnabled = false
                return v!!
            }
        }


        binding.tvAddressConfirmed.setAdapter(houseLocalitySpinnerAdapter)
      //  binding.spFinalSubmission.adapter = houseLocalitySpinnerAdapter
    }


}