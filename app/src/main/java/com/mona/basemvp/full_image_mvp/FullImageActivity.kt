package com.mona.basemvp.full_image_mvp

import android.os.Bundle
import com.mona.basemvp.R
import com.mona.basemvp.base.BaseActivity

class FullImageActivity: BaseActivity<FullImagePresenter>(), FullImageContract.FullImageIView {

    override val presenter: FullImagePresenter = FullImagePresenter(this, FullImageRepository())

    override fun getLayoutResourceId(): Int = R.layout.activity_full_image

    override fun onViewReady(bundle: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}