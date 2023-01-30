package com.eccomerce.controllers;


import com.eccomerce.entities.Categories;
import com.eccomerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Categories> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Categories findById(@PathVariable("id") String id) {
        return categoryService.findById(id);
    }

    @PostMapping("/create")
    public Categories create(@RequestBody Categories categories) {
        return categoryService.create(categories);
    }

    @PutMapping("/edit/{id}")
    public Categories edit(@PathVariable("id") String id, @RequestBody Categories category) {
        return categoryService.edit(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id) {
        categoryService.deleteById(id);
    }
}
