package com.sk.baseproject.features.common.bean

/**
 * 定位数据类
 */
class LocationBean {
    /**
     * 纬度
     */
    var lat: Double = 0.0

    /**
     * 经度
     * */
    var lon: Double = 0.0

    /**
     * 当前位置名称
     */
    var geoName: String = ""

    /**
     * 当前位置详细
     */
    var address: String = ""
}