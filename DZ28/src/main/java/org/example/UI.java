package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends JFrame {
    private JTextArea textArea;

    public UI() {
        setTitle("Bot Messages");
        setSize(400, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);


        loadMessages();

        setVisible(true);
    }


    private void loadMessages() {
        ArrayList<String> messages = DB.read();
        for (String message : messages) {
            textArea.append(message + "\n");
        }
    }
    public void setText(String text) {
        textArea.append(text + "\n");
    }
}
