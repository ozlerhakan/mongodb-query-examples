package com.kodcu.mongodb.spring.twitter.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Hakan on 4/27/2015.
 */
@Document(collection = "tweets", language = "turkish")
public class Tweet {

    @Id
    private String tid;
    private User user;
    private Media extended_entities;
    private TweetEntity entities;

    private long id;
    private int retweet_count;
    private int favorite_count;

    @TextIndexed
    private String text;
    private String lang;
    private String source;
    private String id_str;
    private String created_at;

    private boolean truncated;
    private boolean favorited;
    private boolean retweeted;
    private boolean possibly_sensitive;
    private boolean possibly_sensitive_appealable;

    private Object geo;
    private Object place;
    private Object coordinates;
    private Object contributors;
    private Object in_reply_to_user_id;
    private Object in_reply_to_status_id;
    private Object in_reply_to_user_id_str;
    private Object in_reply_to_screen_name;
    private Object in_reply_to_status_id_str;

    public String getTid() {
        return tid;
    }

    public Object getContributors() {
        return contributors;
    }

    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }

    public Object getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Object coodinates) {
        this.coordinates = coodinates;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Media getExtended_entities() {
        return extended_entities;
    }

    public void setExtended_entities(Media extended_entities) {
        this.extended_entities = extended_entities;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public Object getGeo() {
        return geo;
    }

    public void setGeo(Object geo) {
        this.geo = geo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public Object getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public void setIn_reply_to_screen_name(Object in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public Object getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public void setIn_reply_to_status_id(Object in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public Object getIn_reply_to_status_id_str() {
        return in_reply_to_status_id_str;
    }

    public void setIn_reply_to_status_id_str(Object in_reply_to_status_id_str) {
        this.in_reply_to_status_id_str = in_reply_to_status_id_str;
    }

    public Object getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id(Object in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public Object getIn_reply_to_user_id_str() {
        return in_reply_to_user_id_str;
    }

    public void setIn_reply_to_user_id_str(Object in_reply_to_user_id_str) {
        this.in_reply_to_user_id_str = in_reply_to_user_id_str;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Object getPlace() {
        return place;
    }

    public void setPlace(Object place) {
        this.place = place;
    }

    public boolean isPossibly_sensitive() {
        return possibly_sensitive;
    }

    public void setPossibly_sensitive(boolean possibly_sensitive) {
        this.possibly_sensitive = possibly_sensitive;
    }

    public boolean isPossibly_sensitive_appealable() {
        return possibly_sensitive_appealable;
    }

    public void setPossibly_sensitive_appealable(boolean possibly_sensitive_appealable) {
        this.possibly_sensitive_appealable = possibly_sensitive_appealable;
    }

    public int getRetweet_count() {
        return retweet_count;
    }

    public void setRetweet_count(int retweet_count) {
        this.retweet_count = retweet_count;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TweetEntity getEntities() {
        return entities;
    }

    public Tweet setEntities(TweetEntity entities) {
        this.entities = entities;
        return this;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "_id='" + tid + '\'' +
                ", user=" + user +
                ", extended_entities=" + extended_entities +
                ", entities=" + entities +
                ", id=" + id +
                ", retweet_count=" + retweet_count +
                ", favorite_count=" + favorite_count +
                ", text='" + text + '\'' +
                ", lang='" + lang + '\'' +
                ", source='" + source + '\'' +
                ", id_str='" + id_str + '\'' +
                ", created_at='" + created_at + '\'' +
                ", truncated=" + truncated +
                ", favorited=" + favorited +
                ", retweeted=" + retweeted +
                ", possibly_sensitive=" + possibly_sensitive +
                ", possibly_sensitive_appealable=" + possibly_sensitive_appealable +
                ", geo=" + geo +
                ", place=" + place +
                ", coordinates=" + coordinates +
                ", contributors=" + contributors +
                ", in_reply_to_user_id=" + in_reply_to_user_id +
                ", in_reply_to_status_id=" + in_reply_to_status_id +
                ", in_reply_to_user_id_str=" + in_reply_to_user_id_str +
                ", in_reply_to_screen_name=" + in_reply_to_screen_name +
                ", in_reply_to_status_id_str=" + in_reply_to_status_id_str +
                '}';
    }
}
