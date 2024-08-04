package com.example.mypraticeapplication.view.adapter

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.mypraticeapplication.view.base.BaseFragment

class VerificationDetailViewPagerAdapter(fragmentManager: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fragmentManager, behavior) {

    private val fragmentList: MutableList<BaseFragment> = ArrayList()
    private val fragmentTitleList: MutableList<String> = ArrayList()

    var isPagingEnabled: Boolean = true

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {
        try {
            super.restoreState(state, loader)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun addFragment(fragment: BaseFragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

}