package unilak.ac.rw.mis_project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unilak.ac.rw.mis_project.entity.Student;
import unilak.ac.rw.mis_project.service.StudentService;


@RequestMapping("student")
@RestController
public class StudentController {


    @Autowired
    public StudentService studentService;

    @PostMapping("create")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        Student newStudent = studentService.createStudent(student);
        if(newStudent != null){
            return ResponseEntity.ok(newStudent);
        }else {
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<?> getAllStudents(){
        if(studentService.getAllStudents() != null){
            return ResponseEntity.ok(studentService.getAllStudents());
        }else {
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

    @PutMapping("update/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable int studentId, @RequestBody Student student){
        Student currentStudent = studentService.getStudentById(studentId);
        if(currentStudent == null){
            return ResponseEntity.badRequest().body("Student not found");
        }
        currentStudent.setFirstName(student.getFirstName());
        currentStudent.setLastName(student.getLastName());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setPhoneNumber(student.getPhoneNumber());
        Student updatedStudent = studentService.createStudent(currentStudent);
        if(updatedStudent != null){
            return ResponseEntity.ok(updatedStudent);
        }else {
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable int studentId){
        Student currentStudent = studentService.getStudentById(studentId);
        if(currentStudent == null){
            return ResponseEntity.badRequest().body("Student not found");
        }
        studentService.deleteStudentById(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
