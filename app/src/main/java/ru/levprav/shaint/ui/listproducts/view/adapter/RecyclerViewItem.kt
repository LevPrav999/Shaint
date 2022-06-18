package ru.levprav.shaint.ui.listproducts.view.adapter

sealed class RecyclerViewItem {
    class Name(
        val name: String
    ) : RecyclerViewItem()

    class Product(
        val id: Int?,
        val name: String?,
        val details: String?,
        val imageUri: String?,
        val categories: List<String>
    ) : RecyclerViewItem()

    class Category(
        val title: String
    ) : RecyclerViewItem()
}