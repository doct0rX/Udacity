package com.example.doctorx.musicalstructureapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by doctorX on 3/8/18.
 *
 */

@SuppressLint("Registered")
public class PopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_view);

        // Construct the data source
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Hello", "Adele"));
        songs.add(new Song("Not made for this world", "Tove Lo"));
        songs.add(new Song("Chato", "Bisco Masr"));
        songs.add(new Song("Nope", "Mustafa"));
        songs.add(new Song("haha", "hehe"));
        songs.add(new Song("haha", "hehe"));
        songs.add(new Song("haha", "hehe"));
        songs.add(new Song("haha", "hehe"));
        songs.add(new Song("haha", "hehe"));
        songs.add(new Song("haha", "hehe"));
        songs.add(new Song("haha", "hehe"));
        songs.add(new Song("haha", "hehe"));
        songs.add(new Song("haha", "hehe"));
        songs.add(new Song("Not made for this world", "Tove Lo"));
        songs.add(new Song("Chato", "Bisco Masr"));

        // Create an adapter to convert the array to views
        SongAdapter adapter = new SongAdapter(this, songs);

        // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.songs_list);
        assert listView != null;
        listView.setAdapter(adapter);
    }
}
