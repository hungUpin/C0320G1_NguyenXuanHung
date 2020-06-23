package com.example.blogjpa.services.Impl;

import com.example.blogjpa.models.Category;
import com.example.blogjpa.repositories.CategoryRepository;
import com.example.blogjpa.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void removeCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }
}
