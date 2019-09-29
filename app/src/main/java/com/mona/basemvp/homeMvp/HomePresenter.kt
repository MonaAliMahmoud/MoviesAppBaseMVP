package com.mona.basemvp.homeMvp

import com.mona.basemvp.base.BasePresenter

class HomePresenter(view: HomeContract.HomeIView?, repository: HomeContract.HomeIRepository) :
    BasePresenter<HomeContract.HomeIView, HomeContract.HomeIRepository>(view, repository) {

    override fun onViewReady() {
    }
}