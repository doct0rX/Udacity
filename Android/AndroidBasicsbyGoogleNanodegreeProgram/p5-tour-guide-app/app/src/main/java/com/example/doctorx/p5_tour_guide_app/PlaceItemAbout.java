package com.example.doctorx.p5_tour_guide_app;


/**
 * Created by doctorX on 5/17/18.\
 *
 * {@link PlaceItemAbout} represent the image and name of the place.
 */

public class PlaceItemAbout {
    /**
     * two states of the Class:
     *      Image
     *      String
     */
    private int mImagePlace;
    private int mStringPlace;

    /**
     * Public Constructor
     * @param imagePlace Place Image
     * @param stringPlace Name String
     */
    public PlaceItemAbout(int imagePlace, int stringPlace) {
        mImagePlace = imagePlace;
        mStringPlace = stringPlace;
    }

    /**
     *
     * @return Place Image
     */
    public int getImageItemPlace(){
        return mImagePlace;
    }

    /**
     *
     * @return Place Name
     */
    public int getStringItemPlace() {
        return mStringPlace;
    }
}
