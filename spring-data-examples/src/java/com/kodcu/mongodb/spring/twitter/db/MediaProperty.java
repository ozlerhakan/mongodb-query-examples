package com.kodcu.mongodb.spring.twitter.db;

import java.util.Arrays;

/**
 * Created by Hakan on 4/27/2015.
 */
class MediaProperty {

    private String media_url;
    private String media_url_https;
    private String display_url;
    private String type;
    private Size sizes;
    private Long id;
    private String id_str;
    private int[] indices;
    private String url;
    private String expanded_url;

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public String getExpanded_url() {
        return expanded_url;
    }

    public void setExpanded_url(String expanded_url) {
        this.expanded_url = expanded_url;
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

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getMedia_url_https() {
        return media_url_https;
    }

    public void setMedia_url_https(String media_url_https) {
        this.media_url_https = media_url_https;
    }

    public Size getSizes() {
        return sizes;
    }

    public void setSizes(Size sizes) {
        this.sizes = sizes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MediaComponent{" +
                "display_url='" + display_url + '\'' +
                ", media_url='" + media_url + '\'' +
                ", media_url_https='" + media_url_https + '\'' +
                ", type='" + type + '\'' +
                ", sizes=" + sizes +
                ", id=" + id +
                ", id_str='" + id_str + '\'' +
                ", indices=" + Arrays.toString(indices) +
                ", url='" + url + '\'' +
                ", expanded_url='" + expanded_url + '\'' +
                '}';
    }
}
