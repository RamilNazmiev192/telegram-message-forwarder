package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageResponse {
    private String content;
    private LocalDateTime createdAt;
}
