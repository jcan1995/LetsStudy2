package com.mycompany.letsstudy;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by joshua on 3/11/2016.
 * Singleton which will hold an arraylist consisting of "Spots" objects.
 */
public class SpotsHolder{
    /**
     * Declare an ArrayList.
     * Instance of class set to null, and declare apps context.
     */
    private ArrayList<Spots> mSpots;
    private static SpotsHolder sInstance = null;
    private Context mAppContext;

    /**
     * Instantiate new ArrayList
     * Set private mAppContext to the appContext passed in parameters
     *
     */
    private SpotsHolder(Context appContext){
        mAppContext = appContext;
        mSpots = new ArrayList<Spots>();
    }

    /**
     * Returns instance of this class.
     * Creates new instance if sInstance is null.
     */
    public static SpotsHolder getInstance(Context c){
        if( sInstance == null){
            sInstance = new SpotsHolder(c.getApplicationContext());

        }
        return sInstance;
    }

    /**
     * Returns the ArrayList consisting of Spots.
     *
     */
    public ArrayList<Spots> getSpots(){
        return mSpots;
    }

    /**
     * Add spots passed in parameters into our ArrayList.
     * @param spot
     */
    public void addSpots(Spots spot){
        mSpots.add(spot);
        //Gui.updateUI();
    }



}
