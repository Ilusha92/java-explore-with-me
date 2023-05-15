package components.models;


import components.enums.State;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "events")
public class Event {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "annotation")
    private String annotation;

    @Column(name = "categories")
    private Category category;

    @Column(name = "confirmedRequests")
    private Long confirmedRequestsIds;

    @Column(name = "createdOn")
    private LocalDateTime createdOn;

    @Column(name = "description")
    private String description;

    @Column(name = "eventDate")
    private LocalDateTime eventDate;

    @Column(name = "initiator")
    private User initiator;

    @Column(name = "location")
    private Location location;

    @Column(name = "paid")
    private boolean paid;

    @Column(name = "participantLimit")
    private Long participantLimit;

    @Column(name = "publishedOn")
    private LocalDateTime publishedOn;

    @Column(name = "requestModeration")
    private LocalDateTime requestModeration;

    @Column(name = "state")
    private State state;

    @Column(name = "title")
    private String title;

    @Column(name = "views")
    private Long views;
}
