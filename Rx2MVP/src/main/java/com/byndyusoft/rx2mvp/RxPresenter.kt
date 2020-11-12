package com.byndyusoft.rx2mvp

import androidx.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RxPresenter<V : MvpView>(private val disposables: CompositeDisposable) :
    MvpPresenter<V> {

    protected var view: V? = null
        private set

    @CallSuper
    override fun bindView(view: V) {
        this.view = view
    }

    @CallSuper
    override fun releaseView() {
        view = null
    }

    @CallSuper
    override fun stop() {
        disposables.dispose()
    }

    @CallSuper
    override fun pause() {
        disposables.clear()
    }

    protected fun processDisposables(vararg disposable: Disposable) {
        disposables.addAll(*disposable)
    }
}