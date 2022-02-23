package com.oug.Main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder

class BannerViewpagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val bannerList : ArrayList<Fragment> = ArrayList()

    override fun getItemCount() = bannerList.size

    override fun createFragment(position: Int): Fragment = bannerList[position]

    fun addFragment(fragment: Fragment){
        bannerList.add(fragment)
        // bannerList에 fragment 추가한 것 연동 (n번째 fragment -> n-1 index)
        notifyItemInserted(bannerList.size - 1)
    }
}