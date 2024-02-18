package com.alyas20.projectbased.core.util.generator;

import java.security.SecureRandom;
import java.util.Base64;

public class SaltKeyGenerator {
    // Define the length of the salt key
    private static final Integer SALT_LENGTH = 16; // You can adjust the length as needed

    private SaltKeyGenerator() {
        throw new IllegalStateException("Utility class");
    }

    public static String generateSalt() {
        // Create a secure random number generator
        SecureRandom random = new SecureRandom();

        // Generate a byte array for the salt
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        // Convert the byte array to a Base64-encoded string
        return Base64.getEncoder().encodeToString(salt);
    }
}
