package com.example.lab2_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button convert;
    public EditText money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        convert = findViewById(R.id.button2);
        money = findViewById(R.id.editTextTextPersonName3);

    }


    public void onClick(View v) {
        Double value = Double.parseDouble(money.getText().toString())*1.5;
        Toast.makeText(MainActivity.this, ""+value, Toast.LENGTH_SHORT).show();
    }
}