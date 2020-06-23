package com.example.blogjpa.controllers;

import com.example.blogjpa.models.Blog;
import com.example.blogjpa.models.Category;
import com.example.blogjpa.models.MyCounter;
import com.example.blogjpa.services.BlogService;
import com.example.blogjpa.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("mycounter")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("mycounter")
    public MyCounter setUpCounter(){
        return new MyCounter();
    }
    @ModelAttribute("categories")
    public List<Category> categories(Pageable pageable){
        return categoryService.getListCategory();
    }

    @GetMapping("/")
    public ModelAndView getHomePage(@PageableDefault(value = 2) Pageable pageable,@RequestParam(value = "nameSearch",required = false,defaultValue = "") String nameSearch,
                                    @RequestParam(value = "descriptionSearch",required = false,defaultValue = "") String descriptionSearch){
        Page<Blog> blogPage = blogService.findAllByBlogNameAndDescription(pageable,nameSearch,descriptionSearch);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("nameSearch",nameSearch);
        modelAndView.addObject("descriptionSearch",descriptionSearch);
        modelAndView.addObject("blogs",blogPage);
        return modelAndView;
    }
    @GetMapping("/blog/add")
    public ModelAndView getAddPage(){
        return new ModelAndView("add","blog",new Blog());
    }
    @PostMapping("/blog/add")
    public String addNewBlog(@ModelAttribute("blog") @Valid Blog blog, BindingResult bindingResult,RedirectAttributes redirectAttributes ){
        if(bindingResult.hasErrors()){
            return "add";
        }
        blogService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("message","Add blog completed!!!");
        return "redirect:/";
    }
    @GetMapping("/blog/view/{id}")
    public ModelAndView getViewPage(@PathVariable("id") Long id,
                                    @ModelAttribute("mycounter") MyCounter myCounter){
        myCounter.increment();
        return new ModelAndView("view","blog",blogService.findBlogById(id));
    }
    @GetMapping("/blog/edit/{id}")
    public ModelAndView getEditPage(@PathVariable Long id){
        return new ModelAndView("edit","blog",blogService.findBlogById(id));
    }
    @PostMapping("blog/edit")
    public String editBlog(@ModelAttribute("blog") Blog blog,RedirectAttributes redirectAttributes){
        blogService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("message","Edit completed!!!!");
        return "redirect:/";
    }
    @GetMapping("/blog/delete/{id}")
    public ModelAndView showDeletePage(@PathVariable Long id){
        return new ModelAndView("delete","blog",blogService.findBlogById(id));
    }
    @PostMapping("/blog/delete")
    public String deleteBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.deleteBlogById(blog.getBlogId());
        redirectAttributes.addFlashAttribute("message","Delete completed!!!");
        return "redirect:/";
    }
}
