package com.ServiceScout.Project.Request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    // Find requests by the user who created them
    List<Request> findByCustomerUserId(Long customerId);

    // Find requests assigned to a specific contractor
    List<Request> findByContractorUserId(Long contractorId);
}
