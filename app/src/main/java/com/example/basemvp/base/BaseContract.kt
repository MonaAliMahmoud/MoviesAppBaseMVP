package com.example.basemvp.base

import android.os.Bundle
import androidx.annotation.LayoutRes

interface BaseContract {
    interface BaseIView{

        fun onViewReady(bundle: Bundle?)
        fun showLoading()
        fun hideLoading()
        fun showError(error: Int)
        fun hideError(error: Int)
        fun showError(error: String)
        fun hideError(error: String)
        @LayoutRes
        fun getLayoutResourceId(): Int
    }

    interface BaseIPresenter{
        fun onViewReady()
        fun onViewDestroy()
    }

    interface BaseIRepository{

    }
}