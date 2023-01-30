package com.eccomerce.services;

import com.eccomerce.entities.Categories;
import com.eccomerce.exception.ResourceNotFoundException;
import com.eccomerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Categories findById(String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category Id tidak di temukan"));
    }

    public List<Categories> findAll() {
        return categoryRepository.findAll();
    }

    public Categories create(Categories category) {
        category.setId(UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }

    public Categories edit(String id, Categories categories) {
        categories.setId(id);
        return categoryRepository.save(categories);
    }

    public void deleteById(String id) {
        categoryRepository.deleteById(id);
    }
}
