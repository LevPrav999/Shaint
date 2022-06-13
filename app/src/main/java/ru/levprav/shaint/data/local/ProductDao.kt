package ru.levprav.shaint.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.levprav.shaint.data.local.model.ProductEntity;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM products")
    List<ProductEntity> getAllProducts();

    @Query("SELECT * FROM products WHERE id = :id")
    ProductEntity getProductById(int id);

    @Query("SELECT * FROM products WHERE categories LIKE '%' || :category || '%'")
    List<ProductEntity> getProductsByCategory(String category);

    @Insert
    void insertAllProducts(List<ProductEntity> products);

}
