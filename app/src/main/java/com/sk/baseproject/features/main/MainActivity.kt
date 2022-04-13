package com.sk.baseproject.features.main

import android.Manifest
import android.animation.ValueAnimator
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.blankj.utilcode.util.PermissionUtils
import com.sk.baseproject.R
import com.sk.baseproject.base.BaseActivity
import com.sk.baseproject.databinding.ActivityMainBinding


/**
 * 主界面
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_main


    override fun setViewModel() {

    }

    override fun initAndLoader() {
        if (!PermissionUtils.isGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            PermissionUtils.permission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .callback(object : PermissionUtils.SimpleCallback{
                    override fun onGranted() {
//                        val image = BitmapFactory.decodeFile("/storage/emulated/0/67283229_p0.jpg")
//                        binding.image.setImageBitmap(image)
                    }

                    override fun onDenied() {

                    }

                }).request()
        }else{
//            val image = BitmapFactory.decodeFile("/storage/emulated/0/67283229_p0.jpg")
//            binding.image.setImageBitmap(image)
        }
    }
}