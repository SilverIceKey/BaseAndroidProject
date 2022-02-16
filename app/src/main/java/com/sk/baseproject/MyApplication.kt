package com.sk.baseproject

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.blankj.utilcode.util.Utils
import com.sk.skextension.utils.SKExtension
import com.sk.skextension.utils.crash.GlobalCrashCatch
import com.sk.skextension.utils.crash.GlobalCrashHandleCallback
import com.sk.skextension.utils.explain.Explain
import com.sk.skextension.utils.net.retrofit.RetrofitClient
import com.tencent.mmkv.MMKV
import com.sk.baseproject.constants.ServerConfig
import com.sk.baseproject.features.common.http.CommonHttp

/**
 * App启动时启动，生命周期贯穿app全局
 */
class MyApplication : MultiDexApplication() {
    companion object {
        @Explain(explainValue = "全局Context")
        lateinit var globalContext: Application
    }

    override fun onCreate() {
        super.onCreate()
        globalContext = this
        //初始化MMKV
        MMKV.initialize(this)
        //初始化工具类
        Utils.init(globalContext)
        //SKExtension初始化
        SKExtension.init(this)
        //全局异常捕捉
        GlobalCrashCatch.instance.init(this)
            .setGlobalCrashHandlerListener(object : GlobalCrashHandleCallback {
                override fun crashHandler(e: Throwable): Boolean {
                    return true
                }
            })
        //设置网络
        RetrofitClient.instance.setApplicationContext(this)
        RetrofitClient.instance.defaultConfig(ServerConfig())
        RetrofitClient.instance.updateToken = {
            CommonHttp.updateToken()
        }
    }
}