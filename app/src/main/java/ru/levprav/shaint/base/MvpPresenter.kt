package ru.levprav.shaint.base

interface MvpPresenter<V: BaseView> {

    fun viewIsReady()

    fun onAttachView(view: V)

    fun onDetachView()
}