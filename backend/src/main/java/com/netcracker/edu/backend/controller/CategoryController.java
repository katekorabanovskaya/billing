package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Category;
import com.netcracker.edu.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Category> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable(name = "id") Integer id) {
        Optional<Category> category = service.getCategory(id);

        if(category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return service.saveCategory(category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCategory(@PathVariable(name = "id") Integer id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
