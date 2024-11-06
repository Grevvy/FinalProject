package com.ServiceScout.Project.Review;

import com.ServiceScout.Project.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reviewId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String textBody;

    private int rating;

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Review(long reviewId, User user, String textBody, int rating) {
        this.reviewId = reviewId;
        this.user = user;
        this.textBody = textBody;
        this.rating = rating;
    }

    public Review() {
    }
}
