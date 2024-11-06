package com.ServiceScout.Project.Specialty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    // Additional custom queries can be added here if needed in the future
}
