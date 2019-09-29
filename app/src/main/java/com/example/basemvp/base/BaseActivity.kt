package com.example.basemvp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<Presenter: BasePresenter<*, *>>: AppCompatActivity(), BaseContract.BaseIView {

    abstract val presenter: Presenter
    @LayoutRes
    abstract override fun getLayoutResourceId(): Int
    abstract override fun onViewReady(bundle: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())
//        implementation

        onViewReady(savedInstanceState)

        presenter.onViewReady()
    }

    override fun showLoading(){
        TODO()
    }

    override fun hideLoading(){
        TODO()
    }

    override fun showError(@StringRes error: Int){
        TODO()
    }

    override fun hideError(@StringRes error: Int){
        TODO()
    }

    override fun showError(@NonNull error: String){
        TODO()
    }

    override fun hideError(@NonNull error: String){
        TODO()
    }

}