package com.example.lab9_roomdb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TodoListAdapter extends BaseAdapter {
    private List<Todo> todoList;
    private Context context;

    public TodoListAdapter(List<Todo> todoList, Context context) {
        this.todoList = todoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return todoList.get(position).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView=inflater.inflate(R.layout.todo_list_item, parent, false);

        Todo todo = todoList.get(position);

        TextView title = convertView.findViewById(R.id.textView);
        TextView desc  = convertView.findViewById(R.id.textView2);

        title.setText(todo.getTitle());
        desc.setText(todo.getDesc());

        return convertView;
    }
}
