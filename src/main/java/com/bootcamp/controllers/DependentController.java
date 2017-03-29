package com.bootcamp.controllers;

import com.bootcamp.entities.Dependent;
import com.bootcamp.repositories.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nabila.azam on 3/23/2017.
 */
@RestController
public class DependentController {

    @Autowired
    DependentRepository dependentRepository;

    @RequestMapping(method= RequestMethod.DELETE, value="/api/dependent/{id}")
    public void delete(@PathVariable Long id) {
        dependentRepository.delete(id);
    }
}
