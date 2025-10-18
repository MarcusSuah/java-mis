package unilak.ac.rw.mis_project.service;

import unilak.ac.rw.mis_project.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    Course getCourseById(int id);
    List<Course> getAllCourses();
    void deleteCourseById(int id);
    Course updateCourse(Course course);
}