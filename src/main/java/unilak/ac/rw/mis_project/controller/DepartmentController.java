package unilak.ac.rw.mis_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unilak.ac.rw.mis_project.entity.Department;
import unilak.ac.rw.mis_project.service.DepartmentService;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    @Autowired
    public DepartmentService departmentService;

    @PostMapping("create")
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        try {
            Department newDepartment = departmentService.createDepartment(department);
            if (newDepartment != null) {
                return ResponseEntity.ok(newDepartment);
            } else {
                return ResponseEntity.badRequest().body("An error occured");
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("The department already exists");
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<?> getAllDepartments() {
        if (departmentService.getAllDepartments() != null) {
            return ResponseEntity.ok(departmentService.getAllDepartments());
        } else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @PutMapping("update/{departmentId}")
    public ResponseEntity<?> updateDepartment(@PathVariable int departmentId, @RequestBody Department department) {
        Department currentDepartment = departmentService.getDepartmentById(departmentId);
        if (currentDepartment == null) {
            return ResponseEntity.badRequest().body("Department not found");
        }
        currentDepartment.setName(department.getName());
        currentDepartment.setHead(department.getHead());
        currentDepartment.setContactEmail(department.getContactEmail());
        Department updatedDepartment = departmentService.createDepartment(currentDepartment);
        if (updatedDepartment != null) {
            return ResponseEntity.ok(updatedDepartment);
        } else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @DeleteMapping("delete/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable int departmentId) {
        Department currentDepartment = departmentService.getDepartmentById(departmentId);
        if (currentDepartment == null) {
            return ResponseEntity.badRequest().body("Department not found");
        }
        departmentService.deleteDepartmentById(departmentId);
        return ResponseEntity.ok("Department deleted successfully.");
    }
}