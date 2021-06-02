package com.example.lab10_retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class PostListViewAdapter extends BaseAdapter {
    private Context context;
    private  List<Post> postsList;

    public PostListViewAdapter(Context context, List<Post> postsList) {
        this.context = context;
        this.postsList = postsList;
    }

    @Override
    public int getCount() {
        return postsList.size();
    }

    @Override
    public Object getItem(int position) {
        return postsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return postsList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        convertView = layoutInflater.inflate(R.layout.post_list_view_item, parent, false);

        Post post = postsList.get(position);
        TextView title = convertView.findViewById(R.id.item_title);
        TextView body = convertView.findViewById(R.id.item_body);

        title.setText(post.getTitle());
        body.setText(post.getBody());

        return convertView;
    }
}
