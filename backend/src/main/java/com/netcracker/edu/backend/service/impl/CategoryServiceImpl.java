package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Category;
import com.netcracker.edu.backend.repository.CategoryRepository;
import com.netcracker.edu.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> getCategory(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        repository.deleteById(id);
    }
}
