package com.kodcu.mongodb.spring.twitter.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hakan on 5/5/2015.
 */
class TweetEntity {

    private List<MediaProperty> media = new ArrayList<>();
    private List<URLEntity> urls = new ArrayList<>();
    private List<HashTagEntity> hashtags = new ArrayList<>();
    private List<MentionEntity> user_mentions = new ArrayList<>();
    private List<SymbolEntity> symbols = new ArrayList<>();

    public List<HashTagEntity> getHashtags() {
        return hashtags;
    }

    public List<MediaProperty> getMedia() {
        return media;
    }

    public List<SymbolEntity> getSymbols() {
        return symbols;
    }

    public List<URLEntity> getUrls() {
        return urls;
    }

    public List<MentionEntity> getUser_mentions() {
        return user_mentions;
    }

    class HashTagEntity {
        private String text;
        private int[] indices;

        @Override
        public String toString() {
            return "HashTagEntity{" +
                    "indices=" + Arrays.toString(indices) +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    class SymbolEntity {
        private String text;
        private int[] indices;

        @Override
        public String toString() {
            return "SymbolEntity{" +
                    "indices=" + Arrays.toString(indices) +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    class MentionEntity {
        private Integer id;
        private String id_str;
        private String screen_name;
        private String name;
        private int[] indices;

        @Override
        public String toString() {
            return "MentionEntity{" +
                    "id=" + id +
                    ", id_str='" + id_str + '\'' +
                    ", screen_name='" + screen_name + '\'' +
                    ", name='" + name + '\'' +
                    ", indices=" + Arrays.toString(indices) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TweetEntity{" +
                "hashtags=" + hashtags +
                ", media=" + media +
                ", urls=" + urls +
                ", user_mentions=" + user_mentions +
                ", symbols=" + symbols +
                '}';
    }
}
