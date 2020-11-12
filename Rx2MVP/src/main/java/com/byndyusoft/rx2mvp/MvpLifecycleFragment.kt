package com.byndyusoft.rx2mvp

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class MvpLifecycleFragment<V : MvpView, P : MvpPresenter<V>> : Fragment {

    private lateinit var mvpView: V
    protected lateinit var presenter: P
        private set

    constructor() : super()

    @ContentView
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mvpView = mvpView()
        presenter = presenter()
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        presenter.bindView(mvpView)
        presenter.start()
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        presenter.releaseView()
        presenter.pause()
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        presenter.stop()
    }

    abstract fun mvpView(): V
    abstract fun presenter(): P
}