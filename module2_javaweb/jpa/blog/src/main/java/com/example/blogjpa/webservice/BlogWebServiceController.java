package com.example.blogjpa.webservice;

import com.example.blogjpa.models.Blog;
import com.example.blogjpa.models.Category;
import com.example.blogjpa.repositories.BlogRepository;
import com.example.blogjpa.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogWebServiceController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/category/view")
    public ResponseEntity<?> getCategoryList(@PageableDefault(value = 5) Pageable pageable) {
        Page<Category> categories = categoryService.findAllCategory(pageable);
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getBlogList() {

        List<Blog> blogs = blogRepository.findAllByStatusIsTrue();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
//    Xem danh sách các bài viết của một category
    @GetMapping("/category/viewlist/{id}")
    public ResponseEntity<?> getBlogListFromCategory(@PathVariable Long id){
        Category category = categoryService.findCategoryById(id);
        List<Blog> blogs = blogRepository.findAllByCategory(category);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogs,HttpStatus.OK);
        }
    }
    //xem chi tiet mot bai viet
    @GetMapping("/view/{id}")
    public ResponseEntity<?> showBlogDetail(@PathVariable Long id){
        Blog blog = blogRepository.findById(id).orElse(null);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
