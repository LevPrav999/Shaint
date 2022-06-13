package ru.levprav.shaint.data.remote

import ru.levprav.shaint.data.remote.model.ProductsResponseDTO

class RemoteDataSource(
        private val productsApi: ProductsApi
) {

    fun fetchAllProducts(onLoadListener: OnLoadListener<ProductsResponseDTO>) {
        productsApi.fetchProducts()
                .enqueue(RestCallback(object : OnLoadListener<ProductsResponseDTO> {
                    override fun onLoadSuccess(response: ProductsResponseDTO) {
                        onLoadListener.onLoadSuccess(response)
                    }

                    override fun onLoadFailure(errorMsg: String) {

                    }
                }))
    }
}