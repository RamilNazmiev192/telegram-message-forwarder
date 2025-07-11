package org.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @Schema(example = "ramil", description = "Логин")
    @NotBlank(message = "Username must not be blank")
    private String username;

    @Schema(example = "123456", description = "Пароль")
    @NotBlank(message = "Password must not be blank")
    private String password;
}
