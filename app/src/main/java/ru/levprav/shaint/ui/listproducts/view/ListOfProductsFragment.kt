package ru.levprav.shaint.ui.listproducts.view

import ru.levprav.shaint.ui.listproducts.view.ListProductsView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.levprav.shaint.R
import ru.levprav.shaint.domain.model.Product

internal class ListOfProductsFragment : Fragment(), ListProductsView {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_of_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showProducts(products: List<Product>) {}
}