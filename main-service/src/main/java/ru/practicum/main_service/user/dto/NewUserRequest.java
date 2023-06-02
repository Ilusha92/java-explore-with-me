package ru.practicum.main_service.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewUserRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name;
}
