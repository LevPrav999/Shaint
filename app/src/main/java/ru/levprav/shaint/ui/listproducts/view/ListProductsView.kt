package ru.levprav.shaint.ui.listproducts.view

import ru.levprav.shaint.base.BaseView
import ru.levprav.shaint.ui.listproducts.view.adapter.RecyclerViewItem

interface ListProductsView : BaseView {
    fun showPopularProducts(products: List<RecyclerViewItem>)
    fun showYourProducts(products: List<RecyclerViewItem>)
}