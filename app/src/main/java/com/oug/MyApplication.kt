package com.oug

import android.app.Application
import android.content.Context
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility

public class MyApplication : Application() {
    companion object {
        var appContext : Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        var keyHash = Utility.getKeyHash(this)
        appContext = this
        KakaoSdk.init(this, "{NATIVE_APP_KEY}")
    }
}