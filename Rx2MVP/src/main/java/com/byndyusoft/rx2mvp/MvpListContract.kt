package com.byndyusoft.rx2mvp

interface MvpItemView

interface ListMvpView : MvpView {
    fun updateItems()
    fun updateItem(position: Int)
}

interface ListMvpPresenter<V: ListMvpView, I: MvpItemView> : MvpPresenter<V> {
    fun itemsCount(): Int
    fun bindItemView(view: I, position: Int)
}