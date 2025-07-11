package org.example.telegram;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

@Component
@RequiredArgsConstructor
public class MyTelegramBot extends TelegramLongPollingBot {

    private final UserRepository userRepository;

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Проверка: сообщение пришло от пользователя
        System.out.println("UPDATE: " + update.getMessage().getText());
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            String text = message.getText();

            // Ожидаем: /start username
            if (text.startsWith("/start ")) {
                String username = text.substring(7).trim();

                userRepository.findByUsername(username).ifPresentOrElse(user -> {
                    user.setTelegramChatId(chatId);
                    userRepository.save(user);

                    sendMessage(chatId, "Telegram аккаунт успешно привязан к пользователю: " + username);
                }, () -> sendMessage(chatId, "Пользователь не найден: " + username));
            } else {
                sendMessage(chatId, "Отправь: /start <твой username из системы>");
            }
        }
    }

    private void sendMessage(String chatId, String text) {
        try {
            execute(new SendMessage(chatId, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}