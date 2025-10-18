package unilak.ac.rw.mis_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unilak.ac.rw.mis_project.entity.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
}
