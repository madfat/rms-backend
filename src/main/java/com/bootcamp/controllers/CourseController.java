package com.bootcamp.controllers;

import com.bootcamp.entities.Course;
import com.bootcamp.repositories.AuthorRepository;
import com.bootcamp.repositories.CourseRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.minidev.json.JSONObject;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fathoni on 16/10/14.
 */
//@CrossOrigin(origins = ("${app.cross.origin}"))
@RestController
public class CourseController {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    AuthorRepository authorRepo;

    @RequestMapping(value="/api/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> courses() {
        List<Course> courses = (List<Course>)courseRepo.findAll();
        courses.forEach(course -> {
            if (!StringUtils.isEmpty(course.getAuthorId())){
                course.setAuthor(authorRepo.findOne(Long.valueOf(course.getAuthorId())));
            }
        });
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value="/api/courses", method = RequestMethod.POST)
    public ResponseEntity<Object> createCourse(@RequestBody Course course){
        JSONObject entity = new JSONObject();
        try {
            if (!course.getTitle().isEmpty()){
                entity.put("result",courseRepo.save(course));
                entity.put("success", true);
            }else{
                throw new Exception("Title should not be blank");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            entity.put("result",e.getMessage());
            entity.put("success", false);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @RequestMapping(value="/api/courses", method = RequestMethod.PUT)
    public ResponseEntity<Object> modifyCourse(@RequestBody Course course){
        JSONObject entity = new JSONObject();
        try {
            if (!course.getTitle().isEmpty()){
                entity.put("result",courseRepo.save(course));
                entity.put("success", true);
            }else{
                throw new Exception("Title should not be blank");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            entity.put("result",e.getMessage());
            entity.put("success", false);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
