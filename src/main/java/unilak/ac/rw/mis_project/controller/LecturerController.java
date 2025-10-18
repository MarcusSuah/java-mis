package unilak.ac.rw.mis_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unilak.ac.rw.mis_project.entity.Lecturer;
import unilak.ac.rw.mis_project.service.LecturerService;

@RequestMapping("/lecturer")
@RestController
public class LecturerController {
    @Autowired
    public LecturerService lecturerService;

    @PostMapping("create")
    public ResponseEntity<?> createLecturer(@RequestBody Lecturer lecturer) {
        try {
            Lecturer newLecturer = lecturerService.createLecturer(lecturer);
            if (newLecturer != null) {
                return ResponseEntity.ok(newLecturer);
            } else {
                return ResponseEntity.badRequest().body("An error occured");
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("The lecturer already exists");
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<?> getAllLecturers() {
        if (lecturerService.getAllLecturers() != null) {
            return ResponseEntity.ok(lecturerService.getAllLecturers());
        } else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @PutMapping("update/{lecturerId}")
    public ResponseEntity<?> updateLecturer(@PathVariable int lecturerId, @RequestBody Lecturer lecturer) {
        Lecturer currentLecturer = lecturerService.getLecturerById(lecturerId);
        if (currentLecturer == null) {
            return ResponseEntity.badRequest().body("Lecturer not found");
        }
        currentLecturer.setName(lecturer.getName());
        currentLecturer.setEmail(lecturer.getEmail());
        currentLecturer.setSpecialization(lecturer.getSpecialization());
        currentLecturer.setHireDate(lecturer.getHireDate());
        Lecturer updatedLecturer = lecturerService.createLecturer(currentLecturer);
        if (updatedLecturer != null) {
            return ResponseEntity.ok(updatedLecturer);
        } else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @DeleteMapping("delete/{lecturerId}")
    public ResponseEntity<?> deleteLecturer(@PathVariable int lecturerId) {
        Lecturer currentLecturer = lecturerService.getLecturerById(lecturerId);
        if (currentLecturer == null) {
            return ResponseEntity.badRequest().body("Lecturer not found");
        }
        lecturerService.deleteLecturerById(lecturerId);
        return ResponseEntity.ok("Lecturer deleted successfully.");
    }
}