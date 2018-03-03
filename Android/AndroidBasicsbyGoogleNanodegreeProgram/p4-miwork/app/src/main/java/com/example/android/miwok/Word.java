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

    public Word(String defaultTranslation, String miWorkTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miWorkTranslation;
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
}
