package com.bootcamp.controllers;

import com.bootcamp.entities.Employee;
import com.bootcamp.entities.FilterCriteria;
import com.bootcamp.entities.QEmpHistory;
import com.bootcamp.entities.QEmployee;
import com.bootcamp.repositories.EmployeeRepository;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by nabila.azam on 3/24/2017.
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/api/employees/findbycriteria", method = RequestMethod.POST)
    public ResponseEntity<Page> employeeFindByFilter (@RequestBody FilterCriteria filterCriteria, @RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageRequest = new PageRequest(page, size);
        List<Employee> employees = new ArrayList<>();

        try{
            employees = findEmployeeByFilter(filterCriteria);
        }catch (Exception e){
            e.printStackTrace();
        }
        Page<Employee> employeePage = getEmployeePage(employees, pageRequest);
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/employees/findbyname/{name}")
    public  ResponseEntity<Page> employeeFindByName(@PathVariable String name, @RequestParam("page") int page, @RequestParam("size") int size){
        PageRequest pageRequest = new PageRequest(page,size);
        Page<Employee> employees = employeeRepository.findByName(name, pageRequest);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> employeeAdd(@RequestBody Employee employee) {
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/employee", method = RequestMethod.PUT)
    public ResponseEntity<Employee> employeeModify(@RequestBody Employee employee) {
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/employees", method = RequestMethod.GET)
    public ResponseEntity<Page> findAllEmployees(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageRequest = new PageRequest(page, size);
        List<Employee> employees = (List<Employee>)employeeRepository.findAllByOrderByFirstNameAsc();
        Page<Employee> employeePage = getEmployeePage(employees, pageRequest);
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findOne(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    private Page<Employee> getEmployeePage(List<Employee> employees, Pageable pageRequest){
        PagedListHolder<Employee> pageList = new PagedListHolder<>(employees);
        pageList.setPage(pageRequest.getPageNumber());
        pageList.setPageSize(pageRequest.getPageSize());

        return new PageImpl<Employee>(pageList.getPageList(), pageRequest, employees.size());
    }

    private List<Employee> findEmployeeByFilter(FilterCriteria filter) {
        JPQLQuery query = new JPAQuery(entityManager);
        QEmployee employee = QEmployee.employee;
        BooleanBuilder condition = new BooleanBuilder();

        if (!StringUtils.isEmpty(filter.getGrade())) {
            condition = condition.and(employee.grade.eq(filter.getGrade()));
        }

        if (!StringUtils.isEmpty(filter.getGender())){
            condition = condition.and(employee.gender.eq(filter.getGender()));
        }

        if (!StringUtils.isEmpty(filter.getLocation())) {
            condition = condition.and(employee.location.eq(filter.getLocation()));
        }

        return query.from(employee).where(condition).list(employee);
    }
}
