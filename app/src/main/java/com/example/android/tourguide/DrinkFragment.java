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
public class DrinkFragment extends Fragment {


    public DrinkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        // Get the description strings
        String thePlace = getResources().getString(R.string.thePlace);
        String sailorsLounge = getResources().getString(R.string.sailorsLounge);
        String bayLounge = getResources().getString(R.string.bayLounge);
        String rhapsodys = getResources().getString(R.string.rhapsodys);
        String beerHugz = getResources().getString(R.string.ember_creek);
        String shaunzBar = getResources().getString(R.string.shaunzBar);
        String seaLounge = getResources().getString(R.string.seaLounge);


        // Create an array of words
        final ArrayList<CardItem> cardItems = new ArrayList<>();
        cardItems.add(new CardItem("The Place", "Lagos", "5pm - 9pm", R.drawable.theplace, thePlace, "Lagos- Lekki, Victoria Island and Ikeja", "07030754382"));
        cardItems.add(new CardItem("Sailor's Lounge", "Lagos", "5pm - 3am", R.drawable.sailorslounge, sailorsLounge, "Admiralty way", "07030700082"));
        cardItems.add(new CardItem("Bay Lounge", "Lagos", "5pm - 5am", R.drawable.baylounge, bayLounge, "Admiralty road", "07030700082"));
        cardItems.add(new CardItem("Rhapsody's", "Lagos", "5pm - 5am", R.drawable.rhapsodys, rhapsodys, "Ikeja City Mall at Alausa, Ikeja", "07030700082"));
        cardItems.add(new CardItem("BheerHugz", "Lagos", "5pm - 2am", R.drawable.beerhugz, beerHugz, "Surulere", "07030700082"));
        cardItems.add(new CardItem("Shaunz Bar", "Lagos", "1pm - 2am", R.drawable.shaunsbar, shaunzBar, "Sanusi Fafunwa in Victoria Island, Lagos", "07030700082"));
        cardItems.add(new CardItem("Sea Lounge", "Lagos", "2pm - 12am", R.drawable.sealounge, seaLounge, "Wole Olateju Crescent in Lekki", "07030700082"));

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
                    Intent newIntent = new Intent(getContext(), DrinkActivity.class);
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
