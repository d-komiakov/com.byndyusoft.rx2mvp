package com.byndyusoft.rx2mvp

import androidx.recyclerview.widget.RecyclerView

abstract class MvpListAdapter<V, I, P>
    (private val presenter: P) : RecyclerView.Adapter<I>()
        where V : ListMvpView, I : MvpItemView, I : RecyclerView.ViewHolder, P : ListMvpPresenter<V, I> {
    override fun onBindViewHolder(holder: I, position: Int) {
        presenter.bindItemView(holder, position)
    }

    override fun getItemCount(): Int {
        return presenter.itemsCount()
    }
}