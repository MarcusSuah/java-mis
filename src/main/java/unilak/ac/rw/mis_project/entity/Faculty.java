package unilak.ac.rw.mis_project.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "faculties")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String dean;
    private String officeLocation;
}
