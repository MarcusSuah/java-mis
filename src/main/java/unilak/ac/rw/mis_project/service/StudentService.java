package unilak.ac.rw.mis_project.service;

import unilak.ac.rw.mis_project.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    void deleteStudentById(int id);
}
