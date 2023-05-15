package components.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "compilations")
public class Compilation {

    @Id
    @Column(name = "compilation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "events")
    private List<Event> events;

    @Column(name = "title")
    private String title;

    @Column(name = "pinned")
    private boolean pinned;
}
