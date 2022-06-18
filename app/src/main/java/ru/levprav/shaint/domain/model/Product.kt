package ru.levprav.shaint.domain.model

data class Product(
        val id: Int?,
        val name: String?,
        val details: String?,
        val imageUri: String?,
        val categories: List<String>,
        var type: String
)
