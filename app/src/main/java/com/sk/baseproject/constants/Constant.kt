package com.sk.baseproject.constants

import android.Manifest

object Constant {
    /**
     * 加载so todo so名字修改
     */
    init {
        System.loadLibrary("smartdevicemanager")
    }

    /**
     * 存储器读写权限
     * 获取位置权限
     * WIFI状态查看权限
     */
    val resquestPermission = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_WIFI_STATE
    )

    /***
     * 服务器地址 todo 服务器地址
     */
    val SERVER_URL = ""

    /**
     * 获取加密密钥 todo 修改报名后再生成
     */
    external fun EncryptKey(): String
}