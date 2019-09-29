package com.example.basemvp.homeMvp

import android.os.Bundle
import com.example.basemvp.R
import com.example.basemvp.base.BaseActivity

class MainActivity : BaseActivity<HomePresenter>(), HomeContract.HomeIView {

    override val presenter: HomePresenter = HomePresenter(this, HomeRepository())

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun onViewReady(bundle: Bundle?) {
    }
}
