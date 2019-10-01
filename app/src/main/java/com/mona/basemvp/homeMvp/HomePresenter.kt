package com.mona.basemvp.homeMvp

import com.mona.basemvp.base.BasePresenter
import com.mona.basemvp.pojo.PopularInfo

class HomePresenter(view: HomeContract.HomeIView?, repository: HomeContract.HomeIRepository) :
    BasePresenter<HomeContract.HomeIView, HomeContract.HomeIRepository>(view, repository) {

    private var page = 1

    override fun onViewReady() {
        callJson()
    }

    private fun callJson() {
        view!!.showLoading()
        repository.getUrl(page){
            view!!.hideLoading()
            view!!.addPopularList(it!!)
            view!!.changeList()
        }
    }

    fun loadNextPage(){
        page++
        callJson()
    }

    fun refresh(popularInfos: ArrayList<PopularInfo>){
        popularInfos.clear()
        page = 1
        callJson()
    }

    fun onItemViewClicked(popularInf: PopularInfo) {
        val imgPath = "https://image.tmdb.org/t/p/w500/"
        view!!.goToDetailsScreen(imgPath, popularInf)
    }
}