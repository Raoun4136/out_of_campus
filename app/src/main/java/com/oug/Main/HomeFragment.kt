package com.oug.Main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.oug.R
import com.oug.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Adapter for Viewpager(Banner)
        val bannerAdapter = BannerViewpagerAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_test))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_test2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_test3))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        // Indicator
        // https://wtg-study.tistory.com/87 낼 참고해서 마저
        binding.homeBannerIndicator.setViewPager(binding.homeBannerVp)
        binding.homeBannerIndicator.createIndicators(bannerAdapter.itemCount, 0)
        return binding.root
    }
}


