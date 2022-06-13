package ru.levprav.shaint.ui.listproducts.view;

import java.util.List;

import ru.levprav.shaint.base.BaseView;
import ru.levprav.shaint.domain.model.Product;

public interface ListProductsView extends BaseView {
    void showProducts(List<Product> products);
}
