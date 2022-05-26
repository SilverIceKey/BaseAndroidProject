package com.sk.baseproject.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.sk.skextension.utils.image.PathHelper

class DemoView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var pathPaint:Paint?=null
    init {
        pathPaint = Paint()
        pathPaint?.isAntiAlias = true
        pathPaint?.strokeWidth = 2f
        pathPaint?.color = Color.BLACK
        pathPaint?.style = Paint.Style.STROKE
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}