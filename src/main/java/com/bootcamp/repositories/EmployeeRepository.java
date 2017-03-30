package com.bootcamp.repositories;

import com.bootcamp.entities.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nabila.azam on 3/23/2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllByOrderByFirstNameAsc();
}
