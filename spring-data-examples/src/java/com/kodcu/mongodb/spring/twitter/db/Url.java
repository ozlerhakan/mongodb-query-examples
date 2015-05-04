package com.kodcu.mongodb.spring.twitter.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakan on 4/27/2015.
 */
class Url {

    List<UrlProperty> urls = new ArrayList<UrlProperty>();

    public List<UrlProperty> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlProperty> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Url{" +
                "urls=" + urls +
                '}';
    }
}
