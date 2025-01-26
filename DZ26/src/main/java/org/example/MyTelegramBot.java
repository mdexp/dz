package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyTelegramBot extends TelegramLongPollingBot {

    private List<Integer> numbers = new ArrayList<>();



    public String getBotUsername() {
        return "java_test_234545bot";
    }



    public String getBotToken() {
        return "7747939867:AAGDpfmwS76vQgxkZY0jsGhumK-f_0OV55k";
    }


    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            int first = 0;
            int second = 0;

            if (userMessage.contains("+")){  // 1+2
                String args[] = userMessage.split("\\+");
                first = Integer.parseInt(args[0]);
                second = Integer.parseInt(args[1]);
                sendMessage(chatId, "Result is: " + (first + second));
            }
            else if (userMessage.contains("-")){  // 1+2
                String args[] = userMessage.split("\\-");
                first = Integer.parseInt(args[0]);
                second = Integer.parseInt(args[1]);
                sendMessage(chatId, "Result is: " + (first - second));
            }
            else if (userMessage.contains("*")){  // 1+2
                String args[] = userMessage.split("\\*");
                first = Integer.parseInt(args[0]);
                second = Integer.parseInt(args[1]);
                sendMessage(chatId, "Result is: " + (first * second));
            }
            else if (userMessage.contains("/")){  // 1+2
                String args[] = userMessage.split("\\/");
                first = Integer.parseInt(args[0]);
                second = Integer.parseInt(args[1]);
                sendMessage(chatId, "Result is: " + (first / second));
            }
            else {
                sendMessage(chatId, "Try a commands:\n<num> + <num>\n<num> - <num>\n<num> / <num>\n<num> * <num>");
            }

        }
    }
    private void sendMessage(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private int calculateSum() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}


