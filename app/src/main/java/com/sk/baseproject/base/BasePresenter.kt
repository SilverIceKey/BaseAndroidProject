package com.sk.baseproject.base

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 业务层基类
 */
open class BasePresenter {
    var log: Logger

    init {
        //初始化日志工具
        log = LoggerFactory.getLogger(this::class.java)
    }
}