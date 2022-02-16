package com.sk.baseproject.constants

import com.sk.skextension.utils.net.retrofit.RetrofitConfig
import com.tencent.mmkv.MMKV

/**
 * 服务器相关配置
 */
class ServerConfig : RetrofitConfig(Constant.SERVER_URL) {

    override fun defaultHeaders(): MutableMap<String, String> {
        val headers = mutableMapOf<String, String>()
//        todo 默认头部添加
//        headers.put("Authorization", MMKV.defaultMMKV().getString(MMKVConstants.TOKEN, "")!!)
        return headers
    }

    override fun defaultParams(): MutableMap<String, String> {
        val params = mutableMapOf<String, String>()
        return params
    }

    override fun isTokenShouldUpdate(): Boolean {
        return true
    }
}