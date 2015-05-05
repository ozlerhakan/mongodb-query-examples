package com.kodcu.mongodb.spring.twitter.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakan on 4/27/2015.
 */
class UserEntity {

    private Description description;
    private Url url;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "description=" + description +
                ", url=" + url +
                '}';
    }

    class Description {
        private List<URLEntity> urls = new ArrayList<>();

        @Override
        public String toString() {
            return "Description{" +
                    "urls=" + urls +
                    '}';
        }
    }

    class Url {

        List<URLEntity> urls = new ArrayList<>();

        public List<URLEntity> getUrls() {
            return urls;
        }

        public void setUrls(List<URLEntity> urls) {
            this.urls = urls;
        }

        @Override
        public String toString() {
            return "Url{" +
                    "urls=" + urls +
                    '}';
        }
    }
}
