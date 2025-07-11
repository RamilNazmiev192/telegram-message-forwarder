package org.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Username must not be blank")
    @Schema(example = "ramil", description = "Уникальный логин")
    private String username;

    @NotBlank(message = "Password must not be blank")
    @Schema(example = "123456", description = "Пароль")
    private String password;

    @NotBlank(message = "Name must not be blank")
    @Schema(example = "Рамиль", description = "Отображаемое имя")
    private String name;
}
