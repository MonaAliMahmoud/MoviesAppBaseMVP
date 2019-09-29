package com.example.basemvp.homeMvp

import com.example.basemvp.base.BasePresenter

class HomePresenter(view: HomeContract.HomeIView?, repository: HomeContract.HomeIRepository) :
    BasePresenter<HomeContract.HomeIView, HomeContract.HomeIRepository>(view, repository) {

    override fun onViewReady() {
    }
}