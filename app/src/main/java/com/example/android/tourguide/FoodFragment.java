package com.example.android.tourguide;


import android.content.Intent;
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
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        // Get the description strings
        String foundry = getResources().getString(R.string.foundry);
        String oceanBasket = getResources().getString(R.string.ocean_basket);
        String breenasCafe = getResources().getString(R.string.breenas_cafe);
        String dominosPizza = getResources().getString(R.string.dominos_pizza);
        String cafeNeo = getResources().getString(R.string.cafe_neo);
        String belgianRose = getResources().getString(R.string.belgian_rose);


        // Create an array of words
        final ArrayList<CardItem> cardItems = new ArrayList<>();


        cardItems.add(new CardItem("The Foundry Restaurant", "Lagos", "8am - 9pm", R.drawable.thefoundrylagos, foundry, "228B, Ajose Adeogun Street, Victoria Island Lagos", "07030700082"));
        cardItems.add(new CardItem("Ocean Basket", "Lagos", "8am - 9pm", R.drawable.inside, oceanBasket, "1392 Tiamiyu Savage Street, Victoria Island, Lagos", "07030700082"));
        cardItems.add(new CardItem("Breena’s Cafe", "Lagos", "8am - 9pm", R.drawable.breenascafe, breenasCafe, "19, Abbi Street, Mende, Maryland, Lagos", "07030700082"));
        cardItems.add(new CardItem("Domino's Pizza", "Lagos", "8am - 10pm", R.drawable.dominospizza, dominosPizza, "344, Herbert Macaulay Way, Plot 204, Yaba", "07030700082"));
        cardItems.add(new CardItem("Cafe Neo", "Lagos", "7am - 9pm", R.drawable.cafeneo, cafeNeo, "E-Centre, Yaba", "07030700082"));
        cardItems.add(new CardItem("Belgian Rose", "Lagos", "10am - 8pm", R.drawable.belgianrose, belgianRose, "318, Herbert Macaulay Way", "07030700082"));


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
                    Intent newIntent = new Intent(getContext(), FoodActivity.class);
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
