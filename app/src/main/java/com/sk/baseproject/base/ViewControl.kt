package com.sk.baseproject.base

import android.content.Context
import android.os.Bundle
import android.os.Message
import android.view.View
import org.slf4j.Logger

/**
 * activity下单独界面控制
 */
abstract class ViewControl(val context: Context, val view: View) {
    /**
     * 日志输出
     */
    lateinit var log: Logger
    /**
     * 是否显示
     */
    var isShow: Boolean = false

    /**
     * 当前viewControl标签
     */
    val TAG: String = this::class.java.name

    /**
     * 启动
     */
    fun onCreate() {
        log = (context as BaseActivity).log
        initView()
        dataLoader()
    }

    /**
     * 返回
     */
    fun onResume() {

    }

    /**
     * 暂停
     */
    fun onStop() {

    }

    /**
     * 销毁
     */
    fun onDestory() {

    }

    /**
     * 显示通用错误弹窗
     */
    fun showCommonErrorDialog(msg: String) {
        (context as BaseActivity).showCommonErrorDialog(msg = msg)
    }

    /**
     * 变换配置
     */
    fun changePage(showPage: String) {
        (context as BaseActivity).changePage(TAG, showPage)
    }

    /**
     * 发送消息到服务
     */
    fun sendMessage(messageBundle: Bundle) {
        (context as BaseActivity).sendMessage(messageBundle)
    }

    /**
     * 处理来自服务的消息只有显示的界面会收到消息
     */
    fun handleMessageFromService(msg: Message) {

    }

    /**
     * 初始化
     */
    abstract fun initView()

    /**
     * 加载数据
     */
    abstract fun dataLoader()

    /**
     * 显示界面
     */
    open fun show() {
        isShow = true
    }

    /**
     * 隐藏界面
     */
    open fun hide() {
        isShow = false
    }
}