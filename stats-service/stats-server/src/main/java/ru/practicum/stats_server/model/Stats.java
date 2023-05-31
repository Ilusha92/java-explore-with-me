package ru.practicum.stats_server.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stats", schema = "public")
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "app_name", nullable = false)
    private String app;

    @Column(nullable = false)
    private String uri;

    @Column(name = "user_ip", nullable = false, length = 15)
    private String ip;

    @Column(name = "created", nullable = false)
    private LocalDateTime timestamp;
}
