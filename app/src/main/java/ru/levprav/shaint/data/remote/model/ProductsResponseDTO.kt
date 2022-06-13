package ru.levprav.shaint.data.remote.model

import com.google.gson.annotations.SerializedName
import ru.levprav.shaint.data.remote.model.ProductDTO

class ProductsResponseDTO {
    @SerializedName("products")
    var products: List<ProductDTO>? = null
}