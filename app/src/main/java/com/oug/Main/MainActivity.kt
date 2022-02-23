package com.oug.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kakao.sdk.common.util.Utility
import com.oug.R
import com.oug.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_CamManChu)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottom()

        binding.mainBnv.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homeFragment -> {
                   supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.friendFragment ->{
                }
                R.id.menuFragment ->{

                }
            }
            false
        }
    }

    private fun initBottom(){
        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()
    }
}