package com.example.lab6_intent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CostumNewsAdapter extends BaseAdapter {
    private List<News> newsList = new ArrayList<>();
    private Context context;

    public CostumNewsAdapter(Context context, List<News> news){
        this.context = context;
        this.newsList = news;
    }


    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return newsList.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView=inflater.inflate(R.layout.list_view, parent, false);
        News news = newsList.get(position);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);
        TextView textView1 = convertView.findViewById(R.id.textView2);

        imageView.setImageResource(news.getImageUri());
        textView.setText(news.getTitle());
        textView1.setText(news.getShortDescription());

        return convertView;
    }
}
