package com.ServiceScout.Project.Request;

import com.ServiceScout.Project.User.User;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long requestId;

    // User who created the request
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    // Contractor assigned to fulfill the request
    @ManyToOne
    @JoinColumn(name = "contractor_id", nullable = false)
    private User contractor;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt = new Date();

    public enum Status {
        PENDING,
        ACCEPTED,
        COMPLETED
    }

    // Constructors
    public Request() {
    }

    public Request(User customer, User contractor, String description, Status status) {
        this.customer = customer;
        this.contractor = contractor;
        this.description = description;
        this.status = status;
        this.createdAt = new Date();
    }

    // Getters and Setters
    public long getRequestId() {
        return requestId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getContractor() {
        return contractor;
    }

    public void setContractor(User contractor) {
        this.contractor = contractor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
