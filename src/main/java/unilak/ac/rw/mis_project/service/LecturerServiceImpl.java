package unilak.ac.rw.mis_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unilak.ac.rw.mis_project.entity.Lecturer;
import unilak.ac.rw.mis_project.repository.LecturerRepository;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {
    @Autowired
    public LecturerRepository lecturerRepository;

    @Override
    public Lecturer createLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer getLecturerById(int id) {
        return lecturerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public void deleteLecturerById(int id) {
        lecturerRepository.deleteById(id);
    }

    @Override
    public Lecturer updateLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }
}