package com.sk.baseproject.base

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 基类公用处理模块
 */
abstract class BaseComposeActivity<T : BaseView> : AppCompatActivity(), ViewInterface {
    lateinit var log: Logger
    lateinit var view: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLog()
        view = newInstanceView()
        view.viewInterface = this
        hideNavBar()
        setContent {
            view.Content()
        }
        initAndLoader()
    }

    /**
     * 设置通用log
     */
    private fun setLog() {
        log = LoggerFactory.getLogger(this::class.java)
    }

    /**
     * 隐藏导航栏
     */
    private fun hideNavBar(){
        val _window: Window = window
        val params: WindowManager.LayoutParams = _window.getAttributes()
        params.systemUiVisibility =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE
        _window.setAttributes(params)
    }

    /**
     * 让继承的子类都实现初始化实例界面的方法
     */
    abstract fun newInstanceView(): T

    /**
     * 开始初始化类和加载相关参数
     */
    abstract fun initAndLoader()
}