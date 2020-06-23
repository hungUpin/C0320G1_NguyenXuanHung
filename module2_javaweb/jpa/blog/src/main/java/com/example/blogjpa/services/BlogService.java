package com.example.blogjpa.services;

import com.example.blogjpa.models.Blog;
import com.example.blogjpa.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();
    Blog findBlogById(Long id);
    void addNewBlog(Blog blog);
    void deleteBlogById(Long id);
    Page<Blog> findAndSortByDate(Pageable pageable);
    Page<Blog> findAllByCategoryName(String name,Pageable pageable);
    Page<Blog> findAllByBlogNameAndDescription(Pageable pageable,String blogName,String description);
    List<Blog> findALlBlogByCategory(Category category);
}
