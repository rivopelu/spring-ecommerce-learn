package com.eccomerce.services;

import com.eccomerce.entities.User;
import com.eccomerce.exception.BadRequestException;
import com.eccomerce.exception.ResourceNotFoundException;
import com.eccomerce.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user Id tidak di temukan"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        String id = user.getId();
        String email = user.getEmail();
        if (!StringUtils.hasText(id)) {
            throw new BadRequestException("Username {id} is required");
        }
        if (userRepository.existsById(user.getId())) {
            throw new BadRequestException("Username  already taken");
        }
        if (!StringUtils.hasText(email)) {
            throw new BadRequestException("email is required");
        }
        if (userRepository.existsByEmail(email)) {
            throw new BadRequestException("Email {email} already taken"); // TODO : 8:00 eps 6
        }
        user.setIsActive(true);
        return userRepository.save(user);
    }

    public User edit(String id, User user) {
        if (!StringUtils.hasText(user.getEmail())) {
            throw new BadRequestException("Email is required");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
