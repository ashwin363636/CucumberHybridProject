package com.cucumber.testng.model;

import com.cucumber.testng.model.Entities;

public class User {
    private long id;
    private String id_str;
    private String name;
    private String screen_name;
    private String location;
    private String description;
    private String url = null;
    Entities EntitiesObject;
    private boolean protectedkey;
    private float followers_count;
    private float friends_count;
    private float listed_count;
    private String created_at;
    private float favourites_count;
    private String utc_offset = null;
    private String time_zone = null;
    private boolean geo_enabled;
    private boolean verified;
    private float statuses_count;
    private String lang = null;
    private boolean contributors_enabled;
    private boolean is_translator;
    private boolean is_translation_enabled;
    private String profile_background_color;
    private String profile_background_image_url = null;
    private String profile_background_image_url_https = null;
    private boolean profile_background_tile;
    private String profile_image_url;
    private String profile_image_url_https;
    private String profile_link_color;
    private String profile_sidebar_border_color;
    private String profile_sidebar_fill_color;
    private String profile_text_color;
    private boolean profile_use_background_image;
    private boolean has_extended_profile;
    private boolean default_profile;
    private boolean default_profile_image;
    private boolean following;
    private boolean follow_request_sent;
    private boolean notifications;
    private String translator_type;


    // Getter Methods

    public long getId() {
        return id;
    }

    public String getId_str() {
        return id_str;
    }

    public String getName() {
        return name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public Entities getEntities() {
        return EntitiesObject;
    }

    public boolean getProtected() {
        return protectedkey;
    }

    public float getFollowers_count() {
        return followers_count;
    }

    public float getFriends_count() {
        return friends_count;
    }

    public float getListed_count() {
        return listed_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public float getFavourites_count() {
        return favourites_count;
    }

    public String getUtc_offset() {
        return utc_offset;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public boolean getGeo_enabled() {
        return geo_enabled;
    }

    public boolean getVerified() {
        return verified;
    }

    public float getStatuses_count() {
        return statuses_count;
    }

    public String getLang() {
        return lang;
    }

    public boolean getContributors_enabled() {
        return contributors_enabled;
    }

    public boolean getIs_translator() {
        return is_translator;
    }

    public boolean getIs_translation_enabled() {
        return is_translation_enabled;
    }

    public String getProfile_background_color() {
        return profile_background_color;
    }

    public String getProfile_background_image_url() {
        return profile_background_image_url;
    }

    public String getProfile_background_image_url_https() {
        return profile_background_image_url_https;
    }

    public boolean getProfile_background_tile() {
        return profile_background_tile;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public String getProfile_link_color() {
        return profile_link_color;
    }

    public String getProfile_sidebar_border_color() {
        return profile_sidebar_border_color;
    }

    public String getProfile_sidebar_fill_color() {
        return profile_sidebar_fill_color;
    }

    public String getProfile_text_color() {
        return profile_text_color;
    }

    public boolean getProfile_use_background_image() {
        return profile_use_background_image;
    }

    public boolean getHas_extended_profile() {
        return has_extended_profile;
    }

    public boolean getDefault_profile() {
        return default_profile;
    }

    public boolean getDefault_profile_image() {
        return default_profile_image;
    }

    public boolean getFollowing() {
        return following;
    }

    public boolean getFollow_request_sent() {
        return follow_request_sent;
    }

    public boolean getNotifications() {
        return notifications;
    }

    public String getTranslator_type() {
        return translator_type;
    }

    // Setter Methods

    public void setId(long id) {
        this.id = id;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEntities(Entities entitiesObject) {
        this.EntitiesObject = entitiesObject;
    }

    public void setProtected(boolean protectedkey) {
        this.protectedkey=protectedkey;
    }

    public void setFollowers_count(float followers_count) {
        this.followers_count = followers_count;
    }

    public void setFriends_count(float friends_count) {
        this.friends_count = friends_count;
    }

    public void setListed_count(float listed_count) {
        this.listed_count = listed_count;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setFavourites_count(float favourites_count) {
        this.favourites_count = favourites_count;
    }

    public void setUtc_offset(String utc_offset) {
        this.utc_offset = utc_offset;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public void setGeo_enabled(boolean geo_enabled) {
        this.geo_enabled = geo_enabled;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setStatuses_count(float statuses_count) {
        this.statuses_count = statuses_count;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setContributors_enabled(boolean contributors_enabled) {
        this.contributors_enabled = contributors_enabled;
    }

    public void setIs_translator(boolean is_translator) {
        this.is_translator = is_translator;
    }

    public void setIs_translation_enabled(boolean is_translation_enabled) {
        this.is_translation_enabled = is_translation_enabled;
    }

    public void setProfile_background_color(String profile_background_color) {
        this.profile_background_color = profile_background_color;
    }

    public void setProfile_background_image_url(String profile_background_image_url) {
        this.profile_background_image_url = profile_background_image_url;
    }

    public void setProfile_background_image_url_https(String profile_background_image_url_https) {
        this.profile_background_image_url_https = profile_background_image_url_https;
    }

    public void setProfile_background_tile(boolean profile_background_tile) {
        this.profile_background_tile = profile_background_tile;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }

    public void setProfile_link_color(String profile_link_color) {
        this.profile_link_color = profile_link_color;
    }

    public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
        this.profile_sidebar_border_color = profile_sidebar_border_color;
    }

    public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
        this.profile_sidebar_fill_color = profile_sidebar_fill_color;
    }

    public void setProfile_text_color(String profile_text_color) {
        this.profile_text_color = profile_text_color;
    }

    public void setProfile_use_background_image(boolean profile_use_background_image) {
        this.profile_use_background_image = profile_use_background_image;
    }

    public void setHas_extended_profile(boolean has_extended_profile) {
        this.has_extended_profile = has_extended_profile;
    }

    public void setDefault_profile(boolean default_profile) {
        this.default_profile = default_profile;
    }

    public void setDefault_profile_image(boolean default_profile_image) {
        this.default_profile_image = default_profile_image;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public void setFollow_request_sent(boolean follow_request_sent) {
        this.follow_request_sent = follow_request_sent;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public void setTranslator_type(String translator_type) {
        this.translator_type = translator_type;
    }
}
