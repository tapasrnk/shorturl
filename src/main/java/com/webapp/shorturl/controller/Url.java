package com.webapp.shorturl.controller;

import com.webapp.shorturl.model.CreateShortUrl;
import com.webapp.shorturl.model.LongUrl;
import com.webapp.shorturl.model.ShortUrl;
import com.webapp.shorturl.service.UrlServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/url")
public class Url {

    @Autowired
    UrlServices urlService;

    @PostMapping("/")
    public ResponseEntity<ShortUrl> createShortUrl(@RequestBody CreateShortUrl createShortUrl) {
        return ResponseEntity.ok(urlService.createShortUrl(createShortUrl));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getLongUrl(@PathVariable String id) {
        LongUrl longUrl = urlService.getLongUrl(id);
        if (longUrl == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longUrl.getLongUrl())).build();
    }
}
