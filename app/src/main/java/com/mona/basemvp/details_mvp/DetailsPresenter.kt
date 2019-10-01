package com.mona.basemvp.details_mvp

import com.mona.basemvp.base.BasePresenter
import com.mona.basemvp.pojo.Profiles

class DetailsPresenter(view: DetailsContract.DetailsIView?, repository: DetailsContract.DetailsIRepository) :
    BasePresenter<DetailsContract.DetailsIView, DetailsContract.DetailsIRepository>(view, repository){

    var popularId: Int? = null

    override fun onViewReady() {
        setPopId()
    }

    private fun setPopId() {
        repository.getPopProfiles(popularId.toString()){
            view!!.addPopularDetails(it!!)
            view!!.changeGrid()
        }
    }

    fun onItemViewClicked(prof: Profiles) {
        val imgPath = "https://image.tmdb.org/t/p/w500/"
        view!!.goToFullImageScreen(imgPath, prof)
    }

}
