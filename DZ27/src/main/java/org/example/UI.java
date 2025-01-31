package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private JButton sendButton;
    private MyTelegramBot bot;

    public UI() {
        frame = new JFrame("Telegram Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        sendButton = new JButton("send");
        frame.add(sendButton, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        frame.setVisible(true);
    }


    public void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> textArea.append(message + "\n"));
    }


    public void setBot(MyTelegramBot bot) {
        this.bot = bot;
    }

    private void sendMessage() {
        String messageText = textField.getText().trim();
        if (!messageText.isEmpty()) {
            appendMessage("You: " + messageText);
            textField.setText("");

            bot.sendMessageFromUI(messageText);
        }
    }
}