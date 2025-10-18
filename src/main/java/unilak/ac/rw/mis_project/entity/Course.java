package unilak.ac.rw.mis_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title"}))
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private String credits;
}