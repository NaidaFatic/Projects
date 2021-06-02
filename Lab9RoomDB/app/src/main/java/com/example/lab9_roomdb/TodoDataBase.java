package com.example.lab9_roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class}, version = 1, exportSchema = false)
public abstract class TodoDataBase extends RoomDatabase {
    public abstract TodoDao todoDao();
    private static TodoDataBase INSTANCE;

    public static TodoDataBase getInstance(Context context){
               if(INSTANCE==null){
                   INSTANCE = Room.databaseBuilder(context, TodoDataBase.class, "todoDB").allowMainThreadQueries().build();;
               }
               return INSTANCE;
    }
}
