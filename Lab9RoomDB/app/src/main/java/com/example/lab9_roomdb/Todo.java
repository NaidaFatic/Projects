package com.example.lab9_roomdb;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "Todo")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;
    private String desc;

    public Todo(long id, String title, String desc){
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    @Ignore
    public Todo(String title, String desc){
        this.title = title;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
