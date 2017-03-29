package com.bootcamp.repositories;

import com.bootcamp.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by fathoni on 16/10/14.
 */
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query("select c from Course c where c.category like %:category%")
    Page<Course> findByCategory(@Param("category") String category, Pageable pageable);
}
