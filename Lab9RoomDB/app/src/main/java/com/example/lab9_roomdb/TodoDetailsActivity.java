package com.example.lab9_roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TodoDetailsActivity extends AppCompatActivity {
    public EditText title, desc;
    public Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_details);

        title = findViewById(R.id.editTextTextPersonName);
        desc = findViewById(R.id.editTextTextPersonName2);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            long id = extras.getLong(MainActivity.EXTRA_ID);
            Todo todos = TodoDataBase.getInstance(this).todoDao().getTodo(id);
            title.setText(todos.getTitle());
            desc.setText(todos.getDesc());
            button1.setText("Update");
            button2.setText("Delete");
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TodoDataBase.getInstance(TodoDetailsActivity.this).todoDao().update(id, title
                            .getText().toString(), desc.getText().toString());
                    Intent intent = new Intent(TodoDetailsActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TodoDataBase.getInstance(TodoDetailsActivity.this).todoDao().delete(todos);
                    Intent intent = new Intent(TodoDetailsActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    public void onSave(View view){
        Todo todo = new Todo(title.getText().toString(), desc.getText().toString());
        TodoDataBase.getInstance(this).todoDao().add(todo);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}