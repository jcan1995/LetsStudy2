package com.mycompany.letsstudy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by joshua on 1/22/2016.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    private FloatingActionButton bAddSpot;
    private SupportMapFragment mSupportMapFragment;
    private LatLng Lestats = new LatLng(32.758908,-117.146421);
    private LatLng SanDiego = new LatLng(32.715,-117.1625);



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    View v = inflater.inflate(R.layout.map_fragment, container, false);

        bAddSpot = (FloatingActionButton) v.findViewById(R.id.fbAddSpot);
        bAddSpot.show();
        bAddSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new AddSpot();

                Log.d("Testing", "In onClick");
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                bAddSpot.hide();
                transaction.replace(R.id.map_frag, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        mSupportMapFragment = SupportMapFragment.newInstance();
        android.support.v4.app.FragmentManager sfm = getFragmentManager();
        mSupportMapFragment.getMapAsync(this);

        if(!mSupportMapFragment.isAdded())
            sfm.beginTransaction().add(R.id.map_frag,mSupportMapFragment).commit();

        else if(mSupportMapFragment.isAdded())
            sfm.beginTransaction().hide(mSupportMapFragment).commit();
        else
            sfm.beginTransaction().show(mSupportMapFragment).commit();

        return v;
    }

    @Override
    public void onMapReady(GoogleMap maps) {
            MarkerOptions LestatsMarker = new MarkerOptions();

            LestatsMarker.position(Lestats);
            LestatsMarker.title("Lestats");
            maps.addMarker(LestatsMarker);
            maps.moveCamera(CameraUpdateFactory.newLatLng(SanDiego));
            maps.animateCamera(CameraUpdateFactory.zoomTo(10));

    }
}
