package com.jennellew.timeburner.models;

/**
 * Created by jwong on 11/16/13.
 */
public class Works {
    private String mTitle;
    private String mNoOfStories;
    private String mLink;

    public Works(String title, String noOfStories, String link) {
        mTitle = title;
        mNoOfStories = noOfStories;
        mLink = link;
    }

    public String getTitle() { return mTitle; }

    public String getNoOfStories() { return mNoOfStories; }

    public String getLink() { return mLink; }
}
