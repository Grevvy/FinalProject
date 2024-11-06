package com.ServiceScout.Project.Request;

import com.ServiceScout.Project.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long requestId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String description;

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Request(long requestId, User user, String description) {
        this.requestId = requestId;
        this.user = user;
        this.description = description;
    }

    public Request (){
    }
}
