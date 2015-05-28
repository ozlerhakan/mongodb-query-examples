package com.kodcu.mongodb.spring.twitter.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakan on 4/27/2015.
 */
class Media {

    private List<MediaProperty> media = new ArrayList<>();
    public List<MediaProperty> getMedia() {
        return media;
    }

    public void setMedia(List<MediaProperty> media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Media{" +
                "media=" + media +
                '}';
    }
}
