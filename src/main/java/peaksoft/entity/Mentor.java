package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name ="mentors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "mentor_gen")
    @SequenceGenerator(name = "mentor_gen",sequenceName = "mentor_seq")
    private Long id;
    private String firstName;
    private String email;
    private LocalDate dateOfBirth;
}
