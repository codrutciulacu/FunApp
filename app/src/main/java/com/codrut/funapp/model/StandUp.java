package com.codrut.funapp.model;

public class StandUp {

    private String mName;
    private String mAuthor;
    private String mStandUpURL;
    private String mThumbnailURL;

    public StandUp(String name, String author, String standUpURL, String thumbnailURL) {
        mName = name;
        mAuthor = author;
        mStandUpURL = standUpURL;
        mThumbnailURL = thumbnailURL;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getStandUpURL() {
        return mStandUpURL;
    }

    public void setStandUpURL(String standUpURL) {
        mStandUpURL = standUpURL;
    }

    public String getThumbnailURL() {
        return mThumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        mThumbnailURL = thumbnailURL;
    }
}
