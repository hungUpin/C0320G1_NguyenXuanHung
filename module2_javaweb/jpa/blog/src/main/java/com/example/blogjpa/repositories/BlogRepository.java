package com.example.blogjpa.repositories;

import com.example.blogjpa.models.Blog;
import com.example.blogjpa.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface BlogRepository extends CrudRepository<Blog,Long> {
    List<Blog> findAllByStatusIsTrue();
    @Query(value = "select * from blog where status=1 order by blog_upload_date desc  ",nativeQuery = true)
    Page<Blog> findAllByOrOrderByBlogUploadDateAsc(Pageable pageable);
    @Query(value = "select * from blog join categories on blog.category_id=categories.id where categories.name like %:keyword% and blog.status=true" ,nativeQuery = true)
    Page<Blog> findAllByCategoryName(@Param("keyword") String name,Pageable pageable);

    @Modifying
//    @Query(value = "update Blog c set c.status=?2 where c.blogId=?1")
    @Query(value = "update blog  set status =?2 where blog_id =?1", nativeQuery = true)
     void setStatusQuery(Long id,Boolean status);
    List<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByBlogNameContainingAndDescriptionContaining(Pageable pageable,String blogName,String description);
}
