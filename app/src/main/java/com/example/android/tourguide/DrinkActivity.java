package com.example.android.tourguide;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);


        // Get the transferred data
        Intent newIntent = getIntent();
        String title = newIntent.getStringExtra("TITLE");
        String address = newIntent.getStringExtra("ADDRESS");
        String city = newIntent.getStringExtra("CITY");
        String time = newIntent.getStringExtra("TIME");
        String phoneNumber = newIntent.getStringExtra("NUMBER");
        String description = newIntent.getStringExtra("DESCRIPTION");
        int imageResource = newIntent.getIntExtra("IMAGE", 0);

        TextView itemDescription = findViewById(R.id.item_detail_description);
        TextView itemTitle = findViewById(R.id.item_detail_title);
        TextView itemAddress = findViewById(R.id.item_detail_address);
        TextView itemCity = findViewById(R.id.item_detail_city);
        TextView itemTime = findViewById(R.id.item_detail_time);
        TextView itemNumber = findViewById(R.id.item_detail_phoneNumber);
        ImageView itemImage = findViewById(R.id.item_detail_image);


        itemDescription.setText(description);
        itemTitle.setText(title);
        itemAddress.setText(address);
        itemCity.setText(city);
        itemTime.setText(time);
        itemNumber.setText(phoneNumber);
        itemImage.setImageResource(imageResource);

        ActionBar ab = getActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
}
