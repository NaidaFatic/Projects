package com.example.lab6_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView title, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        imageView=findViewById(R.id.imageView2);
        title=findViewById(R.id.textView3);
        desc=findViewById(R.id.textView4);

        Intent intent = getIntent();
        if(intent.getExtras()!=null){
            Bundle extras = intent.getExtras();
            setTitle(extras.getString(MainActivity.TITLE));
            title.setText(extras.getString(MainActivity.TITLE));
            desc.setText(extras.getString(MainActivity.DESC));
            imageView.setImageResource(extras.getInt(String.valueOf(MainActivity.IMAGE)));
        }

    }
}