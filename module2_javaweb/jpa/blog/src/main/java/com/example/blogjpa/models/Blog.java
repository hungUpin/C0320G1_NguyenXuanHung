package com.example.blogjpa.models;

import com.example.blogjpa.validation.BlogNameConstraint;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;
@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;
    @BlogNameConstraint
    private String blogName;
    @NotBlank(message = "Description can not null")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String contain;
    private Boolean status = true;
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date blogUploadDate = new Date();

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }
    public Blog(String blogName,String description,String contain,Date blogUploadDate,Boolean status){
        this.blogName=blogName;
        this.description =description;
        this.contain=contain;
        this.blogUploadDate=blogUploadDate;
        this.status = status;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBlogUploadDate() {
        return blogUploadDate;
    }

    public void setBlogUploadDate(Date blogUploadDate) {
        this.blogUploadDate = blogUploadDate;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
