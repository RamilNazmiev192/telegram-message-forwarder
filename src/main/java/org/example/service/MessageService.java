package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.MessageResponse;
import org.example.dto.SendMessageRequest;
import org.example.entity.Message;
import org.example.entity.User;
import org.example.repository.MessageRepository;
import org.example.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final TelegramBotService telegramBotService;

    public void sendMessage(SendMessageRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String telegramText = user.getName() + ", я получил от тебя сообщение:\n" + request.getContent();

        if (user.getTelegramChatId() != null) {
            telegramBotService.sendToUser(user.getTelegramChatId(), telegramText);
        }

        Message message = new Message();
        message.setUser(user);
        message.setContent(request.getContent());
        message.setCreatedAt(LocalDateTime.now());
        messageRepository.save(message);
    }

    public List<MessageResponse> getUserMessages() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return messageRepository.findByUser(user).stream()
                .map(msg -> {
                    MessageResponse response = new MessageResponse();
                    response.setContent(msg.getContent());
                    response.setCreatedAt(msg.getCreatedAt());
                    return response;
                })
                .toList();
    }
}
