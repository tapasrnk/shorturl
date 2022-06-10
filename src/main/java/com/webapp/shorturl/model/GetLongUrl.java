package com.webapp.shorturl.model;

public class GetLongUrl {
    private ShortUrl shortUrl;

    public ShortUrl getShortUrl() {
        return shortUrl;
    }

    @Override
    public String toString() {
        return "GetLongUrl{" + "shortUrl=" + shortUrl + '}';
    }
}
