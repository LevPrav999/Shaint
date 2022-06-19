package ru.levprav.shaint.ui.listproducts.view.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import ru.levprav.shaint.R
import ru.levprav.shaint.databinding.CategoryItemLayoutBinding
import ru.levprav.shaint.databinding.ItemProductBinding
import ru.levprav.shaint.databinding.TitleItemLayoutBinding

sealed class RecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    var itemClickListener: ((item: RecyclerViewItem) -> Unit)? = null

    class TitleViewHolder(private val binding: TitleItemLayoutBinding) :
        RecyclerViewHolder(binding) {
        fun bind(title: RecyclerViewItem.Name) {
            binding.titleTv.text = title.name
        }
    }

    class CategoryViewHolder(
        private val binding: CategoryItemLayoutBinding,
        private val onSelect: (position: Int) -> Unit
    ) :
        RecyclerViewHolder(binding) {
        fun bind(genre: RecyclerViewItem.Category) {
            binding.genreTitle.text = genre.title
            binding.root.setOnClickListener {
                onSelect(adapterPosition)
                itemClickListener?.invoke(genre)
            }
        }

        fun selectedBg() {
            binding.root.setBackgroundResource(R.drawable.selected_category_background)
        }

        fun defaultBg() {
            binding.root.setBackgroundResource(R.drawable.category_background)
        }
    }

    class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerViewHolder(binding) {
        fun bind(movie: RecyclerViewItem.Product) {
            binding.apply {
                movieTitleIv.text = movie.name
                Glide
                    .with(binding.root)
                    .load(movie.imageUri)
                    .placeholder(R.drawable.non_image)
                    .into(movieImageIv)

                root.setOnClickListener {
                    itemClickListener?.invoke(movie)
                }
            }
        }
    }
}