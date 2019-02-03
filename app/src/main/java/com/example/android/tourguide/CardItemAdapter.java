package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardItemAdapter extends ArrayAdapter<CardItem> {

    public CardItemAdapter(Activity context, ArrayList<CardItem> cardItems) {
        super(context, 0, cardItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        // Get the data item for this position
        CardItem currentWord = getItem(position);

        // Look up the views for data population
        TextView itemName = (TextView) listItemView.findViewById(R.id.item_name);
        TextView itemCity = (TextView) listItemView.findViewById(R.id.item_city);
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image_view);
        TextView itemTime = (TextView) listItemView.findViewById(R.id.item_time);
        View textContainer = listItemView.findViewById(R.id.text_container);


        // Populate the data to the template
        if (currentWord != null) {
            itemName.setText(currentWord.getName());
        }

        if (currentWord != null) {
            itemCity.setText(currentWord.getCity());
        }

        if (currentWord != null) {
            itemTime.setText(currentWord.getTime());
        }

        if (currentWord != null) {
            if (currentWord.hasImage()) {
                iconView.setImageResource(currentWord.getImageResourceId());
                iconView.setVisibility(View.VISIBLE);
            } else {
                iconView.setVisibility(View.GONE);
            }
        }


        // Return the completed view to render on the screen
        return listItemView;
    }

}
