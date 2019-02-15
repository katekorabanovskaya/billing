package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Category;

import java.util.Optional;

public interface CategoryService {

    Iterable<Category> getAllCategories();

    Optional<Category> getCategory(Integer id);

    Category saveCategory(Category category);

    void deleteCategory(Integer id);
}
