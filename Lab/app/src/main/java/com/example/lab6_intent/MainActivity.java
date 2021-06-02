package com.example.lab6_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public static final String TITLE="";
    public static final String DESC="";
    public static final Integer IMAGE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        List<News> news = new ArrayList<>();
        news.add(new News("Title1", "Desc1", R.drawable.news1));
        news.add(new News("Title1", "Desc1", R.drawable.news1));
        news.add(new News("Title1", "Desc1", R.drawable.news1));

        CostumNewsAdapter costumNewsAdapter = new CostumNewsAdapter(this, news);
        listView.setAdapter(costumNewsAdapter);

        listView.setOnItemClickListener(onItemClickListener);
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            News news1 = (News) parent.getItemAtPosition(position);
            Log.d("otp", "onItemClick: "+position);
            Intent intent = new Intent(MainActivity.this, NewsActivity.class);
            intent.putExtra(TITLE, news1.getTitle());
            intent.putExtra(DESC, news1.getShortDescription());
            intent.putExtra(String.valueOf(IMAGE), news1.getImageUri());
            startActivity(intent);
        }
    };
}