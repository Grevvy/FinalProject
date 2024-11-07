package com.ServiceScout.Project.Specialty;

import com.ServiceScout.Project.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialtyId;

    private String name;

    @ManyToMany(mappedBy = "specialties")
    @JsonIgnore
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
