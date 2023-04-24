package com.example.androidutil.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>(), AdapterUtil<T> {

    private val itemList = mutableListOf<T?>()


    override fun getItemCount() = itemList.count()


    override fun add(items: List<T>) {
        val count = itemList.count()
        itemList.addAll(items)
        notifyItemRangeInserted(count, items.count())
    }

    override fun add(item: T, position: Int) {
        itemList.add(position, item)
        notifyItemInserted(position)
    }

    override fun set(items: List<T>) {
        val count = itemList.count()
        itemList.clear()
        notifyItemRangeRemoved(0, count)
        itemList.addAll(items)
        notifyItemRangeChanged(0, items.count())
    }

    override fun get(position: Int): T? {
        return itemList[position]
    }


}