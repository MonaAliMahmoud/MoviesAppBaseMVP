package com.mona.basemvp.details_mvp

import android.os.Bundle
import com.mona.basemvp.base.BaseActivity

class DetailsActivity: BaseActivity<DetailsPresenter>(), DetailsContract.DetailsIView {
    override val presenter: DetailsPresenter
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun getLayoutResourceId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onViewReady(bundle: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}