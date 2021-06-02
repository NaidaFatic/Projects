package com.example.lab9_roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    void add(Todo todo);

    @Query("SELECT * FROM Todo")
    public List<Todo> getAll();

    @Query("SELECT * FROM Todo WHERE id = :id")
    public Todo getTodo(long id);

    @Query("UPDATE Todo SET title = :title, desc = :descr WHERE id = :id")
    void update(long id, String title, String descr);

    @Delete
    void delete(Todo todo);

}
