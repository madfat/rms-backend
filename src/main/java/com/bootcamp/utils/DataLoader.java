package com.bootcamp.utils;

import com.bootcamp.entities.Author;
import com.bootcamp.entities.Course;
import com.bootcamp.repositories.AuthorRepository;
import com.bootcamp.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by fathoni on 16/10/14.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final CourseRepository courseRepo;
    private final AuthorRepository authorRepo ;

    @Autowired
    public DataLoader(CourseRepository courseRepo, AuthorRepository authorRepo) {
        this.courseRepo = courseRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.authorRepo.save(new Author("Cory", "House"));
        this.authorRepo.save(new Author("Akhmad", "Fathoni"));
        this.courseRepo.save(new Course("Building Applications in React and Flux","1","Javascript","5:00"));
        this.courseRepo.save(new Course("Building Applications in React and Redux","1","Javascript","3:00"));
        this.courseRepo.save(new Course("Building Applications in Angular","1","Javascript","2:00"));
        this.courseRepo.save(new Course("Dummy For Testing","2","Dummy","4:00"));
    }
}
