package peaksoft.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_gen")
    @SequenceGenerator(name = "course_gen",sequenceName = "course_seq")
    private Long id;
    private String name;
    private int price;
    private LocalDate dateOfStart;

    @ManyToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.DETACH},mappedBy = "courses")
    private List<Student> students;

    @OneToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE},mappedBy = "course")
    private List<Lesson>lessons;

    @OneToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private List<Mentor>mentors;

}
