package org.example.dto;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class SendMessageRequest {

    @Schema(example = "Привет, как дела?")
    private String content;
}
