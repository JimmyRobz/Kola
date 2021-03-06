package io.kola.diff

import android.support.v7.util.DiffUtil

open class ListDiff<in T>(private val old: List<T>, private val new: List<T>) : DiffUtil.Callback() {

    override final fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            areItemsTheSame(old[oldItemPosition], new[newItemPosition])

    override final fun getOldListSize() = old.size

    override final fun getNewListSize() = new.size

    override final fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            areContentsTheSame(old[oldItemPosition], new[newItemPosition])

    open fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem
    open fun areContentsTheSame(oldItem: T, newItem: T) = areItemsTheSame(oldItem, newItem)

    fun calculateDiff(detectMoves: Boolean = true) = DiffUtil.calculateDiff(this, detectMoves)
}