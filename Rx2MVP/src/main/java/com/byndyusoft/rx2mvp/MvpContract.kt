package com.byndyusoft.rx2mvp

interface MvpView

interface MvpPresenter<V: MvpView> {
    fun bindView(view: V)
    fun releaseView()
    fun start()
    fun stop()
    fun pause()
}