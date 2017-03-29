package com.bootcamp.controllers;

import com.bootcamp.entities.Lookup;
import com.bootcamp.repositories.LookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Fathoni on 3/29/2017.
 */
@RestController
public class LookupController {

    @Autowired
    LookupRepository lookupRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/lookup/{type}", method = RequestMethod.GET )
    public List<Lookup> getAll(@PathVariable String type) {
        return lookupRepository.findByDataType(type);
    }
}
