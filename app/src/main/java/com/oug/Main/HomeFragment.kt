package com.oug.Main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.oug.R
import com.oug.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var chatList: ArrayList<Chat> = ArrayList()
    private lateinit var pager: Pager
    private var currentPosition: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Adapter for Viewpager(Banner)
        val bannerAdapter = BannerViewpagerAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_test))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_test))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_test))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        // Indicator
        // https://wtg-study.tistory.com/87 낼 참고해서 마저
        binding.homeBannerIndicator.setViewPager(binding.homeBannerVp)
        binding.homeBannerIndicator.createIndicators(bannerAdapter.itemCount, 0)
        pager = Pager(bannerAdapter.itemCount)
        pager.start()

        // Adapter for RecyclerView(Chat01)
        chatList.apply {
            add(Chat("코드업 동아리에 어서와", "#우리학교", "#코딩 #동아리", R.drawable.bg_chat01))
            add(Chat("수강신청 망한사람 ㅜ.ㅠ", "#우리학교", "#수강신청 #학식친구", R.drawable.bg_chat02))
            add(Chat("공강 때 운동할 사람", "#우리학교", "#농구 #야구", R.drawable.bg_chat03))
        }
        val chatRVAdapter = ChatRVAdapter(chatList)
        binding.homeChat01Rv.adapter = chatRVAdapter
        binding.homeChat01Rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        return binding.root
    }
    inner class Pager(val pageSize: Int) : Thread(){
        override fun run() {
            try {
                while (true) {
                    sleep(3000)
                    currentPosition = (currentPosition + 1) % pageSize
                    (context as MainActivity).runOnUiThread {
                        binding.homeBannerVp.currentItem = currentPosition
                    }
                }
            } catch (e: InterruptedException){
                Log.d("Pager", "Pager Thread 종료")
            }


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        currentPosition = 0
        pager.interrupt()
    }
}


