package ru.levprav.shaint.data.remote

import retrofit2.Call
import retrofit2.http.GET
import ru.levprav.shaint.data.remote.model.ProductsResponseDTO

interface ProductsApi {
    @GET("products.json")
    fun fetchProducts(): Call<ProductsResponseDTO>
}