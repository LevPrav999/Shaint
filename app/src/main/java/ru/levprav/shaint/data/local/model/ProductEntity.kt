package ru.levprav.shaint.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
        @PrimaryKey
        val id: Int?,
        val name: String?,
        val details: String?,
        val imageUri: String?,
        val categories: List<String>,
        var type: String
)