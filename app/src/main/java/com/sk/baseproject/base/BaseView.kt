package com.sk.baseproject.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * view基类
 */
abstract class BaseView() {
    //日志
    lateinit var log: Logger

    //view接口
    var viewInterface: ViewInterface? = null

    init {
        setLog()
    }

    /**
     * 设置通用log
     */
    private fun setLog() {
        log = LoggerFactory.getLogger(this::class.java)
    }

    @Preview
    @Composable
    abstract fun Content()
}