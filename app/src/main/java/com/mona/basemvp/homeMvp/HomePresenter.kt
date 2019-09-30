package com.mona.basemvp.homeMvp

import com.mona.basemvp.base.BasePresenter

class HomePresenter(view: HomeContract.HomeIView?, repository: HomeContract.HomeIRepository) :
    BasePresenter<HomeContract.HomeIView, HomeContract.HomeIRepository>(view, repository) {

    private var page = "1"

    override fun onViewReady() {
        callJson()
    }

    fun callJson() {
        view!!.showLoading()
        repository.getUrl(page){
            view!!.hideLoading()
            view!!.addPopularList(it!!)
            view!!.changeList()
        }
    }
}