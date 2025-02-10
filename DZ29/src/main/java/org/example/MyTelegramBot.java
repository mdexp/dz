package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyTelegramBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "your bot name";
    }

    @Override
    public String getBotToken() {
        return "bot id";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();


            DB.save(userMessage);

            sendToTelegram(userMessage, chatId);
        }
    }

    private void sendToTelegram(String text, String chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
