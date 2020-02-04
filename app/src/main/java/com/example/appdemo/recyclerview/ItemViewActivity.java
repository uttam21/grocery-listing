package com.example.appdemo.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdemo.R;

public class ItemViewActivity extends AppCompatActivity {

    private TextView title,category,description;
    private ImageView img;

    String Title,Description,Category;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        title = (TextView) findViewById(R.id.tvTitle);
        category = (TextView) findViewById(R.id.tvCategory);
        description = (TextView) findViewById(R.id.tvDescription);
        img = (ImageView)findViewById(R.id.item_thumbnail);

        Intent intent = getIntent();

        Title=intent.getExtras().getString("TITLE");
        Description=intent.getExtras().getString("DESCRIPTION");
        Category=intent.getExtras().getString("CATEGORY");
        image = intent.getExtras().getInt("THUMBNAIL");



        title.setText(Title);
        category.setText(Category);
        description.setText(Description);
        img.setImageResource(image);

    }
}
