package com.webapp.shorturl.model;

public class ShortUrl {
    private String shortUrl;

    public ShortUrl(){}
    public ShortUrl(String shorturl) {
        this.shortUrl = shorturl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    @Override
    public String toString() {
        return "ShortUrl{" + "shortUrl='" + shortUrl + '\'' + '}';
    }
}
