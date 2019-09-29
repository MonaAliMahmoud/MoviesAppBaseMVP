package com.mona.basemvp.homeMvp

import android.os.Bundle
import com.mona.basemvp.R
import com.mona.basemvp.base.BaseActivity

class MainActivity : BaseActivity<HomePresenter>(), HomeContract.HomeIView {

    override val presenter: HomePresenter = HomePresenter(this, HomeRepository())

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun onViewReady(bundle: Bundle?) {
    }
}
