package com.bootcamp.repositories;

import com.bootcamp.entities.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fathoni on 3/27/2017.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
