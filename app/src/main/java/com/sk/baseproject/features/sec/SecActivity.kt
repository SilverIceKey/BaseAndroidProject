package com.sk.baseproject.features.sec

import com.sk.baseproject.R
import com.sk.baseproject.base.BaseActivity
import com.sk.baseproject.base.BaseViewModel
import com.sk.baseproject.databinding.ActivitySecBinding

class SecActivity : BaseActivity<ActivitySecBinding,BaseViewModel>() {
    companion object {
        var secActivity: SecActivity? = null
    }

    override fun getLayoutId(): Int = R.layout.activity_sec

    override fun getViewModel(): Class<BaseViewModel> {
        return BaseViewModel::class.java
    }

    override fun initAndLoader() {
        secActivity = this
    }
}