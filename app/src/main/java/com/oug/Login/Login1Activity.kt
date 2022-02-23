package com.oug.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oug.R
import com.oug.databinding.ActivityLogin1Binding

class Login1Activity : AppCompatActivity() {
    lateinit var binding: ActivityLogin1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login1)


    }
}