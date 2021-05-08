package com.raywenderlich.android.rwandroidtutorial

interface BasePresenter<T> {
    fun onDestroy()
    fun setView(view: T)
}