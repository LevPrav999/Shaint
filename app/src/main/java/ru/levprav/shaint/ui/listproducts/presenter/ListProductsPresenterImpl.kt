package ru.levprav.shaint.ui.listproducts.presenter

import ru.levprav.shaint.domain.Repository
import ru.levprav.shaint.ui.listproducts.presenter.ListProductsPresenter
import ru.levprav.shaint.ui.listproducts.view.ListProductsView

class ListProductsPresenterImpl(
        private val repository: Repository
) : ListProductsPresenter {
    override fun viewIsReady() {
        fetchPopularProducts()
        fetchYourPopularProducts()
    }

    override fun onAttachView(view: ListProductsView) {}
    override fun onDetachView() {}
    override fun fetchPopularProducts() {}
    override fun fetchYourPopularProducts() {}
}