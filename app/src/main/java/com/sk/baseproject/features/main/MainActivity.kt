package com.sk.baseproject.features.main

import android.Manifest
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.PermissionUtils
import com.sk.baseproject.R
import com.sk.baseproject.base.BaseActivity
import com.sk.baseproject.databinding.ActivityMainBinding
import com.sk.baseproject.features.sec.SecActivity
import com.sk.skextension.utils.media.AudioHelper
import kotlin.concurrent.thread


/**
 * 主界面
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {
    var secActivity: SecActivity? = null
    var isPermissionGranted = false
    override fun getLayoutId(): Int = R.layout.activity_main


    override fun setViewModel() {

    }

    override fun initAndLoader() {
        if (!PermissionUtils.isGranted(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
            )
        ) {
            PermissionUtils.permission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
            )
                .callback(object : PermissionUtils.SimpleCallback {
                    override fun onGranted() {
//                        val image = BitmapFactory.decodeFile("/storage/emulated/0/67283229_p0.jpg")
//                        binding.image.setImageBitmap(image)
                        isPermissionGranted = true
                    }

                    override fun onDenied() {

                    }

                }).request()
        } else {
            isPermissionGranted = true
//            val image = BitmapFactory.decodeFile("/storage/emulated/0/67283229_p0.jpg")
//            binding.image.setImageBitmap(image)
        }
    }
}