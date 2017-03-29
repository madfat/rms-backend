package com.bootcamp.repositories;

import com.bootcamp.entities.GradeHistory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fathoni on 3/27/2017.
 */
public interface GradeHistoryRepository extends CrudRepository<GradeHistory, Long> {
}
