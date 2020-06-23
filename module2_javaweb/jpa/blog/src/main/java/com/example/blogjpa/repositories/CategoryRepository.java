package com.example.blogjpa.repositories;

import com.example.blogjpa.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
