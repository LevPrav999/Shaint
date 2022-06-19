package ru.levprav.shaint.data.remote.model

import com.google.gson.annotations.SerializedName

class ProductsResponseDTO {
    @SerializedName("products")
    var products: List<ProductDTO>? = null
}