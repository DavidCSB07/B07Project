package com.example.recycle_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerview = findViewById(R.id.recycleView);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("David", "David@gmail.com"));
        items.add(new Item("Javid", "Javid@gmail.com"));
        items.add(new Item("Lynn", "Lynn@gmail.com"));
        items.add(new Item("Jess", "Jess@gmail.com"));
        items.add(new Item("Hillary", "Hill@gmail.com"));
        items.add(new Item("Kehu", "Kehu@gmail.com"));

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new MyAdapter(getApplicationContext(), items));

    }
}