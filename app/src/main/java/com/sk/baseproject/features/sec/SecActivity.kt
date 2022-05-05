package com.sk.baseproject.features.sec

import com.sk.baseproject.R
import com.sk.baseproject.base.BaseActivity
import com.sk.baseproject.databinding.ActivitySecBinding

class SecActivity : BaseActivity<ActivitySecBinding>() {
    companion object {
        var secActivity: SecActivity? = null
    }

    override fun getLayoutId(): Int = R.layout.activity_sec

    override fun setViewModel() {

    }

    override fun initAndLoader() {
        secActivity = this
    }
}