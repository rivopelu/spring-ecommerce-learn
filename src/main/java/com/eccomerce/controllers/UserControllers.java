package com.eccomerce.controllers;

import com.eccomerce.entities.User;
import com.eccomerce.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserControllers {
    private final UserService userService;

    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public User create(@RequestBody User categories) {
        return userService.create(categories);
    }

    @PutMapping("/edit/{id}")
    public User edit(@PathVariable("id") String id, @RequestBody User category) {
        return userService.edit(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id) {
        userService.deleteById(id);
    }
}
