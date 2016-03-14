package com.mycompany.letsstudy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by joshua on 3/12/2016.
 */
public class AddSpot extends Fragment {


    Button bAdd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.addspot_fragment,container,false);

        bAdd = (Button) v.findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Take input from edittext, add it to array in singleton.
                LatLng coordinates = new LatLng(32.758908,-117.146421);;
                String Name = "Lestats";
                String description = "Nice";
                int rate = 10;
                //Initialize here.
                Spots spot = new Spots(coordinates,Name,description,rate);
                SpotsHolder.addSpots(spot);

                Fragment fragment = new MapFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.addSpot, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return v;

    }
}
