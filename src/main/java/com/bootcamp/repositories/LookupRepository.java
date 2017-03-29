package com.bootcamp.repositories;

import com.bootcamp.entities.Lookup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Fathoni on 3/27/2017.
 */
public interface LookupRepository extends CrudRepository<Lookup, Long> {
    public List<Lookup> findByDataType(String type);
}
