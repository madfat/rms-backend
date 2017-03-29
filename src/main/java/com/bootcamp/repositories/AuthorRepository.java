package com.bootcamp.repositories;

import com.bootcamp.entities.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by fathoni on 16/10/18.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
