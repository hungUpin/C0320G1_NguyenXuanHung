package com.example.blogjpa.models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "categories")
public class Category implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @OneToMany(mappedBy = "category")
//    private List<Blog> blogs;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Blog> getBlogs() {
//        return blogs;
//    }
//
//    public void setBlogs(List<Blog> blogs) {
//        this.blogs = blogs;
//    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Category.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Category category = (Category) target;
        String name = category.getName();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.empty");
        if(!name.equals("")){
            if(name.length()<2||name.length()>50){
                errors.rejectValue("name","name.length");
            }
            if(name.charAt(0)!=Character.toUpperCase(name.charAt(0))){
                errors.rejectValue("name","name.upperCaseFirstCharacter");
            }
            if(!name.matches("^[a-zA-Z0-9]+$")){
                errors.rejectValue("name","name.matches");
            }
        }


    }
}
