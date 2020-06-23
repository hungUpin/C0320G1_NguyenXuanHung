package com.example.blogjpa.services;

import com.example.blogjpa.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

public interface CategoryService {
    Page<Category> findAllCategory(Pageable pageable);
    Category findCategoryById(Long id);
    void addNewCategory(Category category);
    void removeCategoryById(Long id);
    List<Category> getListCategory();
}
