package ru.practicum.main_service.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.main_service.MainCommonUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewEventDto {
    @NotBlank
    @Size(min = MainCommonUtils.MIN_LENGTH_ANNOTATION, max = MainCommonUtils.MAX_LENGTH_ANNOTATION)
    private String annotation;

    @NotNull
    private Long category;

    @NotBlank
    @Size(min = MainCommonUtils.MIN_LENGTH_DESCRIPTION, max = MainCommonUtils.MAX_LENGTH_DESCRIPTION)
    private String description;

    @NotNull
    @JsonFormat(pattern = MainCommonUtils.DT_FORMAT, shape = JsonFormat.Shape.STRING)
    private LocalDateTime eventDate;

    @NotNull
    @Valid
    private LocationDto location;

    private Boolean paid = false;

    @PositiveOrZero
    private Integer participantLimit = 0;

    private Boolean requestModeration = true;

    @NotBlank
    @Size(min = MainCommonUtils.MIN_LENGTH_TITLE, max = MainCommonUtils.MAX_LENGTH_TITLE)
    private String title;
}
