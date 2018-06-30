package com.example.doctorx.newsappstage1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app.
     * @param newsItems is the list of news stories, which is the data source of the adapter.
     */
    public NewsAdapter(Context context, List<News> newsItems){
        super(context, 0, newsItems);
    }

    /**
     * Returns list item view that displays information about the news at the given position in the list of earthquakes.
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        // check if there is an existing list item view (called ConvertView) then I can reuse,
        // else inflate new one
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the list of news
        News currentNewsItem = getItem(position);

        // Find the TextViews and assign text to them;
        TextView sectionNameView = convertView.findViewById(R.id.section_name);
        assert currentNewsItem != null;
        sectionNameView.setText(currentNewsItem.getmSectionName());

        TextView webTitleView = convertView.findViewById(R.id.web_title);
        webTitleView.setText(currentNewsItem.getWebTitle());

        TextView dateView = convertView.findViewById(R.id.web_publication_date);

        // Convert the date before assigning it to the View;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        Date date = null;
        try {
            date = simpleDateFormat.parse(currentNewsItem.getNewsData());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        @SuppressLint("SimpleDateFormat") SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMM, yyyy kk:mm");
        String finalDate = newDateFormat.format(date);
        if (date != null) {
            dateView.setText(finalDate);
        }

        return convertView;
    }

}
