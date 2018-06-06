package com.example.android.quakereport;

public class Earthquake {
    /** Magnitude */
    private double mMagnitude;

    /** Location */
    private String mLocation;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;


    /**
     * Constructs a new {@link Earthquake} object
     *
     * @param magnitude Mag/size of the earthquake
     * @param location City location of the earthquake
     @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the earthquake happened
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;

    }

    /**
     *
     * @Returns the Magnitude of the earthquake
     */
    public double getMagnitude() {
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
     * @Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
