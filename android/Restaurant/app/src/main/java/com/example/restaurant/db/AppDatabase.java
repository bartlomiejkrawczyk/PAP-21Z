package com.example.restaurant.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.restaurant.entities.ExampleEntity;

@Database(entities = {ExampleEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "RESTAURANT_DATABASE";
    private static AppDatabase db;

    public static synchronized AppDatabase getAppDatabase(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return db;
    }
}
