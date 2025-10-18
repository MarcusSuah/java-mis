package unilak.ac.rw.mis_project.service;

import unilak.ac.rw.mis_project.entity.Faculty;
import java.util.List;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);
    Faculty getFacultyById(int id);
    List<Faculty> getAllFaculties();
    void deleteFacultyById(int id);
    Faculty updateFaculty(Faculty faculty);
}