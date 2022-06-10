package com.webapp.shorturl.model;

public class LongUrl {
    private String longUrl;

    public LongUrl() {

    }

    public LongUrl(String longUrl){
        this.longUrl = longUrl;
    }
    public String getLongUrl() {
        return longUrl;
    }

    @Override
    public String toString() {
        return "LongUrl{" + "longtUrl='" + longUrl + '\'' + '}';
    }
}
