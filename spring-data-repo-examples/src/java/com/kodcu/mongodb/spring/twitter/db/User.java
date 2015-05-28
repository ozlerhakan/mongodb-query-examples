package com.kodcu.mongodb.spring.twitter.db;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Hakan on 4/27/2015.
 */
class User {

    private Integer id;
    private UserEntity entities;
    private Integer utc_offset;
    private Object profile_location;

    private int listed_count;
    private int friends_count;
    private int statuses_count;
    private int followers_count;
    private int favourites_count;

    private String url;
    private String name;
    private String lang;
    private String id_str;
    private String location;
    private String time_zone;
    private String created_at;
    private String description;
    private String screen_name;
    private String profile_image_url;
    private String profile_link_color;
    private String profile_text_color;
    private String default_profile_image;
    private String profile_image_url_https;
    private String profile_background_color;
    private String profile_sidebar_fill_color;
    private String profile_sidebar_border_color;
    private String profile_background_image_url;
    private String profile_use_background_image;
    private String profile_background_image_url_https;

    private boolean verified;
    private boolean following;
    private boolean geo_enabled;
    private boolean is_translator;
    private boolean notifications;
    @Field("protected")
    private boolean userProtected;
    private boolean default_profile;
    private boolean follow_request_sent;
    private boolean contributors_enabled;
    private boolean is_translation_enabled;
    private boolean profile_background_title;

    public boolean isContributors_enabled() {
        return contributors_enabled;
    }

    public void setContributors_enabled(boolean contributors_enabled) {
        this.contributors_enabled = contributors_enabled;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isDefault_profile() {
        return default_profile;
    }

    public void setDefault_profile(boolean default_profile) {
        this.default_profile = default_profile;
    }

    public String getDefault_profile_image() {
        return default_profile_image;
    }

    public void setDefault_profile_image(String default_profile_image) {
        this.default_profile_image = default_profile_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getEntities() {
        return entities;
    }

    public void setEntities(UserEntity entities) {
        this.entities = entities;
    }

    public int getFavourites_count() {
        return favourites_count;
    }

    public void setFavourites_count(int favourites_count) {
        this.favourites_count = favourites_count;
    }

    public boolean isFollow_request_sent() {
        return follow_request_sent;
    }

    public void setFollow_request_sent(boolean follow_request_sent) {
        this.follow_request_sent = follow_request_sent;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public int getFriend_count() {
        return friends_count;
    }

    public void setFriend_count(int friends_count) {
        this.friends_count = friends_count;
    }

    public boolean isGeo_enabled() {
        return geo_enabled;
    }

    public void setGeo_enabled(boolean geo_enabled) {
        this.geo_enabled = geo_enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public boolean is_translation_enabled() {
        return is_translation_enabled;
    }

    public void setIs_translation_enabled(boolean is_translation_enabled) {
        this.is_translation_enabled = is_translation_enabled;
    }

    public boolean is_translator() {
        return is_translator;
    }

    public void setIs_translator(boolean is_translator) {
        this.is_translator = is_translator;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getListed_count() {
        return listed_count;
    }

    public void setListed_count(int listed_count) {
        this.listed_count = listed_count;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public boolean isProfile_background_title() {
        return profile_background_title;
    }

    public void setProfile_background_title(boolean profile_backgroud_title) {
        this.profile_background_title = profile_backgroud_title;
    }

    public String getProfile_background_color() {
        return profile_background_color;
    }

    public void setProfile_background_color(String profile_background_color) {
        this.profile_background_color = profile_background_color;
    }

    public String getProfile_background_image_url() {
        return profile_background_image_url;
    }

    public void setProfile_background_image_url(String profile_background_image_url) {
        this.profile_background_image_url = profile_background_image_url;
    }

    public String getProfile_background_image_url_https() {
        return profile_background_image_url_https;
    }

    public void setProfile_background_image_url_https(String profile_background_image_url_https) {
        this.profile_background_image_url_https = profile_background_image_url_https;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }

    public String getProfile_link_color() {
        return profile_link_color;
    }

    public void setProfile_link_color(String profile_link_color) {
        this.profile_link_color = profile_link_color;
    }

    public Object getProfile_location() {
        return profile_location;
    }

    public void setProfile_location(Object profile_location) {
        this.profile_location = profile_location;
    }

    public String getProfile_sidebar_border_color() {
        return profile_sidebar_border_color;
    }

    public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
        this.profile_sidebar_border_color = profile_sidebar_border_color;
    }

    public String getProfile_sidebar_fill_color() {
        return profile_sidebar_fill_color;
    }

    public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
        this.profile_sidebar_fill_color = profile_sidebar_fill_color;
    }

    public String getProfile_text_color() {
        return profile_text_color;
    }

    public void setProfile_text_color(String profile_text_color) {
        this.profile_text_color = profile_text_color;
    }

    public String getProfile_use_background_image() {
        return profile_use_background_image;
    }

    public void setProfile_use_background_image(String profile_use_background_image) {
        this.profile_use_background_image = profile_use_background_image;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public int getStatuses_count() {
        return statuses_count;
    }

    public void setStatuses_count(int statuses_count) {
        this.statuses_count = statuses_count;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUser_protected() {
        return userProtected;
    }

    public void setUser_protected(boolean user_protected) {
        this.userProtected = user_protected;
    }

    public Integer getUtc_offset() {
        return utc_offset;
    }

    public void setUtc_offset(Integer utc_offset) {
        this.utc_offset = utc_offset;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "User{" +
                "contributors_enabled=" + contributors_enabled +
                ", url='" + url + '\'' +
                ", entities=" + entities +
                ", friend_count=" + friends_count +
                ", profile_image_url='" + profile_image_url + '\'' +
                ", default_profile_image='" + default_profile_image + '\'' +
                ", profile_sidebar_fill_color='" + profile_sidebar_fill_color + '\'' +
                ", notifications=" + notifications +
                ", id=" + id +
                ", id_str='" + id_str + '\'' +
                ", geo_enabled=" + geo_enabled +
                ", profile_background_title=" + profile_background_title +
                ", default_profile=" + default_profile +
                ", user_protected=" + userProtected +
                ", created_at='" + created_at + '\'' +
                ", utc_offset=" + utc_offset +
                ", profile_background_image_url_https='" + profile_background_image_url_https + '\'' +
                ", profile_use_background_image='" + profile_use_background_image + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", time_zone='" + time_zone + '\'' +
                ", statuses_count=" + statuses_count +
                ", is_translation_enabled=" + is_translation_enabled +
                ", profile_background_color='" + profile_background_color + '\'' +
                ", profile_background_image_url='" + profile_background_image_url + '\'' +
                ", profile_link_color='" + profile_link_color + '\'' +
                ", following=" + following +
                ", profile_location=" + profile_location +
                ", followers_count=" + followers_count +
                ", listed_count=" + listed_count +
                ", is_translator=" + is_translator +
                ", profile_image_url_https='" + profile_image_url_https + '\'' +
                ", profile_sidebar_border_color='" + profile_sidebar_border_color + '\'' +
                ", profile_text_color='" + profile_text_color + '\'' +
                ", screen_name='" + screen_name + '\'' +
                ", description='" + description + '\'' +
                ", favourites_count=" + favourites_count +
                ", verified=" + verified +
                ", lang='" + lang + '\'' +
                ", follow_request_sent=" + follow_request_sent +
                '}';
    }
}
