package com.example.doctorx.musicalstructureapp;

/**
 * Created by doctorX on 3/6/18.
 *
 * {@link Song} represent the songs will be displayed for the user in home screen.
 */

public class Song {
    /* Song Name */
    private String mSongName;

    /* Artist Name */
    private String mArtistName;

    Song(String songName, String artistName) {
        this.mSongName = songName;
        this.mArtistName = artistName;
    }

    /**
     * Get song name
     */
    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }
}