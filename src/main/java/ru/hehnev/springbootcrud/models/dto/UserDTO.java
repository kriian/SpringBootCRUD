package ru.hehnev.springbootcrud.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NotBlank(message = "Поле имя не может быть пустым.")
    private String name;

    @NotBlank(message = "Поле mail не может быть пустым.")
    @Email(message = "Не корректный email.")
    private String mail;
}
