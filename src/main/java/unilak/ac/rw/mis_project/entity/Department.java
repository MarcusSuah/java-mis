package unilak.ac.rw.mis_project.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String head;
    private String contactEmail;
}
