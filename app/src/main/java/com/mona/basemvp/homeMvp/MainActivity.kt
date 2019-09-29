package com.mona.basemvp.homeMvp

import android.os.Bundle
import com.mona.basemvp.R
import com.mona.basemvp.base.BaseActivity
import com.mona.basemvp.pojo.PopularInfo
import java.util.ArrayList

class MainActivity : BaseActivity<HomePresenter>(), HomeContract.HomeIView {

    private var popularInfos = ArrayList<PopularInfo>()

    override val presenter: HomePresenter = HomePresenter(this, HomeRepository())

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun onViewReady(bundle: Bundle?) {
    }

    override fun addPopularList(popularInfo: PopularInfo) {
        popularInfos.add(popularInfo)
    }
}
