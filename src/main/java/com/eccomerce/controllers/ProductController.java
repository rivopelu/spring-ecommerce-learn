package com.eccomerce.controllers;

import com.eccomerce.entities.Products;
import com.eccomerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> findAll() {
        return productService.FindAll();
    }

    @GetMapping("/{id}")
    public Products findById(@PathVariable("id") String id) {
        return productService.findById(id);
    }

    @PostMapping("/create")
    public Products create(@RequestBody Products categories) {
        return productService.create(categories);
    }

    @PutMapping("/edit/{id}")
    public Products edit(@PathVariable("id") String id, @RequestBody Products category) {
        return productService.edit(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id) {
        productService.deleteById(id);
    }

}
