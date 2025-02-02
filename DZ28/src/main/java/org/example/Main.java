package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            UI ui = new UI();
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            MyTelegramBot myTelegramBot = new MyTelegramBot(ui); // Передаем объект UI в конструктор бота
            botsApi.registerBot(myTelegramBot);
            System.out.println("Bot started successfully!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}