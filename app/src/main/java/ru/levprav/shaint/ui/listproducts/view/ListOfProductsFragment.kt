package ru.levprav.shaint.ui.listproducts.view

import ru.levprav.shaint.ui.listproducts.view.ListProductsView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.levprav.shaint.R
import ru.levprav.shaint.domain.model.Product
import ru.levprav.shaint.ui.listproducts.presenter.ListProductsPresenter
import ru.levprav.shaint.ui.listproducts.view.adapter.RecyclerViewItem

class ListOfProductsFragment : Fragment(), ListProductsView {
    private val presenter: ListProductsPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_of_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttachView(this)
    }


    override fun showPopularProducts(products: List<RecyclerViewItem>) {

    }

    override fun showYourProducts(products: List<RecyclerViewItem>) {

    }
}