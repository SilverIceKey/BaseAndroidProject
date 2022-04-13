package com.sk.baseproject.constants

import retrofit2.Call
import retrofit2.http.GET

/**
 * 接口
 */
interface Api {
    @GET("/")
    fun get1():Call<String>
}