package com.mona.basemvp.details_mvp

import com.mona.basemvp.base.BaseContract
import com.mona.basemvp.pojo.Profiles

interface DetailsContract {
    interface DetailsIView: BaseContract.BaseIView{

    }

    interface DetailsIPresenter: BaseContract.BaseIPresenter{

    }

    interface DetailsIRepository: BaseContract.BaseIRepository{
        fun getPopProfiles(popularId: String, loadProfile: (profile: Profiles?)-> Unit)
    }
}