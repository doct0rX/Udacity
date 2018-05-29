package com.example.android.miwok;


/**
 * Created by doctorX on 3/3/18.
 *
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains the default translation and a Miwork translation for that word.
 */

public class Word {
    /** default translation of the word **/
    private String mDefaultTranslation;

    /** Miwork translation of the word **/
    private String mMiworkTranslation;

    /** Image resource ID for the word **/
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word **/
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio resource ID for the word **/
    private int mAudioResourceID;

    /**
     * Create word object (constructor)
     * @param defaultTranslation English word
     * @param miWorkTranslation Miwork word
     * @param audioResourceID Audio Resource
     */
    public Word(String defaultTranslation, String miWorkTranslation, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miWorkTranslation;
        mAudioResourceID = audioResourceID;
    }

    /**
     * Create word object (constructor)
     * @param defaultTranslation English word
     * @param miWorkTranslation Miwork word
     * @param imageResourceId image source id
     * @param audioResourceID Audio Resource
     */
    public Word(String defaultTranslation, String miWorkTranslation, int imageResourceId, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miWorkTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceID = audioResourceID;
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
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * @return The Audio Recourse ID of the word.
     *
     */
    public int getAudioResourceID() {
        return mAudioResourceID;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiworkTranslation='" + mMiworkTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceID=" + mAudioResourceID +
                '}';
    }
}
