package ru.levprav.shaint.domain

import ru.levprav.shaint.data.remote.OnLoadListener
import ru.levprav.shaint.domain.model.Product

interface Repository {
    fun getAllProducts(onLoadListener: OnLoadListener<List<Product>>)
    fun getProductById(id: Int): Product
    fun getProductsByCategory(category: String): List<Product>
    fun getCategories(): List<String>

    fun getYourPopularProducts(): List<Product>
}