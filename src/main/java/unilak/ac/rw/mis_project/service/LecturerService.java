package unilak.ac.rw.mis_project.service;

import unilak.ac.rw.mis_project.entity.Lecturer;
import java.util.List;

public interface LecturerService {
    Lecturer createLecturer(Lecturer lecturer);
    Lecturer getLecturerById(int id);
    List<Lecturer> getAllLecturers();
    void deleteLecturerById(int id);
    Lecturer updateLecturer(Lecturer lecturer);
}