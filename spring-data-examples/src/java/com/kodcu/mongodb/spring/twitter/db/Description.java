package com.kodcu.mongodb.spring.twitter.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakan on 4/27/2015.
 */
class Description {

    private List<Url> urls = new ArrayList<Url>();

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Description{" +
                "urls=" + urls +
                '}';
    }
}
