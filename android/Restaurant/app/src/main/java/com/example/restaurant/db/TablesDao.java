package com.example.restaurant.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.restaurant.entities.Table;

import java.util.List;

/**
 * Data Access Object
 * - interface used to define methods needed to operate on tables
 */
@Dao
public interface TablesDao {

    @Query("SELECT * FROM tables")
    List<Table> getTables();

    @Query("SELECT COUNT(*) FROM tables")
    int getTablesCount();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Table table);

}
