package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CategoryViewModel;
import com.netcracker.edu.fapi.service.CategoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private CategoryDataService categoryDataService;

    @Autowired
    public CategoryController(CategoryDataService categoryDataService) {
        this.categoryDataService = categoryDataService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryViewModel>> getAllCategories() {
        return ResponseEntity.ok(categoryDataService.getAllCategories());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryViewModel> getCategory(@PathVariable(name = "id") Integer id) {
        CategoryViewModel category = categoryDataService.getCategory(id);
        if(category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoryViewModel> saveCategory(@Valid @RequestBody CategoryViewModel category) {
        return ResponseEntity.ok(categoryDataService.saveCategory(category));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategory(@PathVariable(name = "id") Integer id) {
        categoryDataService.deleteCategory(id);
    }
}
