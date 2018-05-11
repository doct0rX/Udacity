package com.example.doctorx.p5_tour_guide_app;


/**
 * Created by doctorX on 5/7/18.\
 *
 * {@link Place} represent the image and name of the place.
 */

public class Place {
    /**
     * two states of the Class:
     *      Image
     *      String
     */
    private int mImagePlace;
    private String mStringPlace;

    /**
     * Public Constructor
     * @param imagePlace Place Image
     * @param stringPlace Name String
     */
    public Place(int imagePlace, String stringPlace) {
        mImagePlace = imagePlace;
        mStringPlace = stringPlace;
    }

    /**
     *
     * @return Place Image
     */
    public int getImagePlace(){
    return mImagePlace;
}

    /**
     *
     * @return Place Name
     */
    public String getStringPlace() {
        return mStringPlace;
    }
}
