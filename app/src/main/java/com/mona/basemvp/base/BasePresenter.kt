package com.mona.basemvp.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

abstract class BasePresenter <View: BaseContract.BaseIView,
        Repository: BaseContract.BaseIRepository>(
    var view:View?,
    val repository: Repository
) :BaseContract.BaseIPresenter {

    var compositeDisposable = CompositeDisposable()

    abstract override fun onViewReady()

    override fun onViewDestroy(){
        view = null
        compositeDisposable.clear()
    }

    fun <T>subscribe(
        observable: Observable<T>,
        success: Consumer<T>,
        error: Consumer<Throwable> = Consumer {  })
    {
        compositeDisposable.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                        view?.showLoading()
                }
                .doAfterTerminate {
                        view?.hideLoading()
                }
                .subscribe(success, Consumer {

                })
        )
    }
}