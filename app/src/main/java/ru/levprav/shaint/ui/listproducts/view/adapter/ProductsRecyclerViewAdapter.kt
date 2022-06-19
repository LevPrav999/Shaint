package ru.levprav.shaint.ui.listproducts.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.levprav.shaint.R
import ru.levprav.shaint.databinding.CategoryItemLayoutBinding
import ru.levprav.shaint.databinding.ItemProductBinding
import ru.levprav.shaint.databinding.TitleItemLayoutBinding

class ProductsRecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {

    var selectedItemPosition = -1
    var lastItemSelectedPosition = -1

    var items = listOf<RecyclerViewItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var itemClickListener: ((item: RecyclerViewItem) -> Unit)? = null

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is RecyclerViewItem.Name -> R.layout.title_item_layout
            is RecyclerViewItem.Product -> R.layout.item_product
            is RecyclerViewItem.Category -> R.layout.category_item_layout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return when (viewType) {
            R.layout.title_item_layout -> RecyclerViewHolder.TitleViewHolder(
                TitleItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.item_product -> RecyclerViewHolder.ProductViewHolder(
                ItemProductBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.category_item_layout -> RecyclerViewHolder.CategoryViewHolder(
                CategoryItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            ) {
                selectedItemPosition = it
                lastItemSelectedPosition = if (lastItemSelectedPosition == -1) {
                    selectedItemPosition
                } else {
                    notifyItemChanged(lastItemSelectedPosition)
                    selectedItemPosition
                }
                notifyItemChanged(selectedItemPosition)
            }

            else -> throw IllegalAccessException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.itemClickListener = itemClickListener
        when (holder) {
            is RecyclerViewHolder.TitleViewHolder -> holder.bind(items[position] as RecyclerViewItem.Name)
            is RecyclerViewHolder.ProductViewHolder -> holder.bind(items[position] as RecyclerViewItem.Product)
            is RecyclerViewHolder.CategoryViewHolder -> {
                if (position == selectedItemPosition) {
                    holder.selectedBg()
                } else {
                    holder.defaultBg()
                }

                holder.bind(items[position] as RecyclerViewItem.Category)
            }
        }
    }

    override fun getItemCount() = items.size
}