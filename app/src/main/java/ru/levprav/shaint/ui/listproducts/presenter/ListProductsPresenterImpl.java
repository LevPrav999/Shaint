package ru.levprav.shaint.ui.listproducts.presenter;

import androidx.annotation.NonNull;

import ru.levprav.shaint.ui.listproducts.view.ListProductsView;

public class ListProductsPresenterImpl implements ListProductsPresenter{
    @Override
    public void viewIsReady() {
        fetchPopularProducts();
        fetchYourPopularProducts();
    }

    @Override
    public void onAttachView(@NonNull ListProductsView view) {

    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void fetchPopularProducts() {

    }

    @Override
    public void fetchYourPopularProducts() {

    }
}
