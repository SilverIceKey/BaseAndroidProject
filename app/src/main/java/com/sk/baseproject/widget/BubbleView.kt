package com.sk.baseproject.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.*
import androidx.annotation.Nullable
import androidx.core.graphics.values
import com.sk.skextension.utils.image.MatrixUtils


/**
 * Author: GcsSloop
 *
 *
 * Created Date: 16/5/31
 *
 *
 * Copyright (C) 2016 GcsSloop.
 *
 *
 * GitHub: https://github.com/GcsSloop
 */
class BubbleView @JvmOverloads constructor(
    context: Context?,
    @Nullable attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
        private val imagePath = "/storage/emulated/0/67283229_p0.jpg"
//    private val imagePath = "/sdcard/1.jpg"
    private var mBitmapPaint: Paint
    private var mSrcBitmap: Bitmap
    private var mMatrix: Matrix? = null
    private var mScale: Float = 1f
    private var mBitmapWidth: Int = 0
    private var mBitmapHeight: Int = 0
    private val scaleGestureDetector: ScaleGestureDetector
    private var mDownX: Float = 0f
    private var mDownY: Float = 0f
    private var currentX: Float = 0f
    private var currentY: Float = 0f
    private var viewWidth: Int = 0
    private var viewHeight: Int = 0
    private var isScale = false
    private val onScaleGestureListener = object : ScaleGestureDetector.OnScaleGestureListener {
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            if (detector?.scaleFactor!! < 1f) {
                mScale -= (1 - detector.scaleFactor)
            } else if (detector.scaleFactor > 1f) {
                mScale += (detector.scaleFactor - 1)
            }
            Log.e("onScale","x:$x,y$y")
            MatrixUtils.scale(mMatrix!!,mScale)
            invalidate()
            return true
        }

        override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {
        }

    }


    //    private var mTmpBitmap:Bitmap?=null
    init {
        scaleGestureDetector = ScaleGestureDetector(context, onScaleGestureListener)
        mSrcBitmap = BitmapFactory.decodeFile(imagePath)
        mBitmapWidth = mSrcBitmap.width
        mBitmapHeight = mSrcBitmap.height
        mBitmapPaint = Paint()
        mMatrix = Matrix()
        isClickable = true
//        mTmpBitmap = Bitmap.createBitmap(mBitmapWidth,mBitmapHeight,Bitmap.Config.RGB_565)
//        Thread {
//            while (true) {
//                mMatrix.setScale(mScale, mScale)
////                mTmpBitmap = Bitmap.createBitmap(mSrcBitmap,0,0,mBitmapWidth,mBitmapHeight,mMatrix,false)
//                postInvalidateDelayed(1000 / 60)
//            }
//        }.start()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w
        viewHeight = h
    }

    override fun onDraw(canvas: Canvas?) {
//        canvas?.scale(mScale, mScale)
        canvas?.drawBitmap(mSrcBitmap!!, mMatrix!!, mBitmapPaint)
//        mTmpBitmap?.recycle()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.pointerCount!! > 1) {
            isScale = true
            scaleGestureDetector.onTouchEvent(event)
            return true
        }
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mDownX = event.x
                mDownY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                if (isScale) {
                    return true
                }
                if (event.pointerCount < 2) {
                    mMatrix?.postTranslate(event.x - mDownX, event.y - mDownY)
                    currentX += event.x - mDownX
                    currentY += event.y - mDownY
                    mDownX = event.x
                    mDownY = event.y
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP -> {
                if (event.pointerCount == 1) {
                    isScale = false
                }
            }
        }
        return true
    }

}