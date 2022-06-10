package com.webapp.shorturl.model;

public class CreateShortUrl {
    private LongUrl longUrl;

    public LongUrl getLongUrl() {
        return longUrl;
    }

    @Override
    public String toString() {
        return "CreateShortUrl{" + "longUrl=" + longUrl + '}';
    }
}
