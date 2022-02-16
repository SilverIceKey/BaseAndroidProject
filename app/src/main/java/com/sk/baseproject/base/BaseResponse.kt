package com.sk.baseproject.base

/**
 * 基础返回数据类型
 */
open class BaseResponse<T> {
    var errcode: Int = -1
    var errmsg: String = ""
    var data: T? = null
}