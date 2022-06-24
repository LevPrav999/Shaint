package ru.levprav.shaint.ui.details.presenter

import ru.levprav.shaint.base.BasePresenter
import ru.levprav.shaint.domain.Repository
import ru.levprav.shaint.ui.details.view.DetailsView

class DetailsPresenterImpl(
    private val repository: Repository
) : BasePresenter<DetailsView>(), DetailsPresenter {

    override fun viewIsReady() {

    }

    override fun getProductById(id: Int) {
        view?.showProductDetails(repository.getProductById(id))
    }
}