
package com.cucumber.testng.model;

import java.util.ArrayList;

public class Entities {
    public ArrayList<Object> getHashtags() {
        return hashtags;
    }

    public void setHashtags(ArrayList<Object> hashtags) {
        this.hashtags = hashtags;
    }

    public ArrayList<Object> getSymbols() {
        return symbols;
    }

    public void setSymbols(ArrayList<Object> symbols) {
        this.symbols = symbols;
    }

    public ArrayList<Object> getUser_mentions() {
        return user_mentions;
    }

    public void setUser_mentions(ArrayList<Object> user_mentions) {
        this.user_mentions = user_mentions;
    }

    public ArrayList<Object> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<Object> urls) {
        this.urls = urls;
    }

    ArrayList < Object > hashtags = new ArrayList < Object > ();
    ArrayList < Object > symbols = new ArrayList < Object > ();
    ArrayList < Object > user_mentions = new ArrayList < Object > ();
    ArrayList< Object > urls = new ArrayList < Object > ();


}