package ru.practicum.main_service.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.main_service.MainCommonUtils;
import ru.practicum.main_service.event.enums.EventStateAction;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventUserRequest {
    @Size(min = MainCommonUtils.MIN_LENGTH_ANNOTATION, max = MainCommonUtils.MAX_LENGTH_ANNOTATION)
    private String annotation;

    private Long category;

    @Size(min = MainCommonUtils.MIN_LENGTH_DESCRIPTION, max = MainCommonUtils.MAX_LENGTH_DESCRIPTION)
    private String description;

    @JsonFormat(pattern = MainCommonUtils.DT_FORMAT, shape = JsonFormat.Shape.STRING)
    private LocalDateTime eventDate;

    @Valid
    private LocationDto location;

    private Boolean paid;

    @PositiveOrZero
    private Integer participantLimit;

    private Boolean requestModeration;

    private EventStateAction stateAction;

    @Size(min = MainCommonUtils.MIN_LENGTH_TITLE, max = MainCommonUtils.MAX_LENGTH_TITLE)
    private String title;
}
