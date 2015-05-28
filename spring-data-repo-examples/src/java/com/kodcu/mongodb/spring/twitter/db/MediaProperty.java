package com.kodcu.mongodb.spring.twitter.db;

import java.util.Arrays;

/**
 * Created by Hakan on 4/27/2015.
 */
class MediaProperty {

    private Long id;
    private Size sizes;
    private int[] indices;

    private String url;
    private String type;
    private String id_str;
    private String media_url;
    private String display_url;
    private String expanded_url;
    private String media_url_https;

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
        return "MediaProperty{" +
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

    public class Size {
        private Large large;
        private Thumb thumb;
        private Small small;
        private Medium medium;

        public Large getLarge() {
            return large;
        }

        public void setLarge(Large large) {
            this.large = large;
        }

        public Medium getMedium() {
            return medium;
        }

        public void setMedium(Medium medium) {
            this.medium = medium;
        }

        public Small getSmall() {
            return small;
        }

        public void setSmall(Small small) {
            this.small = small;
        }

        public Thumb getThumb() {
            return thumb;
        }

        public void setThumb(Thumb thumb) {
            this.thumb = thumb;
        }

        public class Large {
            private  int w;
            private  int h;
            private  String resize;

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public String getResize() {
                return resize;
            }

            public void setResize(String resize) {
                this.resize = resize;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            @Override
            public String toString() {
                return "Large{" +
                        "h=" + h +
                        ", w=" + w +
                        ", resize='" + resize + '\'' +
                        '}';
            }
        }

        public class Thumb {
            private  int w;
            private  int h;
            private  String resize;

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public String getResize() {
                return resize;
            }

            public void setResize(String resize) {
                this.resize = resize;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            @Override
            public String toString() {
                return "Thumb{" +
                        "h=" + h +
                        ", w=" + w +
                        ", resize='" + resize + '\'' +
                        '}';
            }
        }

        public class Small {
            private  int w;
            private  int h;
            private  String resize;

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public String getResize() {
                return resize;
            }

            public void setResize(String resize) {
                this.resize = resize;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            @Override
            public String toString() {
                return "Small{" +
                        "h=" + h +
                        ", w=" + w +
                        ", resize='" + resize + '\'' +
                        '}';
            }
        }

        public class Medium {
            private  int w;
            private  int h;
            private  String resize;

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public String getResize() {
                return resize;
            }

            public void setResize(String resize) {
                this.resize = resize;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            @Override
            public String toString() {
                return "Medium{" +
                        "h=" + h +
                        ", w=" + w +
                        ", resize='" + resize + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Size{" +
                    "large=" + large +
                    ", thumb=" + thumb +
                    ", small=" + small +
                    ", medium=" + medium +
                    '}';
        }
    }

}
