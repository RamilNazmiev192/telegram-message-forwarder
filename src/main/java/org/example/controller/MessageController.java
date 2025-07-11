package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.MessageResponse;
import org.example.dto.SendMessageRequest;
import org.example.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody SendMessageRequest request) {
        messageService.sendMessage(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<MessageResponse>> getMessages() {
        return ResponseEntity.ok(messageService.getUserMessages());
    }
}
