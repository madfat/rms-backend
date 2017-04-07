package com.bootcamp.controllers;

import com.bootcamp.entities.GradeHistory;
import com.bootcamp.repositories.GradeHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Fathoni on 4/6/2017.
 */
@RestController
public class GradeHistoryController {
    @Autowired
    private GradeHistoryRepository gradeHistoryRepository;

    @CrossOrigin
    @RequestMapping(method= RequestMethod.DELETE, value="/api/gradehistory/{id}")
    public void delete(@PathVariable Long id) {
        GradeHistory gradeHistory = gradeHistoryRepository.findOne(id);
        gradeHistoryRepository.delete(gradeHistory);
    }
}
