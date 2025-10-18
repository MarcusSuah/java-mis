package unilak.ac.rw.mis_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unilak.ac.rw.mis_project.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
