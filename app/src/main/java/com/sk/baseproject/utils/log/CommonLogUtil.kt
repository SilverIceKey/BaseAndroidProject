package com.sk.baseproject.utils.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object CommonLogUtil {
    var log: Logger
    init {
        log = LoggerFactory.getLogger(this::class.java)
    }
}