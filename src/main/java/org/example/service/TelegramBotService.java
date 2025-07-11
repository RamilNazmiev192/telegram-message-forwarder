package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.telegram.MyTelegramBot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@RequiredArgsConstructor
public class TelegramBotService {

    private final MyTelegramBot telegramBot;

    public void sendToUser(String chatId, String message) {
        SendMessage sendMessage = new SendMessage(chatId, message);

        try {
            telegramBot.execute(sendMessage); // ✅ отправка в Telegram
            System.out.println("📤 Сообщение отправлено в Telegram: " + message);
        } catch (TelegramApiException e) {
            System.err.println("❌ Ошибка отправки в Telegram: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
