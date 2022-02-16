package com.sk.baseproject.constants

import com.sk.skextension.utils.net.mqtt.EMQXConfig
import com.sk.skextension.utils.net.mqtt.EMQXHelper
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence

/**
 * mqtt 相关配置
 */
class MQTTConfig : EMQXConfig("", "") {
    override var username: String
        get() = "test1"
        set(value) {}
    override var password: String
        get() = "test1"
        set(value) {}

    override fun qos(): Int = 1
    override fun getMemoryPersistence(): MemoryPersistence {
        return MemoryPersistence()
    }

    override fun getMqttConnectOptions(): MqttConnectOptions {
        val mqttConnectOptions = MqttConnectOptions()
        mqttConnectOptions.userName = username
        mqttConnectOptions.password = password.toCharArray()
        mqttConnectOptions.isCleanSession = false
        return mqttConnectOptions
    }

    override fun getMqttCallback(): EMQXHelper.EMQXCallback {
        return object : EMQXHelper.EMQXCallback {
            override fun connectionLost(cause: Throwable?) {

            }

            override fun messageArrived(topic: String?, message: MqttMessage?) {

            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {

            }

        }
    }


}