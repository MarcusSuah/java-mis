package unilak.ac.rw.mis_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unilak.ac.rw.mis_project.entity.Course;
import unilak.ac.rw.mis_project.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    public CourseRepository courseRepository;
    /**
     * @param course
     * @return
     */
    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    /**
     * @return
     */
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    /**
     * @param id
     */
    @Override
    public void deleteCourseById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course updateCourse(Course course) {
        return null;
    }
}