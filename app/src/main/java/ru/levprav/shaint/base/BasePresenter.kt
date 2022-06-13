package ru.levprav.shaint.base

abstract class BasePresenter<V: BaseView>: MvpPresenter<V> {

    private var _view: V? = null
    val view get() = _view

    override fun onAttachView(view: V) {
        _view = view
    }

    override fun onDetachView() {
        _view = null
    }
}