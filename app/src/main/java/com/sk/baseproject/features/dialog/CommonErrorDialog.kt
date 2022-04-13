package com.sk.baseproject.features.dialog

import android.view.View
import androidx.fragment.app.FragmentManager
import com.sk.baseproject.R
import com.sk.baseproject.base.BaseDialogFragment
import com.sk.baseproject.databinding.DialogCommonErrorBinding

/**
 * 通用错误弹窗
 */
class CommonErrorDialog : BaseDialogFragment<DialogCommonErrorBinding>() {
    var errMsg: String = ""
    override fun getLayoutID(): Int = R.layout.dialog_common_error

    override fun initView() {
        binding.msg.text = errMsg
        binding.confirm.setOnClickListener { dismiss() }
    }

    fun show(manager: FragmentManager, msg: String, tag: String?) {
        super.show(manager, tag)
        errMsg = msg
    }

    override fun getViewBinding(layoutView: View): DialogCommonErrorBinding {
        return DialogCommonErrorBinding.bind(layoutView)
    }
}