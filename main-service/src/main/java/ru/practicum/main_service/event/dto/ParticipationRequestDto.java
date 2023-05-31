package ru.practicum.main_service.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.main_service.MainCommonUtils;
import ru.practicum.main_service.event.enums.RequestStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationRequestDto {
    private Long id;
    private Long event;
    private Long requester;

    @JsonFormat(pattern = MainCommonUtils.DT_FORMAT, shape = JsonFormat.Shape.STRING)
    private LocalDateTime created;

    private RequestStatus status;

}
