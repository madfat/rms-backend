package com.bootcamp.controllers;

import com.bootcamp.entities.Author;
import com.bootcamp.repositories.AuthorRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fathoni on 16/10/18.
 */

//@CrossOrigin(origins = "https://localhost:4563")
//@CrossOrigin(origins = ("${app.cross.origin}"))
//@CrossOrigin(origins = ("${app.cross.origin}"))
@RestController
public class AuthorController {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AuthorRepository authorRepo;

    @RequestMapping(value="/api/authors", method = RequestMethod.GET)
    public ResponseEntity<List<Author>> authors() {
        List<Author> authors = (List<Author>)authorRepo.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
