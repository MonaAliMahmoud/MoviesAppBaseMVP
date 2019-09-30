package com.mona.basemvp.details_mvp

import android.os.Bundle
import com.mona.basemvp.R
import com.mona.basemvp.base.BaseActivity

class DetailsActivity: BaseActivity<DetailsPresenter>(), DetailsContract.DetailsIView {

    override val presenter: DetailsPresenter = DetailsPresenter(this, DetailsRepository())

    override fun getLayoutResourceId(): Int = R.layout.activity_details

    override fun onViewReady(bundle: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}