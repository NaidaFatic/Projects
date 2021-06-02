package com.example.lab1_startanotheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another2);

        text = findViewById(R.id.textView);
        Intent intent = getIntent();
        if(intent.getExtras()!=null)
            text.setText(intent.getExtras().getString(MainActivity.EXTRA_TEXT));
    }
}