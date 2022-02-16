package com.sk.baseproject.utils.location

import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.sk.baseproject.features.common.bean.LocationBean
import com.sk.baseproject.MyApplication

/**
 * 定位工具
 */
object LocationUtils {
    /**
     * 定位客户端
     */
    private var locationClient: LocationClient? = null

    /**
     * 定位监听
     */
    private val locationListener = LocationListener()

    /**
     * 定位完成回调
     */
    private var onLocated: (LocationBean) -> Unit = {}

    private fun initClient() {
        val option = LocationClientOption()
        option.setIsNeedAddress(true)
        option.setNeedNewVersionRgc(true)
        option.setIsNeedLocationDescribe(true)
        locationClient = LocationClient(MyApplication.globalContext, option)
        locationClient?.registerLocationListener(locationListener)
    }

    /**
     * 开始定位
     */
    fun startLocal(onLocated: (LocationBean) -> Unit) {
        if (locationClient == null) {
            initClient()
        }
        this.onLocated = onLocated
        locationClient?.start()
    }

    class LocationListener : BDAbstractLocationListener() {
        override fun onReceiveLocation(bdLocation: BDLocation?) {
            locationClient?.stop()
            val locationBean = LocationBean()
            locationBean.lat = bdLocation?.latitude!!
            locationBean.lon = bdLocation.longitude
            locationBean.geoName = bdLocation.locationDescribe.replace("在","").replace("附近","")
            locationBean.address = bdLocation.addrStr+bdLocation.locationDescribe.replace("在","").replace("附近","")
            onLocated(locationBean)
        }
    }
}