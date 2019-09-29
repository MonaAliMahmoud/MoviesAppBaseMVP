package com.example.basemvp.base

import com.example.basemvp.homeMvp.HomeContract

abstract class BasePresenter <View: BaseContract.BaseIView,
        Repository: BaseContract.BaseIRepository>(
    var view:View?,
    val repository: HomeContract.HomeIRepository
) :BaseContract.BaseIPresenter {

    abstract override fun onViewReady()

    override fun onViewDestroy(){
        view = null
    }

}