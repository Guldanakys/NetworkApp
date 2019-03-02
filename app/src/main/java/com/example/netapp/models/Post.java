package com.example.netapp.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("id")
    private int mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("body")
    private String mBody;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    @NonNull
    @Override
    public String toString() {
        return "Post - " + mId + " " + mTitle + '\'';
    }
}
