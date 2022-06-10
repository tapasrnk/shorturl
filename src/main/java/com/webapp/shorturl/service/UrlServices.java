package com.webapp.shorturl.service;

import com.webapp.shorturl.model.CreateShortUrl;
import com.webapp.shorturl.model.LongUrl;
import com.webapp.shorturl.model.ShortUrl;
import com.webapp.shorturl.storage.dao.Url;
import com.webapp.shorturl.storage.daoservice.UrlRepository;
import com.webapp.shorturl.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UrlServices {

    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private Hash hash;
    public ShortUrl createShortUrl(CreateShortUrl createShortUrl) {
        LongUrl longurl = createShortUrl.getLongUrl();

        Optional<Url> url;
        String hashed7char;
        do{
            String hashed = hash.hashMD5(longurl.getLongUrl(), UUID.randomUUID().toString());
            hashed7char = hashed.substring(0,7);
            url = urlRepository.findById(hashed7char);
        }while(url.isPresent());

        urlRepository.save(new Url(hashed7char, longurl.getLongUrl()));
        return new ShortUrl(hashed7char);
    }

    public LongUrl getLongUrl(String shortUrl) {
        Optional<Url> url = urlRepository.findById(shortUrl);
        if (url.isEmpty()) return null;
        return new LongUrl(url.get().getLong_url());
    }
}
