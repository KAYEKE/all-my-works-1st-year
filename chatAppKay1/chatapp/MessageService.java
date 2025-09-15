package com.chatapp.service;

import com.chatapp.model.Message;
import com.chatapp.util.HashGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class provides messaging services such as sending,
 * retrieving, and managing messages.
 */
public class MessageService {
    private List<Message> messages;
    private List<Message> sentMessages;
    private List<Message> storedMessages;
    private List<Message> disregardedMessages;
    private UserService userService;

    /**
     * Constructor
     *
     * @param userService The user service for authentication
     */
    public MessageService(UserService userService) {
        this.messages = new ArrayList<>();
        this.sentMessages = new ArrayList<>();
        this.storedMessages = new ArrayList<>();
        this.disregardedMessages = new ArrayList<>();
        this.userService = userService;
    }

    /**
     * Sends a message from one user to another.
     *
     * @param sender Message sender
     * @param recipient Message recipient
     * @param content Message content
     * @return A success message with the message ID or an error message
     */
    public String sendMessage(String sender, String recipient, String content) {
        // Check if the sender is logged in
        if (!userService.isUserLoggedIn(sender)) {
            return "Error: You must be logged in to send messages.";
        }

        // Check if the recipient exists
        if (userService.findUserByUsername(recipient).isEmpty()) {
            return "Error: Recipient does not exist.";
        }

        // Validate message content
        if (!HashGenerator.isValidMessageContent(content)) {
            return "Error: " + HashGenerator.getContentErrorMessage();
        }

        // Generate message ID and hash
        String messageId = HashGenerator.generateMessageId();
        String hash = HashGenerator.createMessageHash(messageId, sender, recipient, content);

        // Create and store the message
        Message message = new Message(messageId, sender, recipient, content, hash);
        messages.add(message);
        sentMessages.add(message);

        return "Message sent successfully! Message ID: " + messageId;
    }

/**
 * Retrieves messages for a specific user (sent or received).
 *
 * @param username The username to get messages for