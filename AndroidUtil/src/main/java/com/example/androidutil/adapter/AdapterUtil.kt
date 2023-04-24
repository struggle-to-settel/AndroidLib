package com.example.androidutil.adapter

internal interface AdapterUtil<T> {

    fun add(items: List<T>)

    fun add(item: T, position: Int)

    fun set(items: List<T>)

    fun get(position: Int): T?

}