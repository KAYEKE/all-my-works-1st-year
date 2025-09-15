import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 * Main application class that handles the user interface and flow control
 */
public class MainApp {
    private static boolean isLoggedIn = false;
    private static List<Message> sentMessages = new ArrayList<>();
    private static List<Message> storedMessages = new ArrayList<>();
    private static int messageCounter = 0;

    public static void main(String[] args) {
        // Login process
        while (!isLoggedIn) {
            String username = JOptionPane.showInputDialog("Enter username:");
            String password = JOptionPane.showInputDialog("Enter password:");

            UserAuth auth = new UserAuth(username, password);
            isLoggedIn = auth.login();

            if (!isLoggedIn) {
                JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
            }
        }

        // Main menu loop
        boolean running = true;
        while (running && isLoggedIn) {
            String menuOption = JOptionPane.showInputDialog(
                    "Welcome to QuickChat.\n\n" +
                            "1) Send Messages\n" +
                            "2) Show recently sent messages\n" +
                            "3) Quit"
            );

            switch (menuOption) {
                case "1":
                    sendMessages();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon.");
                    break;
                case "3":
                    running = false;
                    JOptionPane.showMessageDialog(null, "Thank you for using QuickChat. Goodbye!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }


    //Handles the message sending process

    private static void sendMessages() {
        String input = JOptionPane.showInputDialog("How many messages would you like to send?");
        int messagesToSend;

        try {
            messagesToSend = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number. Please enter a numeric value.");
            return;
        }

        for (int i = 0; i < messagesToSend; i++) {
            String recipient = JOptionPane.showInputDialog("Enter recipient number (with international code, max 12 characters):");
            String messageText = JOptionPane.showInputDialog("Enter message text (max 250 characters):");

            Message message = new Message(generateMessageID(), messageCounter, recipient, messageText);

            int recipientValidation = message.checkRecipientCell();
            if (recipientValidation != 1) {
                JOptionPane.showMessageDialog(null, "Incorrectly formatted phone number. Please include international code or use only digits.");
                i--; // Retry this message
                continue;
            }

            if (!message.checkMessageID()) {
                JOptionPane.showMessageDialog(null, "Message ID error. Please try again.");
                i--; // Retry this message
                continue;
            }

            int messageLength = messageText.length();
            if (messageLength > 250) {
                JOptionPane.showMessageDialog(null,
                        "Message exceeds 250 characters by " + (messageLength - 250) + ", please reduce size.");
                i--; // Retry this message
                continue;
            }

            // Process message
            String action = JOptionPane.showInputDialog(
                    "Message ready to send.\n" +
                            "1) Send message\n" +
                            "2) Disregard message\n" +
                            "3) Store message to send later"
            );

            switch (action) {
                case "1":
                    message.sentMessage();
                    sentMessages.add(message);
                    messageCounter++;

                    // Display confirmation with JOptionPane
                    JOptionPane.showMessageDialog(null,
                            "Message successfully sent.\n\n" +
                                    "Message ID: " + message.getMessageID() + "\n" +
                                    "Message Hash: " + message.createMessageHash() + "\n" +
                                    "Recipient: " + message.getRecipient() + "\n" +
                                    "Content: " + message.getMessageText()
                    );
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, "Press 0 to delete message.");
                    break;

                case "3":
                    message.storeMessage();
                    storedMessages.add(message);
                    messageCounter++;
                    JOptionPane.showMessageDialog(null, "Message successfully stored.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Message disregarded.");
            }
        }

        // Display total sent messages
        JOptionPane.showMessageDialog(null, "Total messages sent: " + sentMessages.size());
    }


    // Generates a random 10-digit message ID
    // @return A string containing the message ID

    private static String generateMessageID() {
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append((int) (Math.random() * 10));
        }
        return id.toString();
    }
}