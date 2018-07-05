package com.example.doctorx.newsappstage1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String mUrl;


    /**
     * Constructs a new {@link NewsLoader}.
     * @param context of the activity.
     * @param url to load data from.
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * background thread;
     */
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news items.
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
