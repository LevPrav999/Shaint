package ru.levprav.shaint.ui.listproducts.presenter

import ru.levprav.shaint.base.MvpPresenter
import ru.levprav.shaint.ui.listproducts.view.ListProductsView

interface ListProductsPresenter : MvpPresenter<ListProductsView> {
    fun fetchPopularProducts()
    fun fetchYourPopularProducts()

    fun getProductsByCategory(category: String)
}