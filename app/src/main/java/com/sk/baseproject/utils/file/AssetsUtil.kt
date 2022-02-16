package com.sk.baseproject.utils.file

import com.blankj.utilcode.util.FileIOUtils
import com.sk.baseproject.MyApplication
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * assets相关公爵
 */
object AssetsUtil {
    /**
     * 根据路径从assets中获取文件数据
     */
    fun getAssetsData(path: String):String {
        val assetsManager = MyApplication.globalContext.assets
        val openIS = assetsManager.open(path)
        val stringBuffer = StringBuffer()
        var isr:InputStreamReader?=null
        var br:BufferedReader?=null
        try {
            isr = InputStreamReader(openIS)
            br = BufferedReader(isr)
            stringBuffer.append(br.readLine())
            var line: String? = null
            while (br.readLine().also { line = it } != null) {
                stringBuffer.append("${line}")
            }
            br.close()
            isr.close()
            openIS.close()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                br?.close()
                isr?.close()
                openIS.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return stringBuffer.toString()
    }
}