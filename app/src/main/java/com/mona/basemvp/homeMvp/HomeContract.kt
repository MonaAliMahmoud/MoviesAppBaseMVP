package com.mona.basemvp.homeMvp

import com.mona.basemvp.base.BaseContract
import com.mona.basemvp.pojo.PopularInfo

interface HomeContract {
    interface HomeIView: BaseContract.BaseIView{
        fun addPopularList(popularInfo: PopularInfo)
    }

    interface HomeIPresenter: BaseContract.BaseIPresenter{

    }

    interface HomeIRepository: BaseContract.BaseIRepository{

    }
}