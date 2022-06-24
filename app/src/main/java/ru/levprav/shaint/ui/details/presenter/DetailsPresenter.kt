package ru.levprav.shaint.ui.details.presenter

import ru.levprav.shaint.base.MvpPresenter
import ru.levprav.shaint.ui.details.view.DetailsView

interface DetailsPresenter : MvpPresenter<DetailsView> {

    fun getProductById(id: Int)
}