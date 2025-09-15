import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Message class that represents and handles individual messages
 */
public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;

    /**
     * Constructor for Message class
     * @param messageID The 10-digit message ID
     * @param messageNumber Auto-incremented message number
     * @param recipient Recipient phone number
     * @param messageText Message content
     */
    public Message(String messageID, int messageNumber, String recipient, String messageText) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
    }

    /**
     * Checks if the message ID is valid (10 characters or less)
     * @return True if valid, false otherwise
     */
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    /**
     * Validates the recipient phone number format
     * @return 1 if valid, 0 if invalid
     */
    public int checkRecipientCell() {
        // Check if the recipient number starts with a + (international code)
        // and its length is maximum 10 characters
        if (recipient != null && (recipient.startsWith("+") || isNumeric(recipient)) && recipient.length() <= 12) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Helper method to check if a string contains only numbers
     * @param str The string to check
     * @return True if the string contains only numbers
     */
    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Creates a message hash in the format XX:Y:FIRSTLASTWORD
     * @return The formatted message hash
     */
    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2 || messageText == null || messageText.isEmpty()) {
            return "Invalid message for hash creation";
        }

        String firstTwoDigits = messageID.substring(0, 2);

        // Extract first and last word
        String[] words = messageText.trim().split("\\s+");
        if (words.length == 0) {
            return firstTwoDigits + ":" + messageNumber + ":EMPTY";
        }

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return firstTwoDigits + ":" + messageNumber + ":" + firstWord + lastWord;
    }

    /**
     * Handles the message sending process
     * @return Status message about sending
     */
    public String sentMessage() {
        if (messageText.length() <= 250) {
            return "Message successfully sent.";
        } else {
            return "Message exceeds 250 characters by " + (messageText.length() - 250) + ", please reduce size.";
        }
    }

    /**
     * Returns all sent messages
     * @return Formatted string of all sent messages
     */
    public String printMessages() {
        return "Message ID: " + messageID +
                "\nMessage Hash: " + createMessageHash() +
                "\nRecipient: " + recipient +
                "\nContent: " + messageText;
    }

    /**
     * Returns the total number of sent messages
     * @return Always returns 1 for a single message
     */
    public int returnTotalMessages() {
        return 1; // This would be used differently in a collection context
    }

    /**
     * Stores the message in a JSON file
     */
    public void storeMessage() {
        try {
            // Create a simple JSON-like structure
            Map<String, Object> messageData = new HashMap<>();
            messageData.put("messageID", messageID);
            messageData.put("messageNumber", messageNumber);
            messageData.put("recipient", recipient);
            messageData.put("messageText", messageText);
            messageData.put("messageHash", createMessageHash());

            // Convert to JSON string manually
            String jsonString = convertToJsonString(messageData);

            // Write to file
            try (FileWriter file = new FileWriter("stored_messages.json", true)) {
                file.write(jsonString);
                file.flush();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error storing message: " + e.getMessage());
        }
    }

    /**
     * Helper method to convert a Map to a JSON string
     * @param map The map to convert
     * @return JSON string representation
     */
    private String convertToJsonString(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        int size = map.size();
        int count = 0;

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append("  \"").append(entry.getKey()).append("\": ");

            Object value = entry.getValue();
            if (value instanceof String) {
                sb.append("\"").append(value).append("\"");
            } else {
                sb.append(value);
            }

            if (++count < size) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append("}\n");
        return sb.toString();
    }

    // Getters
    public String getMessageID() {
        return messageID;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }
}