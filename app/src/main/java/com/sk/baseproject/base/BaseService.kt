package com.sk.baseproject.base

import android.app.Service
import android.content.Intent
import android.os.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * service基类
 */
abstract class BaseService : Service() {
    lateinit var log: Logger
    var replyTo: Messenger? = null
    override fun onBind(intent: Intent?): IBinder? {
        return messenger.binder
    }

    override fun onCreate() {
        super.onCreate()
        setLog()
    }


    protected val messenger: Messenger = Messenger(object : Handler(Looper.myLooper()!!) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            replyTo = msg.replyTo
            handleMessageFromClient(msg = msg)
        }
    })


    /**
     * 设置通用log
     */
    private fun setLog() {
        log = LoggerFactory.getLogger(this::class.java)
    }

    /**
     * 发送消息到客户端
     */
    fun sendMessage(messageBundle: Bundle) {
        val message = Message()
        message.data = messageBundle
        replyTo?.send(message)
    }

    /**
     * 开始初始化类和加载相关参数
     */
    abstract fun initAndLoader()

    /**
     * 消息处理
     */
    abstract fun handleMessageFromClient(msg: Message)
}