package com.ServiceScout.Project.Specialty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialties")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    // Get all specialties
    @GetMapping
    public List<Specialty> getAllSpecialties() {
        return specialtyService.getAllSpecialties();
    }

    // Get specialty by ID
    @GetMapping("/{id}")
    public ResponseEntity<Specialty> getSpecialtyById(@PathVariable Long id) {
        return specialtyService.getSpecialtyById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new specialty
    @PostMapping
    public Specialty createSpecialty(@RequestBody Specialty specialty) {
        return specialtyService.createSpecialty(specialty);
    }

    // Update an existing specialty
    @PutMapping("/{id}")
    public ResponseEntity<Specialty> updateSpecialty(@PathVariable Long id, @RequestBody Specialty updatedSpecialty) {
        try {
            return ResponseEntity.ok(specialtyService.updateSpecialty(id, updatedSpecialty));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a specialty by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialty(@PathVariable Long id) {
        specialtyService.deleteSpecialty(id);
        return ResponseEntity.noContent().build();
    }
}
