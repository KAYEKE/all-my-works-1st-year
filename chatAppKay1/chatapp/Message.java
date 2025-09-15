package com.chatapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a message exchanged between users.
 */
public class Message {
    private String messageId;      // Unique 10-digit ID
    private String sender;         // Sender
    private String recipient;      // Recipient
    private String content;        // Message content
    private String hash;           // Security hash
    private String status;         // Message status: SENT, STORED, DISREGARDED
    private LocalDateTime timestamp; // Timestamp

    /**
     * Default constructor
     */
    public Message() {
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Constructor with parameters
     *
     * @param messageId Unique message identifier
     * @param sender Message sender
     * @param recipient Message recipient
     * @param content Message content
     * @param hash Security hash
     */
    public Message(String messageId, String sender, String recipient, String content, String hash) {
        this.messageId = messageId;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.hash = hash;
        this.status = "SENT";  // Default status
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Formats the timestamp as a readable string.
     *
     * @return The formatted timestamp
     */
    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

    /**
     * Returns the length of the message content.
     *
     * @return The number of characters in the content
     */
    public int getContentLength() {
        return content != null ? content.length() : 0;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", contentLength=" + getContentLength() +
                ", status='" + status + '\'' +
                ", timestamp=" + getFormattedTimestamp() +
                '}';
    }
}