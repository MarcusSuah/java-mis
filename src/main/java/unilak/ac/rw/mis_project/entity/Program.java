package unilak.ac.rw.mis_project.entity;

import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "programs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private Integer durationYears;
    private String degreeType;

}
