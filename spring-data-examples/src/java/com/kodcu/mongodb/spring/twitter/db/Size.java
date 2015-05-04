package com.kodcu.mongodb.spring.twitter.db;


/**
 * Created by Hakan on 4/27/2015.
 */
class Size {
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
