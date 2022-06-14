package com.sk.baseproject.utils.anim

import android.animation.ValueAnimator
import android.view.View

/**
 * 旋转加载动画
 */
class LoadingValueAnimator(
    rotateLoadingView: View,
    startAngel: Float = 0f,
    EndAngel: Float = 360f
) {
    private var valueAnimator: ValueAnimator

    init {
        valueAnimator = ValueAnimator.ofFloat(startAngel, EndAngel)
        valueAnimator.duration = 2000
        valueAnimator.repeatCount = -1
        valueAnimator.interpolator = LoadingInterpolator()
        valueAnimator.addUpdateListener {
            rotateLoadingView.rotation = it.animatedValue as Float
        }
    }

    /**
     * 设置执行时间
     */
    fun setDuration(duration: Long): LoadingValueAnimator {
        valueAnimator.duration = duration
        return this
    }

    /**
     * 是否无限
     */
    fun isInfinite(isInfinite: Boolean): LoadingValueAnimator {
        if (isInfinite) {
            valueAnimator.repeatCount = -1
        } else {
            valueAnimator.repeatCount = 0
        }
        return this
    }

    /**
     * 开始
     */
    fun start() {
        valueAnimator.start()
    }

    /**
     * 结束
     */
    fun end() {
        valueAnimator.end()
    }

    /**
     * 取消
     */
    fun cancel() {
        valueAnimator.cancel()
    }

    /**
     * 暂停
     */
    fun pause() {
        valueAnimator.pause()
    }

    /**
     * 恢复
     */
    fun resume() {
        valueAnimator.resume()
    }
}