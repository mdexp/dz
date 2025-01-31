package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBot extends TelegramLongPollingBot {
    private UI ui;
    private Long chatId;

    public MyTelegramBot(UI ui) {
        this.ui = ui;
    }

    @Override
    public String getBotUsername() {
        return "java_test_234545bot";
    }

    @Override
    public String getBotToken() {
        return "7747939867:AAGDpfmwS76vQgxkZY0jsGhumK-f_0OV55k";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            chatId = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();
            User user = update.getMessage().getFrom();


            if (!user.getUserName().equals(getBotUsername())) {
                String displayMessage = user.getFirstName() + ": " + messageText;
                ui.appendMessage(displayMessage);
            }
        }
    }


    public void sendMessageFromUI(String text) {
        if (chatId != null && !text.trim().isEmpty()) {
            SendMessage message = new SendMessage();
            message.setChatId(chatId.toString());
            message.setText(text);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                ui.appendMessage("Error: send!");
            }
        } else {
            ui.appendMessage("error: chat id is null!");
        }
    }
}