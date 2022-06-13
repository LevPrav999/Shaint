package ru.levprav.shaint.ui.listproducts.view

import ru.levprav.shaint.base.BaseView
import ru.levprav.shaint.domain.model.Product

interface ListProductsView : BaseView {
    fun showProducts(products: List<Product?>?)
}