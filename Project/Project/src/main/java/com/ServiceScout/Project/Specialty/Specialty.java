package com.ServiceScout.Project.Specialty;

import com.ServiceScout.Project.User.User;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialtyId;

    private String name;

    @ManyToMany(mappedBy = "specialties")
    private Set<User> users;

    // Constructors, Getters, and Setters
    public Specialty() {}

    public Specialty(String name) {
        this.name = name;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
