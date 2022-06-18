package ru.levprav.shaint.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.levprav.shaint.data.local.model.ProductEntity

@Dao
interface ProductDao {
    @get:Query("SELECT * FROM products")
    val allProducts: List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getProductById(id: Int): ProductEntity

    @Query("SELECT * FROM products WHERE categories LIKE '%' || :category || '%'")
    fun getProductsByCategory(category: String?): List<ProductEntity>

    @Insert
    fun insertAllProducts(products: List<ProductEntity>)

    @Insert
    fun insertYourPopularProducts(products: List<ProductEntity>)

    @get:Query("SELECT * FROM products WHERE type = `your`")
    val yourPopularProducts: List<ProductEntity>

}