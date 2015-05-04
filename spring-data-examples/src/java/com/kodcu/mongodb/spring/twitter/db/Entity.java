package com.kodcu.mongodb.spring.twitter.db;

/**
 * Created by Hakan on 4/27/2015.
 */
class Entity {

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
}
