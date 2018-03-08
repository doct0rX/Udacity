package com.example.android.miwok;


/**
 * Created by doctorX on 3/3/18.
 *
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains the default translation and a Miwork translation for that word.
 */

public class Word {
    /* default translation of the word */
    private String mDefaultTranslation;

    /* Miwork translation of the word */
    private String mMiworkTranslation;

    /* Image resource ID for the word */
    private int mImageResourceId;
//    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create word object (constructor)
     * @param defaultTranslation English word
     * @param miWorkTranslation Miwork word
     */
    public Word(String defaultTranslation, String miWorkTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miWorkTranslation;
    }

    /**
     * Create word object (constructor)
     * @param defaultTranslation English word
     * @param miWorkTranslation Miwork word
     * @param imageResourceId image source id
     */
    public Word(String defaultTranslation, String miWorkTranslation, int imageResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miWorkTranslation;
        mImageResourceId = imageResourceId;
    }



    /**
     * Get the default translation of the word
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwork translation of the word
     */
    public String getMiworkTranslation() {
        return mMiworkTranslation;
    }

    /**
     * Get the image source id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * @return whether or not there is an image for this Word.
     *
     * I don't need to use this method since my App is running perfectly with 2 constructors of WordAdapter.
     */
//    public boolean hasImage() {
//        return mImageResourceId != NO_IMAGE_PROVIDED;
//    }
}
