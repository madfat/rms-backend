package com.bootcamp.controllers;

import com.bootcamp.entities.Employee;
import com.bootcamp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nabila.azam on 3/24/2017.
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @CrossOrigin
    @RequestMapping(value = "/api/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> employeeAdd(@RequestBody Employee employee) {
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/employee", method = RequestMethod.PUT)
    public ResponseEntity<Employee> employeeModify(@RequestBody Employee employee) {
        try {
   //         Employee oldEmployee = (Employee) employeeRepository.findOne(employee.getId()).clone();
            employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/api/employees", method = RequestMethod.GET)
    public ResponseEntity<Page> employeesFindAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageRequest = new PageRequest(page, size);
        List<Employee> employees = (List<Employee>)employeeRepository.findAllByOrderByFirstNameAsc();
        Page<Employee> employeePage = getEmployeePage(employees, pageRequest);
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    private Page<Employee> getEmployeePage(List<Employee> employees, Pageable pageRequest){
        PagedListHolder<Employee> pageList = new PagedListHolder<>(employees);
        pageList.setPage(pageRequest.getPageNumber());
        pageList.setPageSize(pageRequest.getPageSize());

        return new PageImpl<Employee>(pageList.getPageList(), pageRequest, employees.size());
    }
}
