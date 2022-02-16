package com.sk.baseproject.features.dialog

import android.view.View
import androidx.fragment.app.FragmentManager
import com.sk.baseproject.R
import com.sk.baseproject.base.BaseDialogFragment
import kotlinx.android.synthetic.main.dialog_common_error.view.*

/**
 * 通用错误弹窗
 */
class CommonErrorDialog : BaseDialogFragment() {
    var errMsg: String = ""
    override fun getLayoutID(): Int = R.layout.dialog_common_error

    override fun initView(view: View) {
        view.msg.text = errMsg
        view.confirm.setOnClickListener { dismiss() }
    }

    fun show(manager: FragmentManager, msg: String, tag: String?) {
        super.show(manager, tag)
        errMsg = msg
    }
}