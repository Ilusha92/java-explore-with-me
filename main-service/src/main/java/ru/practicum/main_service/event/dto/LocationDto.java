package ru.practicum.main_service.event.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    @NotNull
    private Float lat;

    @NotNull
    private Float lon;
}
