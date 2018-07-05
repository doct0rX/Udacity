package com.example.doctorx.newsappstage1;

public class News {

    /** Section ID of the news item */
    private String mSectionName;

    /** Web title of the news item */
    private String mWebTitle;

    /** Date the news item was published */
    private String mDate;

    /** Author First name and Last name */
    private String mAuthor;

    /** Website URL of the earthquake */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     * @param sectionName Section Name
     * @param date News Date
     * @param webTitle Title for website
     * @param url URL to open in browser
     */
    public News(String sectionName, String date, String webTitle,String author, String url) {
        mSectionName = sectionName;
        mDate = date;
        mWebTitle = webTitle;
        mAuthor = author;
        mUrl = url;
    }

    /**
     * getter method for returning private variables
     */
    public String getmSectionName() {
        return mSectionName;
    }

    public String getWebTitle() {
        return mWebTitle;
    }

    public String getNewsData() {
        return mDate;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getUrl() {
        return mUrl;
    }
}
