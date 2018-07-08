package com.example.doctorx.newsappstage1;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.example.doctorx.newsappstage1.NewsActivity.LOG_TAG;

public class QueryUtils {

    private static final int SUCCESS_CODE = 200;

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name com.example.doctorx.newsappstage1.QueryUtils (and an object instance of com.example.doctorx.newsappstage1.QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Query the Guardian dataset and return a list of {@link News} objects.
     */
    public static List<News> fetchNewsData(String requestNewsJSON) {
        // Create URL object
        URL url = createUrl(requestNewsJSON);

        // Perform HTTP request to the URL and Receive a JSON response back.
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "fetchNewsData: Problem making the HTTP request", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link News}
        List<News> news = extractFeatureFromJson(jsonResponse);
        return news;
    }

    /**
     * Return a list of {@link News} objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<News> extractFeatureFromJson(String newsJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding news items to.
        List<News> news = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print out the error message to the logs.
        try {
            // Create a JSONObject from the JSON response string.
            JSONObject baseJsonResponse = new JSONObject(newsJSON);
            JSONObject response = baseJsonResponse.getJSONObject("response");

            // Extract the JSONArray associated with the key called "results",
            // which represents a list of responses (or news items).
            JSONArray newsArray = response.getJSONArray("results");

            // For each news item in the newsArray, create a {@link News} object
            for (int i = 0; i < newsArray.length(); i++) {
                // Get a single news item at position i within the list of news items.
                JSONObject currentNewsItem = newsArray.getJSONObject(i);

                // For a given news item, extract the JSONObject associated with the key

                // Extract the value for the key called "sectionName"
                String sectionName = currentNewsItem.optString("sectionName");

                // Extract the value for the key called "webPublicationDate"
                String webPubDate = currentNewsItem.optString("webPublicationDate");

                // Extract the value for the key called "webTitle"
                String webTitle = currentNewsItem.optString("webTitle");

                String authorFullName;
                if (currentNewsItem.has("fields")) {
                    authorFullName = currentNewsItem.getJSONObject("fields").optString("byline");
                } else {
                    authorFullName = null;
                }


                // Extract the value for the key called "webUrl"
                String url = currentNewsItem.optString("webUrl");

                // Create a new {@link News} object with the sectionID, webPublicationDate,
                // webTitle and url from the JSON response.
                News newsItem = new News(sectionName, webPubDate, webTitle,authorFullName ,url);

                // Add the new {@link News} to the list of news items.
                news.add(newsItem);
            }
        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print out a log message with the exception.
            Log.e(LOG_TAG, "extractFeatureFromJson: Problem parsing the news items JSON results", e);
        }
        // Return list of news
        return news;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // if the URL is null then return early
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == SUCCESS_CODE) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "makeHttpRequest: Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "makeHttpRequest: Problem retrieving the news JSON results", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies that an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl){
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "createUrl: Problem building the URL", e);
        }
        return url;
    }
}
