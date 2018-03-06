package com.example.doctorx.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Hello", "Adele"));
        songs.add(new Song("Not made for this world", "Tove Lo"));
        songs.add(new Song("Chato", "Bisco Masr"));
        songs.add(new Song("Nope", "Mustafa"));
        songs.add(new Song("haha", "hehe"));

        // Create an adapter to convert the array to views
        SongAdapter adapter = new SongAdapter(this, songs);

        // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.songs_list);
        listView.setAdapter(adapter);
    }
}
