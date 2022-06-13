package ru.levprav.shaint.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProductDTO(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("details")
        val details: String,
        @SerializedName("categories")
        val categories:ArrayList<String>,
        @SerializedName("imageUrl")
        val imageUrl: String,
)