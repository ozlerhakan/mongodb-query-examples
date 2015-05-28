package com.kodcu.mongodb.spring.twitter.db;

import java.util.Arrays;

/**
 * Created by Hakan on 5/5/2015.
 */
class URLEntity {

    private int[] indices;
    private String url;
    private String display_url;
    private String expanded_url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    @Override
    public String toString() {
        return "UrlEntity{" +
                "display_url='" + display_url + '\'' +
                ", indices=" + Arrays.toString(indices) +
                ", url='" + url + '\'' +
                ", expanded_url='" + expanded_url + '\'' +
                '}';
    }
}

