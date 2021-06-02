package com.example.lab11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;

import static android.widget.Toast.LENGTH_LONG;

public class TodoDetailsActivity extends AppCompatActivity {
    private EditText titleInput, descInput;
    private Button save, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail_list);
        
        titleInput = findViewById(R.id.title_input);
        descInput = findViewById(R.id.desc_input);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            long id = extras.getLong(MainActivity.EXTRA_ID);
            Todo todos = AppDatabase.getInstance(this).todoDao().getTodoById(id);
            titleInput.setText(todos.getTitle());
            descInput.setText(todos.getDescription());
            save.setText("Update");
            cancel.setText("Delete");
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppDatabase.getInstance(TodoDetailsActivity.this).todoDao().update(id, titleInput.getText().toString(), descInput.getText().toString());
                    Intent intent = new Intent(TodoDetailsActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppDatabase.getInstance(TodoDetailsActivity.this).todoDao().delete(todos);
                    Intent intent = new Intent(TodoDetailsActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
    
    public void onSave(View view){
        Todo todo = new Todo(titleInput.getText().toString(), descInput.getText().toString());
        AppDatabase.getInstance(this).todoDao().add(todo);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}