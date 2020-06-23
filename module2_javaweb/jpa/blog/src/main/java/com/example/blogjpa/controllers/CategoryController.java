package com.example.blogjpa.controllers;

import com.example.blogjpa.models.Blog;
import com.example.blogjpa.models.Category;
import com.example.blogjpa.repositories.BlogRepository;
import com.example.blogjpa.services.BlogService;
import com.example.blogjpa.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;
    @GetMapping()
    public ModelAndView getCategoryPage(@PageableDefault(value = 5) Pageable pageable){
        return new ModelAndView("category/list","categories",categoryService.findAllCategory(pageable));
    }
    @GetMapping("/add")
    public ModelAndView getAddCategoryPage(){
        return new ModelAndView("category/add","category",new Category());
    }
    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute Category category, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        new Category().validate(category,bindingResult);
        if(bindingResult.hasErrors()){
            return "category/add";
        }
        categoryService.addNewCategory(category);
        redirectAttributes.addFlashAttribute("message","Save message completed!!!");
        return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView getEditCategoryPage(@PathVariable("id") Long id){
        return new ModelAndView("category/edit","category",categoryService.findCategoryById(id));
    }
    @PostMapping("/edit")
    public String editCategory(@ModelAttribute("category") Category category,RedirectAttributes redirectAttributes){
        categoryService.addNewCategory(category);
        redirectAttributes.addFlashAttribute("message","Edit completed!!!");
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView getCategoryDeletePage(@PathVariable Long id){
        return new ModelAndView("category/delete","category",categoryService.findCategoryById(id));
    }
    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute Category category,RedirectAttributes redirectAttributes){
        categoryService.removeCategoryById(category.getId());
        redirectAttributes.addFlashAttribute("message","Delete completed!!!");
        return "redirect:/category";
    }
    @GetMapping("/viewlist/{id}")
    public ModelAndView goCategoryListForm(@PathVariable Long id){
        List<Blog> blogs = blogService.findALlBlogByCategory(categoryService.findCategoryById(id));
        return new ModelAndView("category/viewList","blogs",blogs);
    }
}
