package com.example.lab11;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "todos")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;
    private String description;

    public Todo(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Ignore
    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
