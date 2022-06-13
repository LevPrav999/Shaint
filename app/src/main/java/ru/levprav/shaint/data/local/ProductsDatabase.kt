package ru.levprav.shaint.data.local

import androidx.room.Database
import ru.levprav.shaint.data.local.model.ProductEntity
import androidx.room.RoomDatabase
import ru.levprav.shaint.data.local.ProductDao

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}