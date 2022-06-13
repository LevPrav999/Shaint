package ru.levprav.shaint.di

import org.koin.dsl.module
import ru.levprav.shaint.domain.Repository
import ru.levprav.shaint.ui.listproducts.presenter.ListProductsPresenter
import ru.levprav.shaint.ui.listproducts.presenter.ListProductsPresenterImpl

val appModule = module {
    single { provideListProductsPresenter(repository = get()) }
}

private fun provideListProductsPresenter(
        repository: Repository
): ListProductsPresenter {
    return ListProductsPresenterImpl(repository)
}
