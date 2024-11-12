package com.ServiceScout.Project.User;

import com.ServiceScout.Project.Specialty.Specialty;
import com.ServiceScout.Project.Specialty.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<User> getFlaggedAccounts() {
        return userRepository.findByAccountStatus(User.AccountStatus.FLAGGED);
    }

    public User assignSpecialtiesToUser(long userId, List<Long> specialtyIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Specialty> specialties = specialtyRepository.findAllById(specialtyIds);

        user.setSpecialties(specialties);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        // Add password encryption here if needed
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUserName(updatedUser.getUserName());
                    existingUser.setPassword(updatedUser.getPassword());
                    existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setAddress(updatedUser.getAddress());
                    existingUser.setRole(updatedUser.getRole());
                    existingUser.setAccountStatus(updatedUser.getAccountStatus());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
