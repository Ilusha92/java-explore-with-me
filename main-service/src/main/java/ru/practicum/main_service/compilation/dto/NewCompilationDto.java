package ru.practicum.main_service.compilation.dto;

import lombok.*;
import ru.practicum.main_service.MainCommonUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class NewCompilationDto {
    @NotBlank
    @Size(min = MainCommonUtils.MIN_LENGTH_TITLE, max = MainCommonUtils.MAX_LENGTH_TITLE)
    private String title;

    private Boolean pinned = false;
    private List<Long> events = new ArrayList<>();
}
