package ru.levprav.shaint.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.levprav.shaint.data.local.model.ProductEntity;

@Database(entities = {ProductEntity.class}, version = 1, exportSchema = false)
public abstract class ProductsDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
