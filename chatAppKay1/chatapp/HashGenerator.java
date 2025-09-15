package com.chatapp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * This class provides methods for generating unique identifiers
 * and hashes for messages, as well as validating message content.
 */
public class HashGenerator {

    /**
     * Generates a unique 10-digit message identifier.
     *
     * @return A unique identifier
     */
    public static String generateMessageId() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        // Generate 10 random digits
        for (int i = 0; i < 10; i++) {
            builder.append(random.nextInt(10));
        }

        return builder.toString();
    }

    /**
     * Creates a custom hash from message details.
     *
     * @param messageId Message identifier
     * @param sender Message sender
     * @param recipient Message recipient
     * @param content Message content
     * @return A SHA-256 hash of the data
     */
    public static String createMessageHash(String messageId, String sender,
                                           String recipient, String content) {
        try {
            // Concatenate the data
            String data = messageId + sender + recipient + content;

            // Create SHA-256 hash
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.getBytes());

            // Convert bytes to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Fallback to a simple hash in case SHA-256 is not available
            return String.valueOf(data.hashCode());
        }
    }

    /**
     * Checks if message content is valid.
     * Valid content must not exceed 250 characters.
     *
     * @param content The message content to validate
     * @return true if the content is valid, false otherwise
     */
    public static boolean isValidMessageContent(String content) {
        return content != null && content.length() <= 250;
    }

    /**
     * Generates an error message for invalid message content.
     *
     * @return Error message for invalid message content
     */
    public static String getContentErrorMessage() {
        return "Message content must not exceed 250 characters.";
    }
}
