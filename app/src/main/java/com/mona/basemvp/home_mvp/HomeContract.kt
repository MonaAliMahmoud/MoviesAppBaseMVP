package com.mona.basemvp.home_mvp

import com.mona.basemvp.base.BaseContract
import com.mona.basemvp.pojo.PopularInfo
import java.util.ArrayList

interface HomeContract {
    interface HomeIView: BaseContract.BaseIView{
        fun addPopularList(popularInfo: PopularInfo)
        fun changeList()
        fun configRecycleView(popularInfos: ArrayList<PopularInfo>)
        fun goToDetailsScreen(imgPath: String, popularInf: PopularInfo)
    }

    interface HomeIPresenter: BaseContract.BaseIPresenter{

    }

    interface HomeIRepository: BaseContract.BaseIRepository{
        fun getUrl(pageNum: Int, loadData: (popularInfo: PopularInfo?) -> Unit)
        fun getSearchList(searchStr: String, pageNum: Int, loadData: (popularInfo: PopularInfo?) -> Unit)
    }
}