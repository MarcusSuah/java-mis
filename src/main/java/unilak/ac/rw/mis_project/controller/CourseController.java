package unilak.ac.rw.mis_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unilak.ac.rw.mis_project.entity.Course;
import unilak.ac.rw.mis_project.service.CourseService;

@RequestMapping("/course")
@RestController
public class CourseController {
    @Autowired
    public CourseService courseService;

    @PostMapping("create")
    public ResponseEntity<?> createCourse(@RequestBody Course course){
        try{
            Course newCourse = courseService.createCourse(course);
            if (newCourse != null){
                return ResponseEntity.ok(newCourse);
            }else {
                return ResponseEntity.badRequest().body("An error occured");
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("The course already exists");
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<?> getAllCourses(){
        if (courseService.getAllCourses() != null){
            return ResponseEntity.ok(courseService.getAllCourses());
        }else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @PutMapping("update/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable int courseId, @RequestBody Course course){
        Course currentCourse = courseService.getCourseById(courseId);
        if (currentCourse == null){
            return ResponseEntity.badRequest().body("Course not found");
        }
        currentCourse.setTitle(course.getTitle());
        currentCourse.setCredits(course.getCredits());
        Course updatedCourse = courseService.createCourse(currentCourse);
        if(updatedCourse != null){
            return ResponseEntity.ok(updatedCourse);
        }else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @DeleteMapping("delete/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int courseId){
        Course currentCourse = courseService.getCourseById(courseId);
        if (currentCourse == null){
            return ResponseEntity.badRequest().body("Course not found");
        }
        courseService.deleteCourseById(courseId);
        return ResponseEntity.ok("Course deleted successfully.");
    }
}