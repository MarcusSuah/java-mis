package unilak.ac.rw.mis_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unilak.ac.rw.mis_project.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
