package com.bootcamp.repositories;

import com.bootcamp.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by nabila.azam on 3/23/2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllByOrderByFirstNameAsc();

    @Query("select e from Employee e where (e.firstName + ' ' + e.lastName) like %:name% order by e.firstName, e.lastName")
    Page<Employee> findByName(@Param("name") String name, Pageable pageable);
}
