package ru.levprav.shaint.ui.listproducts.presenter;

import ru.levprav.shaint.base.MvpPresenter;
import ru.levprav.shaint.ui.listproducts.view.ListProductsView;

public interface ListProductsPresenter extends MvpPresenter<ListProductsView> {

    void fetchPopularProducts();
    void fetchYourPopularProducts();
}
