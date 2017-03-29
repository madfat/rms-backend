package com.bootcamp.repositories;

import com.bootcamp.entities.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nabila.azam on 3/23/2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
