package com.ServiceScout.Project.Review;

import com.ServiceScout.Project.User.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.Date;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reviewId;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")  // User who wrote the review
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "contractor_id")  // Contractor being reviewed
    private User contractor;

    @Column(nullable = false)
    private String textBody;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private int rating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt = new Date();  // Automatically set at creation

    // Constructors
    public Review() {
    }

    public Review(User reviewer, User contractor, String textBody, int rating) {
        this.reviewer = reviewer;
        this.contractor = contractor;
        this.textBody = textBody;
        this.rating = rating;
        this.createdAt = new Date();  // Set timestamp on creation
    }

    // Getters and Setters
    public long getReviewId() {
        return reviewId;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public User getContractor() {
        return contractor;
    }

    public void setContractor(User contractor) {
        this.contractor = contractor;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
