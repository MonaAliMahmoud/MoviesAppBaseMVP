package com.mona.basemvp.full_image_mvp

import com.mona.basemvp.base.BasePresenter

class FullImagePresenter(view: FullImageContract.FullImageIView?,
                         repository: FullImageContract.FullImageIRepository)
    :BasePresenter<FullImageContract.FullImageIView,
                    FullImageContract.FullImageIRepository>(view, repository) {

    override fun onViewReady() {

    }

}