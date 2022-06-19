package ru.levprav.shaint.ui.listproducts.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.android.ext.android.inject
import ru.levprav.shaint.R
import ru.levprav.shaint.databinding.FragmentListOfProductsBinding
import ru.levprav.shaint.ui.listproducts.presenter.ListProductsPresenter
import ru.levprav.shaint.ui.listproducts.view.adapter.ProductsRecyclerViewAdapter
import ru.levprav.shaint.ui.listproducts.view.adapter.RecyclerViewItem

class ListOfProductsFragment : Fragment(), ListProductsView {

    private val presenter: ListProductsPresenter by inject()

    private var _binding: FragmentListOfProductsBinding? = null
    private val binding get() = _binding!!

    private val recyclerViewAdapter = ProductsRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListOfProductsBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.viewIsReady()
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.onDetachView()
    }

    override fun showPopularProducts(products: List<RecyclerViewItem>) {
        val manager = GridLayoutManager(requireContext(), 2)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (recyclerViewAdapter.getItemViewType(position) == R.layout.item_product) 1 else 2
            }
        }

        recyclerViewAdapter.items = products
        recyclerViewAdapter.itemClickListener = { recyclerViewItem ->
            when (recyclerViewItem) {
                is RecyclerViewItem.Product -> {
                    Log.e("Test", "Click ${recyclerViewItem.name}")

                    recyclerViewItem.id?.let { findNavController().navigate(it) }
                }
                is RecyclerViewItem.Category -> {
                    Log.e("Test", "Click ${recyclerViewItem.title}")
                    presenter.getProductsByCategory(recyclerViewItem.title)
                }
            }
        }
        binding.popularRecycler.apply {
            adapter = recyclerViewAdapter
            layoutManager = manager
        }
    }

    override fun showYourProducts(products: List<RecyclerViewItem>) {
        val manager = GridLayoutManager(requireContext(), 2)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (recyclerViewAdapter.getItemViewType(position) == R.layout.item_product) 1 else 2
            }
        }

        recyclerViewAdapter.items = products
        recyclerViewAdapter.itemClickListener = { recyclerViewItem ->
            when (recyclerViewItem) {
                is RecyclerViewItem.Product -> {
                    Log.e("Test", "Click ${recyclerViewItem.name}")

                    recyclerViewItem.id?.let { findNavController().navigate(it) }
                }
                is RecyclerViewItem.Category -> {
                    Log.e("Test", "Click ${recyclerViewItem.title}")
                    presenter.getProductsByCategory(recyclerViewItem.title)
                }
            }
        }
        binding.yourPopularRecycler.apply {
            adapter = recyclerViewAdapter
            layoutManager = manager
        }
    }
}