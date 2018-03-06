package com.example.doctorx.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by doctorX on 3/6/18.
 *
 */
public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get the data item from it's position
        Song song = getItem(position);

        // check if there's a view is used else inflate the view
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);

        // lookup view for data population
        TextView songName   = convertView.findViewById(R.id.song_name);
        TextView songArtist = convertView.findViewById(R.id.song_artist);

        // populate the data into the template view using the data object
        assert song != null;
        songName.setText(song.getSongName());
        songArtist.setText(song.getArtistName());

        return convertView;
    }
}
