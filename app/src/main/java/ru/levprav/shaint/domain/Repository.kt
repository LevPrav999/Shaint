package ru.levprav.shaint.domain;


import java.util.List;

import ru.levprav.shaint.data.remote.OnLoadListener;
import ru.levprav.shaint.domain.model.Product;

public interface Repository {

    void getAllProducts(OnLoadListener<List<Product>> onLoadListener);

    Product getProductById(int id);

    List<Product> getProductsByCategory(String category);

    List<String> getCategories();
}
