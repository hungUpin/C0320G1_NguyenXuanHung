package com.example.blogjpa.services.Impl;

import com.example.blogjpa.models.Blog;
import com.example.blogjpa.models.Category;
import com.example.blogjpa.repositories.BlogRepository;
import com.example.blogjpa.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAllBlog() {
        return (List<Blog>) blogRepository.findAllByStatusIsTrue();
    }

    @Override
    public Blog findBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void addNewBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(Long id) {
        blogRepository.findById(id).ifPresent(blog -> blogRepository.setStatusQuery(id, false));
    }

    @Override
    public Page<Blog> findAndSortByDate(Pageable pageable) {
        return blogRepository.findAllByOrOrderByBlogUploadDateAsc(pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryName(String name, Pageable pageable) {
        return blogRepository.findAllByCategoryName(name,pageable);
    }

    @Override
    public Page<Blog> findAllByBlogNameAndDescription(Pageable pageable, String blogName, String description) {
        return blogRepository.findAllByBlogNameContainingAndDescriptionContaining(pageable,blogName,description);
    }

    @Override
    public List<Blog> findALlBlogByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

}
