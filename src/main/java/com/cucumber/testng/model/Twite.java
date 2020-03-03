package com.cucumber.testng.model;

import com.cucumber.testng.model.Entities;
import com.cucumber.testng.model.User;

public class Twite {
    private String created_at;
    private long id;
    private String id_str;
    private String text;
    private boolean truncated;
    private Entities entities = new Entities();
    private String source;
    private String in_reply_to_status_id = "";
    private String in_reply_to_status_id_str = "";
    private String in_reply_to_user_id = "";
    private String in_reply_to_user_id_str = "";
    private String in_reply_to_screen_name = "";
    private User user = new User();
    private String geo = "";
    private String coordinates = "";
    private String place = "";
    private String contributors = "";
    private boolean is_quote_status;
    private float retweet_count;
    private float favorite_count;
    private boolean favorited;
    private boolean retweeted;
    private String lang;


    // Getter Methods

    public String getCreated_at() {
        return created_at;
    }

    public long getId() {
        return id;
    }

    public String getId_str() {
        return id_str;
    }

    public String getText() {
        return text;
    }

    public boolean getTruncated() {
        return truncated;
    }

    public Entities getEntities() {
        return entities;
    }

    public String getSource() {
        return source;
    }

    public String getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public String getIn_reply_to_status_id_str() {
        return in_reply_to_status_id_str;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public String getIn_reply_to_user_id_str() {
        return in_reply_to_user_id_str;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public User getUser() {
        return user;
    }

    public String getGeo() {
        return geo;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getPlace() {
        return place;
    }

    public String getContributors() {
        return contributors;
    }

    public boolean getIs_quote_status() {
        return is_quote_status;
    }

    public float getRetweet_count() {
        return retweet_count;
    }

    public float getFavorite_count() {
        return favorite_count;
    }

    public boolean getFavorited() {
        return favorited;
    }

    public boolean getRetweeted() {
        return retweeted;
    }

    public String getLang() {
        return lang;
    }

    // Setter Methods

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public void setEntities(Entities entitiesObject) {
        this.entities = entitiesObject;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
        this.in_reply_to_status_id_str = in_reply_to_status_id_str;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
        this.in_reply_to_user_id_str = in_reply_to_user_id_str;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public void setUser(User userObject) {
        this.user = userObject;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public void setIs_quote_status(boolean is_quote_status) {
        this.is_quote_status = is_quote_status;
    }

    public void setRetweet_count(float retweet_count) {
        this.retweet_count = retweet_count;
    }

    public void setFavorite_count(float favorite_count) {
        this.favorite_count = favorite_count;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}