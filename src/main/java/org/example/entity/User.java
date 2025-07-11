package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;

    @Column(name = "telegram_chat_id")
    private String telegramChatId;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
