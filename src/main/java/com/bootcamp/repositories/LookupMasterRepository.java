package com.bootcamp.repositories;

import com.bootcamp.entities.LookupMaster;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fathoni on 3/27/2017.
 */
public interface LookupMasterRepository extends CrudRepository<LookupMaster, String> {
}
