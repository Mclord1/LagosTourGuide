package com.example.android.tourguide;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {


    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        // Get the description strings
        String bestWestern = getResources().getString(R.string.bestWesternIslandHotel);
        String ekoHotel = getResources().getString(R.string.ekoHotel);
        String ellionHouse = getResources().getString(R.string.ellionHouse);
        String excellenceHotel = getResources().getString(R.string.excellenceHotel);
        String federalPalace = getResources().getString(R.string.federalPalaceHotel);
        String fourPoints = getResources().getString(R.string.fourPoints);
        String goldenTulip = getResources().getString(R.string.goldenTulip);
        String hotelBonVoyage = getResources().getString(R.string.hotelBonVoyage);


        // Create an array of words
        final ArrayList<CardItem> cardItems = new ArrayList<>();
        cardItems.add(new CardItem("Best Western the Island Hotel", "Lagos", "24hrs", R.drawable.bestwestern, bestWestern, "Plot 1228 Ahmadu Bello Way, Lagos", "07030754382"));
        cardItems.add(new CardItem("Eko Hotels and Suites", "Lagos", "24hrs", R.drawable.ekohotels, ekoHotel, "Adetokunbo Ademola Street in Victoria Island", "07030700082"));
        cardItems.add(new CardItem("Elion House", "Lagos", "24hrs", R.drawable.ellionhouse, ellionHouse, "Plot 7/8 Agbeke Rotinwa Street, Dolphin Extension", "07030700082"));
        cardItems.add(new CardItem("Excellence Hotel and Conference Centre", "Lagos", "24hrs", R.drawable.excellencehotel, excellenceHotel, "Isheri Road, Ogba-Ikeja", "07030700082"));
        cardItems.add(new CardItem("Federal Palace Hotel", "Lagos", "24hrs", R.drawable.federalpalacehotel, federalPalace, "6/8, Ahmadu Bello Way, Victoria Island, Lagos", "07030700082"));
        cardItems.add(new CardItem("Four Points By Sheraton", "Lagos", "24hrs", R.drawable.fourpoints, fourPoints, "Plot 9/10 Block 2 Oniru Chieftaincy Estate, Lekki Peninsula, Victoria Island", "07030700082"));
        cardItems.add(new CardItem("Golden Tulip Festac", "Lagos", "24hrs", R.drawable.goldentulip, goldenTulip, "Amowo Odofin, Mile 2", "07030700082"));
        cardItems.add(new CardItem("Hotel Bon Voyage", "Lagos", "24hrs", R.drawable.hoteldonvoyage, hotelBonVoyage, "57A, A.J Marinho Drive, off Ajose Adeogun Street", "07030700082"));

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
                    Intent newIntent = new Intent(getContext(), HotelActivity.class);
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
