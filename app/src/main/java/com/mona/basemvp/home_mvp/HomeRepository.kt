package com.mona.basemvp.home_mvp

import com.mona.basemvp.base.BaseRepository
import com.mona.basemvp.pojo.PopularList
import io.reactivex.Single

class HomeRepository: BaseRepository(), HomeContract.HomeIRepository {

    override fun getUrl(pageNum: Int): Single<PopularList> {
        return remoteDataSource.service.getPopularData(pageNum)
    }

    override fun getSearchList(searchStr: String, pageNum: Int): Single<PopularList> {
        return remoteDataSource.service.searching(searchStr, pageNum)
    }
}