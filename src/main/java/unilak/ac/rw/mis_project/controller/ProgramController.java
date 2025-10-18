package unilak.ac.rw.mis_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unilak.ac.rw.mis_project.entity.Program;
import unilak.ac.rw.mis_project.service.ProgramService;

@RequestMapping("/program")
@RestController
public class ProgramController {
    @Autowired
    public ProgramService programService;

    @PostMapping("create")
    public ResponseEntity<?> createProgram(@RequestBody Program program) {
        try {
            Program newProgram = programService.createProgram(program);
            if (newProgram != null) {
                return ResponseEntity.ok(newProgram);
            } else {
                return ResponseEntity.badRequest().body("An error occured");
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("The program already exists");
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<?> getAllPrograms() {
        if (programService.getAllPrograms() != null) {
            return ResponseEntity.ok(programService.getAllPrograms());
        } else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @PutMapping("update/{programId}")
    public ResponseEntity<?> updateProgram(@PathVariable int programId, @RequestBody Program program) {
        Program currentProgram = programService.getProgramById(programId);
        if (currentProgram == null) {
            return ResponseEntity.badRequest().body("Program not found");
        }
        currentProgram.setName(program.getName());
        currentProgram.setDurationYears(program.getDurationYears());
        currentProgram.setDegreeType(program.getDegreeType());
        Program updatedProgram = programService.createProgram(currentProgram);
        if (updatedProgram != null) {
            return ResponseEntity.ok(updatedProgram);
        } else {
            return ResponseEntity.badRequest().body("An error occured");
        }
    }

    @DeleteMapping("delete/{programId}")
    public ResponseEntity<?> deleteProgram(@PathVariable int programId) {
        Program currentProgram = programService.getProgramById(programId);
        if (currentProgram == null) {
            return ResponseEntity.badRequest().body("Program not found");
        }
        programService.deleteProgramById(programId);
        return ResponseEntity.ok("Program deleted successfully.");
    }
}