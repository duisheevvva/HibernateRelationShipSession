package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name ="tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "task_gen")
    @SequenceGenerator(name = "task_gen",sequenceName = "task_seq")
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;

    @OneToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH},mappedBy = "task")
    private Lesson lesson;
}
