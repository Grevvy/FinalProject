package com.ServiceScout.Project.Specialty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    // Get all specialties
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    // Get specialty by ID
    public Optional<Specialty> getSpecialtyById(Long id) {
        return specialtyRepository.findById(id);
    }

    // Create a new specialty
    public Specialty createSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    // Update an existing specialty
    public Specialty updateSpecialty(Long id, Specialty updatedSpecialty) {
        return specialtyRepository.findById(id)
                .map(existingSpecialty -> {
                    existingSpecialty.setName(updatedSpecialty.getName());
                    return specialtyRepository.save(existingSpecialty);
                })
                .orElseThrow(() -> new RuntimeException("Specialty not found with id " + id));
    }

    // Delete a specialty by ID
    public void deleteSpecialty(Long id) {
        specialtyRepository.deleteById(id);
    }
}
