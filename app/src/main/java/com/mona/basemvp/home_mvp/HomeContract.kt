package com.mona.basemvp.home_mvp

import com.mona.basemvp.base.BaseContract
import com.mona.basemvp.pojo.PopularInfo
import com.mona.basemvp.pojo.PopularList
import io.reactivex.Single

interface HomeContract {
    interface HomeIView: BaseContract.BaseIView{
        fun addPopularList(popularInfo: List<PopularInfo>)
        fun changeList()
        fun configRecycleView(popularInfos: ArrayList<PopularInfo>)
        fun goToDetailsScreen(imgPath: String, popularInf: PopularInfo)
    }

    interface HomeIPresenter: BaseContract.BaseIPresenter

    interface HomeIRepository: BaseContract.BaseIRepository{
        fun getUrl(pageNum: Int): Single<PopularList>
        fun getSearchList(searchStr: String, pageNum: Int): Single<PopularList>
    }
}