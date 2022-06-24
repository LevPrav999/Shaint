package ru.levprav.shaint.ui.details.view

import ru.levprav.shaint.base.BaseView
import ru.levprav.shaint.domain.model.Product

interface DetailsView : BaseView {

    fun showProductDetails(product: Product)
}