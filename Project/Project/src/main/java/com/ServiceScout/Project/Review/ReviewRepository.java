package com.ServiceScout.Project.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Find all reviews written by a specific user (reviewer)
    List<Review> findByReviewerUserId(Long reviewerId);

    // Find all reviews for a specific contractor
    List<Review> findByContractorUserId(Long contractorId);
}
