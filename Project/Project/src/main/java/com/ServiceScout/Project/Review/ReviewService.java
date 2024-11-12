package com.ServiceScout.Project.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getFlaggedReviews() {
        return reviewRepository.findByReviewStatus(Review.ReviewStatus.FLAGGED);
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByReviewerId(Long reviewerId) {
        return reviewRepository.findByReviewerUserId(reviewerId);
    }

    public List<Review> getReviewsByContractorId(Long contractorId) {
        return reviewRepository.findByContractorUserId(contractorId);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        return reviewRepository.findById(id)
                .map(existingReview -> {
                    existingReview.setReviewer(updatedReview.getReviewer());
                    existingReview.setContractor(updatedReview.getContractor());
                    existingReview.setTextBody(updatedReview.getTextBody());
                    existingReview.setRating(updatedReview.getRating());
                    existingReview.setReviewStatus(updatedReview.getReviewStatus());
                    return reviewRepository.save(existingReview);
                })
                .orElseThrow(() -> new RuntimeException("Review not found with id " + id));
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
