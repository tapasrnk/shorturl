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
    private String getMd5(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(input));
            // Convert byte array into signum representation
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * rehash the given hash with concatenating with the given param
     * @param input : Any string to be hashed with param
     * @param param : Initially a random sting, later will be replaced by User_id or cookie token.
     * @return : rehashed string
     */
    public String hashMD5(String input, String param) {
        return getMd5(input + param);
    }

}
