package com.example.lab9_roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.midi.MidiDeviceService;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    public static final String EXTRA_ID="MainActivity/EXTRA_TODO_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.todo_list);

        setAdapter();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long todoId = parent.getItemIdAtPosition(position);
                Intent intent = new Intent(MainActivity.this, TodoDetailsActivity.class);
                intent.putExtra(EXTRA_ID, todoId);
                startActivity(intent);

            }
        });
    }

    private void setAdapter(){
        List<Todo> listTodo = TodoDataBase.getInstance(this).todoDao().getAll();
        
        TodoListAdapter todoListAdapter = new TodoListAdapter(listTodo, this);
        listView.setAdapter(todoListAdapter);
    }

    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, TodoDetailsActivity.class);
        startActivity(intent);
    }
}