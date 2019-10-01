package com.mona.basemvp.full_image_mvp

import com.mona.basemvp.base.BaseContract

interface FullImageContract {
    interface FullImageIView: BaseContract.BaseIView{
        fun saveImageToGallery()
    }

    interface FullImageIPresenter: BaseContract.BaseIPresenter{

    }

    interface FullImageIRepository: BaseContract.BaseIRepository{
        fun setPicturePath(picturePath: String)
    }
}