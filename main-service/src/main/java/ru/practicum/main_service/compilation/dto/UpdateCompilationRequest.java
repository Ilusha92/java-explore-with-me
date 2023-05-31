package ru.practicum.main_service.compilation.dto;

import lombok.*;
import ru.practicum.main_service.MainCommonUtils;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompilationRequest {
    @Size(min = MainCommonUtils.MIN_LENGTH_UPDATE_TITLE, max = MainCommonUtils.MAX_LENGTH_UPDATE_TITLE)
    private String title;

    private Boolean pinned;
    private List<Long> events;
}
