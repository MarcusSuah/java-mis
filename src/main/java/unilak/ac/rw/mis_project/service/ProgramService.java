package unilak.ac.rw.mis_project.service;

import unilak.ac.rw.mis_project.entity.Program;
import java.util.List;

public interface ProgramService {
    Program createProgram(Program program);
    Program getProgramById(int id);
    List<Program> getAllPrograms();
    void deleteProgramById(int id);
    Program updateProgram(Program program);
}