package com.ServiceScout.Project.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Get all reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Get review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get reviews by reviewer ID
    @GetMapping("/reviewer/{reviewerId}")
    public List<Review> getReviewsByReviewerId(@PathVariable Long reviewerId) {
        return reviewService.getReviewsByReviewerId(reviewerId);
    }

    // Get reviews by contractor ID
    @GetMapping("/contractor/{contractorId}")
    public List<Review> getReviewsByContractorId(@PathVariable Long contractorId) {
        return reviewService.getReviewsByContractorId(contractorId);
    }

    // Create a new review
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    // Update an existing review
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        try {
            return ResponseEntity.ok(reviewService.updateReview(id, updatedReview));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a review
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
