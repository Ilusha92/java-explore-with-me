package ru.practicum.main_service.comment.dto;

import lombok.*;
import ru.practicum.main_service.MainCommonUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewCommentDto {
    @NotBlank
    @Size(min = MainCommonUtils.MIN_LENGTH_COMMENT, max = MainCommonUtils.MAX_LENGTH_COMMENT)
    private String text;
}
