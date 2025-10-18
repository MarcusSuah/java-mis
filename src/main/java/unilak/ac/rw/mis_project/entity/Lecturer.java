package unilak.ac.rw.mis_project.entity;

import jakarta.persistence.*;
import  lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lecturers")

public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String specialization;
    private LocalDate hireDate;

}
