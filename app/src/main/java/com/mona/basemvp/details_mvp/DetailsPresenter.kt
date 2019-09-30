package com.mona.basemvp.details_mvp

import com.mona.basemvp.base.BasePresenter

class DetailsPresenter(view: DetailsContract.DetailsIView?, repository: DetailsContract.DetailsIRepository) :
    BasePresenter<DetailsContract.DetailsIView, DetailsContract.DetailsIRepository>(view, repository){

    override fun onViewReady() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
