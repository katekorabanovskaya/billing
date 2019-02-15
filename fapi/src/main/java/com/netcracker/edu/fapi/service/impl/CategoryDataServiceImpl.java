package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CategoryViewModel;
import com.netcracker.edu.fapi.service.CategoryDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryDataServiceImpl implements CategoryDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<CategoryViewModel> getAllCategories() {
        RestTemplate template = new RestTemplate();
        CategoryViewModel categories[] = template.getForObject(
                backendServerUrl + "api/categories",
                CategoryViewModel[].class
        );
        return categories == null ? Collections.emptyList() : Arrays.asList(categories);
    }

    @Override
    public CategoryViewModel getCategory(Integer id) {
        return new RestTemplate().getForEntity(
                backendServerUrl + "api/categories/" + id,
                CategoryViewModel.class
        ).getBody();
    }

    @Override
    public CategoryViewModel saveCategory(CategoryViewModel category) {
        return new RestTemplate().postForEntity(
                backendServerUrl + "api/categories",
                category,
                CategoryViewModel.class
        ).getBody();
    }

    @Override
    public void deleteCategory(Integer id) {
        new RestTemplate().delete(
                backendServerUrl + "api/categories/" + id
        );
    }
}
