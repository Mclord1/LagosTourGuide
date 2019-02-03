package com.example.android.tourguide;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressWarnings("ALL")
public class PlacesFragment extends Fragment {


    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        // Get the description strings
        String bogobiri = getResources().getString(R.string.bogobiri_text);
        String freedomPark = getResources().getString(R.string.freedom_park);
        String terraKulture = getResources().getString(R.string.terra_kulture);
        String pattaya = getResources().getString(R.string.pattaya);
        String emberCreek = getResources().getString(R.string.ember_creek);
        String maryLandMall = getResources().getString(R.string.maryland_mall);
        String tarkwaBay = getResources().getString(R.string.tarkwaBay);
        String releArtGallery = getResources().getString(R.string.releArtGallery);


        // Create an array of words
        final ArrayList<CardItem> cardItems = new ArrayList<>();
        cardItems.add(new CardItem("Bogobiri House", "Lagos", "9am - 9pm", R.drawable.bogobirihouse, bogobiri, "7 Maitama Sule Street, Lagos", "07030754382"));
        cardItems.add(new CardItem("Freedom Park", "Lagos", "10am - 11pm", R.drawable.lagosfreedom, freedomPark, "1, Hospital Road, Old Prison Ground, Broad Street, Lagos Island, Lagos", "07030700082"));
        cardItems.add(new CardItem("Maryland Mall", "Lagos", "10am - 9pm", R.drawable.marylandmall, maryLandMall, "350 – 360, Ikorodu Road, Anthony Village, Lagos", "07030700082"));
        cardItems.add(new CardItem("Tarkwa Bay", "Lagos", "24 Hrs", R.drawable.tarkwabay, tarkwaBay, "Tarkwa Bay Island", "07030700082"));
        cardItems.add(new CardItem("Terra Kulture", "Lagos", "9am - 9pm", R.drawable.terrakulture, terraKulture, "1376 Tiamiyu Savage Street, Victoria Island Lagos", "07030700082"));
        cardItems.add(new CardItem("Lotus at Pattaya Bar-Lounge", "Lagos", "2pm - 12am", R.drawable.lotusatpattayabar, pattaya, "30, Adeola Hopewell, Victoria Island, Lagos", "07030700082"));
        cardItems.add(new CardItem("Ember Creek Waterfront", "Lagos", "2pm - 5am", R.drawable.mbe, emberCreek, "32, Awolowo Road, Obalende, Ikoyi, Lagos", "07030700082"));
        cardItems.add(new CardItem("Rele Art Gallery", "Lagos", "12pm - 6pm", R.drawable.releartgallery, releArtGallery, "5, Military Street, Onikan Environment, Lagos", "07030700082"));

        CardItemAdapter itemsAdapter = new CardItemAdapter(getActivity(), cardItems);


        ListView listView = (ListView) rootView.findViewById(R.id.list);


        if (listView != null) {
            listView.setAdapter(itemsAdapter);
        }

        if (listView != null) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    CardItem cardItem = cardItems.get(position);

                    // Create a new intent to open places activity
                    Intent newIntent = new Intent(getContext(), PlacesActivity.class);
                    newIntent.putExtra("TITLE", cardItem.getName());
                    newIntent.putExtra("ADDRESS" , cardItem.getAddress());
                    newIntent.putExtra("CITY", cardItem.getCity());
                    newIntent.putExtra("TIME", cardItem.getTime());
                    newIntent.putExtra("NUMBER", cardItem.getPhoneNumber());
                    newIntent.putExtra("DESCRIPTION", cardItem.getDescription());
                    newIntent.putExtra("IMAGE", cardItem.getImageResourceId());

                    startActivity(newIntent);

                }
            });
        }

        return rootView;
    }

}
