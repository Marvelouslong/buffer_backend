package com.os.buffer_backend.util;

import java.security.SecureRandom;

public class RandomData {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static SecureRandom random = new SecureRandom();

    public static String generateRandomString() {
        int length = 1;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        System.out.println("Random String: " + sb.toString());
        return sb.toString();
    }

}
