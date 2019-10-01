package com.mona.basemvp.details_mvp

import com.mona.basemvp.base.BaseContract
import com.mona.basemvp.pojo.Profiles
import java.util.ArrayList

interface DetailsContract {
    interface DetailsIView: BaseContract.BaseIView{
        fun configGridRecycleView(profiles: ArrayList<Profiles>)
        fun changeGrid()
        fun addPopularDetails(profiles: Profiles)
        fun goToFullImageScreen(imgPath: String, prof: Profiles)
    }

    interface DetailsIPresenter: BaseContract.BaseIPresenter{

    }

    interface DetailsIRepository: BaseContract.BaseIRepository{
        fun getPopProfiles(popularId: String, loadProfile: (profile: Profiles?)-> Unit)
    }
}