package com.example.android.quakereport;

public class Earthquake {
    /* Magnitude */
    private String mMagnitude;

    /* Location */
    private String mLocation;

    /* Date */
    private String mDate;


    /**
     * Constructs a new {@link Earthquake} object
     *
     * @param magnitude Mag/size of the earthquake
     * @param location City location of the earthquake
     * @param date the date the earthquake happened
     */
    public Earthquake(String magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    /**
     *
     * @Returns the Magnitude of the earthquake
     */
    public String getMagnitude() {
        return mMagnitude;
    }

    /**
     *
     * @Returns the Location of the earthquake
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     *
     * @Returns the Date of the earthquake
     */
    public String getDate() {
        return mDate;
    }
}
