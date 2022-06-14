package com.sk.baseproject.utils.anim

import android.view.animation.Interpolator

/**
 * 加载动画插值器，匀速
 */
class LoadingInterpolator : Interpolator{
    override fun getInterpolation(input: Float): Float {
        return input
    }
}