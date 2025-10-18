package unilak.ac.rw.mis_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unilak.ac.rw.mis_project.entity.Faculty;
import unilak.ac.rw.mis_project.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    public FacultyRepository facultyRepository;

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFacultyById(int id) {
        return facultyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public void deleteFacultyById(int id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
}