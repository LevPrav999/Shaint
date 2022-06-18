package ru.levprav.shaint.ui.listproducts.presenter

import android.util.Log
import ru.levprav.shaint.base.BasePresenter
import ru.levprav.shaint.data.remote.OnLoadListener
import ru.levprav.shaint.domain.Repository
import ru.levprav.shaint.domain.model.Product
import ru.levprav.shaint.ui.listproducts.presenter.ListProductsPresenter
import ru.levprav.shaint.ui.listproducts.view.ListProductsView
import ru.levprav.shaint.ui.listproducts.view.adapter.RecyclerViewItem

class ListProductsPresenterImpl(
        private val repository: Repository
) : BasePresenter<ListProductsView>(), ListProductsPresenter {
    override fun viewIsReady() {
        fetchPopularProducts()
        fetchYourPopularProducts()
    }

    override fun onAttachView(view: ListProductsView) {}
    override fun onDetachView() {}

    override fun fetchPopularProducts() {
        repository.getAllProducts(object : OnLoadListener<List<Product>> {
            override fun onLoadSuccess(response: List<Product>) {
                showProducts(response)
            }

            override fun onLoadFailure(errorMsg: String) {}
        })
    }

    override fun fetchYourPopularProducts() {
        showProducts(repository.getYourPopularProducts())
    }


    private fun showProducts(movies: List<Product>) {
        val recyclerViewItems = mutableListOf<RecyclerViewItem>()
        recyclerViewItems.add(RecyclerViewItem.Name("Категории"))
        recyclerViewItems.addAll(repository.getCategories().map {
            it.toRecyclerViewItem()
        })
        recyclerViewItems.add(RecyclerViewItem.Name("Продукты"))
        recyclerViewItems.addAll(movies.map {
            it.toRecyclerViewItem()
        })
        view?.showProducts(recyclerViewItems)
    }

    private fun String.toRecyclerViewItem() = RecyclerViewItem.Category(
        title = this
    )

    private fun Product.toRecyclerViewItem() = RecyclerViewItem.Product(
        this.id!!,
        this.name,
        this.details,
        this.imageUri,
        this.categories
    )
}
