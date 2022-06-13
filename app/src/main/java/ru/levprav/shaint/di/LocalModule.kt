package ru.levprav.shaint.di

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import ru.levprav.shaint.data.local.ProductDao
import ru.levprav.shaint.data.local.ProductsDatabase

val localModule = module {

    fun provideDatabase(application: Application): ProductsDatabase {
        return Room.databaseBuilder(application, ProductsDatabase::class.java, "ProductsDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }

    fun provideDao(database: ProductsDatabase): ProductDao =
            database.productDao()

    single { provideDatabase(androidApplication()) }
    single { provideDao(database = get()) }
}
