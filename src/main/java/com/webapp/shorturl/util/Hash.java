package com.webapp.shorturl.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@Scope("singleton")
public class Hash {
    /**
     * @param input A String to be hashed
     * @return Hashed String(hex) using Md5 algorithms
     * @see <a href="https://stackoverflow.com/a/30119004">Stack Overflow</a>
     */
    public String getMd5(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(input));
            // Convert byte array into signum representation
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
