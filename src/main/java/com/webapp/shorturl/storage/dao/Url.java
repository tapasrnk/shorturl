package com.webapp.shorturl.storage.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Url {

    @Id
    private String short_url;
    private String long_url;

    /**
     * class constructor
     */
    protected Url() {

    }

    /**
     * class constructor with short url and long url
     *
     * @param short_url short url should be 7 character
     * @param long_url  long url should be between 1 and 2048 character
     */
    public Url(String short_url, String long_url) {
        this.short_url = short_url;
        this.long_url = long_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public String getLong_url() {
        return long_url;
    }

    @Override
    public String toString() {
        return "Url{" + "short_url='" + short_url + '\'' + ", long_url='" + long_url + '\'' + '}';
    }
}
