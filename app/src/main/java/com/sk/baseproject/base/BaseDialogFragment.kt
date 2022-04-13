package com.sk.baseproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

/**
 *
 * 弹窗基类
 * */
abstract class BaseDialogFragment<T : ViewBinding> : DialogFragment() {
    /**
     * 获取界面id
     */
    abstract fun getLayoutID(): Int

    /**
     * 获取界面ViewBinding进行绑定
     */
    abstract fun getViewBinding(layoutView: View): T

    /**
     * 界面初始化
     */
    abstract fun initView()

    lateinit var binding: T
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //背景透明化并且设置不可点击
        if (getDialog()?.getWindow() != null) {
            getDialog()?.setCanceledOnTouchOutside(false);
        }
        val view = LayoutInflater.from(context).inflate(getLayoutID(), null)
        binding = getViewBinding(view)
        initView()
        return view
    }
}