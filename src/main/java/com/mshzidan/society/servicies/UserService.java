package com.mshzidan.society.servicies;

import com.mshzidan.society.entites.Initiative;
import com.mshzidan.society.entites.User;
import com.mshzidan.society.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public List<User> getVolunteersFromInitiative(Initiative initiative, String key) {
        return initiative.getVolunteers().stream().filter(volunteer -> volunteer.getName().contains(key))
                .collect(Collectors.toList());
    }


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepo.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User is not found"));
    }


    public void deleteUserById(Integer userId) {
        User user = getUserById(userId);
        // Set the admin user as the initiator for all initiatives of the deleted user
        user.getInitiatives().forEach(initiative -> initiative.setInitiator(getAdminUser()));
        // Remove the deleted user from volunteering jobs
        user.getVolunteeringJobs().forEach(initiative -> initiative.getVolunteers().remove(user));
        userRepo.delete(user);
    }

    public User getAdminUser() {
        return userRepo.findById(1).orElseThrow(() -> new NoSuchElementException("Admin is not found"));
    }

}


