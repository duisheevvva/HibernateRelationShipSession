package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name ="lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen",sequenceName = "lesson_seq")
    private Long id;
    private String title;
    private String description;
    private LocalDate publishedDate;
    private String videoLink;
    private boolean isPresentation;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private Course course;

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE})
    private Task task;
}
