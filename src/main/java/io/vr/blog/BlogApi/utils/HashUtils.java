package io.vr.blog.BlogApi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashUtils {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String hash(String password) {
        return encoder.encode(password);
    }

    public static boolean verifyHash(String password, String hash) {
        return encoder.matches(password, hash);
    }
}
