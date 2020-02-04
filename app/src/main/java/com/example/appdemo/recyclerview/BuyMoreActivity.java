package com.example.appdemo.recyclerview;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.appdemo.R;

import java.util.ArrayList;
import java.util.List;

public class BuyMoreActivity extends AppCompatActivity {

    List<ItemDetails> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_more);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
       */ getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // Intent intent = getIntent();

        itemList = new ArrayList<>();
        itemList.add(new ItemDetails("Samosa","Fried food Item","So yummy, too tasty",R.drawable.samosa));
        itemList.add(new ItemDetails("Burger","Fried food Item","So yummy, too tasty",R.drawable.burger));
        itemList.add(new ItemDetails("Rice","Boiled food Item","So yummy, too tasty",R.drawable.rice));
        itemList.add(new ItemDetails("Rolls","Non-veg food Item","So yummy, too tasty",R.drawable.rolls));
        itemList.add(new ItemDetails("Noodles","Boiled food Item","So yummy, too tasty",R.drawable.noodles));
        itemList.add(new ItemDetails("Curd","Milk food Item","So yummy, too tasty",R.drawable.curd));
        itemList.add(new ItemDetails("Samosa","Fried food Item","So yummy, too tasty",R.drawable.samosa));
        itemList.add(new ItemDetails("Burger","Fried food Item","So yummy, too tasty",R.drawable.burger));
        itemList.add(new ItemDetails("Rice","Boiled food Item","So yummy, too tasty",R.drawable.rice));
        itemList.add(new ItemDetails("Rolls","Non-veg food Item","So yummy, too tasty",R.drawable.rolls));
        itemList.add(new ItemDetails("Noodles","Boiled food Item","So yummy, too tasty",R.drawable.noodles));
        itemList.add(new ItemDetails("Curd","Milk food Item","So yummy, too tasty",R.drawable.curd));

        RecyclerView recyclerView = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(itemList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(myAdapter);






    }

}
