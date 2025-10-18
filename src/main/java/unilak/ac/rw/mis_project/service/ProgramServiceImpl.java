package unilak.ac.rw.mis_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unilak.ac.rw.mis_project.entity.Program;
import unilak.ac.rw.mis_project.repository.ProgramRepository;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    public ProgramRepository programRepository;

    @Override
    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    @Override
    public Program getProgramById(int id) {
        return programRepository.findById(id).orElse(null);
    }

    @Override
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public void deleteProgramById(int id) {
        programRepository.deleteById(id);
    }

    @Override
    public Program updateProgram(Program program) {
        return programRepository.save(program);
    }
}
