package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_gen")
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq")
    private Long id;
    private String firstName;
    private String email;
    private LocalDate dateOfBirth;

    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private List<Course>courses;
}
