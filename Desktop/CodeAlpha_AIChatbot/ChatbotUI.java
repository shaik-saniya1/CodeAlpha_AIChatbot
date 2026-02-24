import javax.swing.*;
import java.awt.*;

public class ChatbotUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private ChatbotEngine engine;

    private final Color OLIVE = new Color(107, 142, 35);
    private final Color LIGHT_OLIVE = new Color(196, 215, 155);

    public ChatbotUI() {

        engine = new ChatbotEngine();

        setTitle("AI Chatbot - CodeAlpha Task 3");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_OLIVE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chatArea.setMargin(new Insets(10,10,10,10));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JButton sendButton = new JButton("Send");
        sendButton.setBackground(OLIVE);
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    private void sendMessage() {

        String userMessage = inputField.getText().trim();

        if (!userMessage.isEmpty()) {

            chatArea.append("You: " + userMessage + "\n");

            String response = engine.getResponse(userMessage);

            chatArea.append("Bot: " + response + "\n\n");

            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatbotUI::new);
    }
}