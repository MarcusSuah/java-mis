package unilak.ac.rw.mis_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unilak.ac.rw.mis_project.entity.Faculty;
import unilak.ac.rw.mis_project.service.FacultyService;

@RequestMapping("/faculty")
@RestController
public class FacultyController {
    @Autowired
    public FacultyService facultyService;

    @PostMapping("create")
    public ResponseEntity<?> createFaculty(@RequestBody Faculty faculty) {
        try {
            Faculty newFaculty = facultyService.createFaculty(faculty);
            if (newFaculty != null) {
                return ResponseEntity.ok(newFaculty);
            } else {
                return ResponseEntity.badRequest().body("An error occured");
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("The faculty already exists");
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<?> getAllFaculties() {
        if (facultyService.getAllFaculties() != null) {
            return ResponseEntity.ok(facultyService.getAllFaculties());
        } else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @PutMapping("update/{facultyId}")
    public ResponseEntity<?> updateFaculty(@PathVariable int facultyId, @RequestBody Faculty faculty) {
        Faculty currentFaculty = facultyService.getFacultyById(facultyId);
        if (currentFaculty == null) {
            return ResponseEntity.badRequest().body("Faculty not found");
        }
        currentFaculty.setName(faculty.getName());
        currentFaculty.setDean(faculty.getDean());
        currentFaculty.setOfficeLocation(faculty.getOfficeLocation());
        Faculty updatedFaculty = facultyService.createFaculty(currentFaculty);
        if (updatedFaculty != null) {
            return ResponseEntity.ok(updatedFaculty);
        } else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @DeleteMapping("delete/{facultyId}")
    public ResponseEntity<?> deleteFaculty(@PathVariable int facultyId) {
        Faculty currentFaculty = facultyService.getFacultyById(facultyId);
        if (currentFaculty == null) {
            return ResponseEntity.badRequest().body("Faculty not found");
        }
        facultyService.deleteFacultyById(facultyId);
        return ResponseEntity.ok("Faculty deleted successfully.");
    }
}