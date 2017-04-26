package com.bootcamp;

import com.bootcamp.controllers.EmployeeController;
import com.bootcamp.entities.Employee;
import com.bootcamp.entities.FilterCriteria;
import com.bootcamp.repositories.EmployeeRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysema.query.jpa.impl.JPAQuery;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static java.lang.Math.toIntExact;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Fathoni on 4/21/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("testing")
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    EmployeeRepository empRepo;

    @Mock
    JPAQuery jpaQuery;

    @InjectMocks
    EmployeeController employeeController;

    private MediaType halContentType = new MediaType(MediaTypes.HAL_JSON, Charset.forName("utf8"));
    private MediaType jsonContentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.employeeRepository.deleteAll();
    }

//    @Test
//    public void employeeAddClass()throws Exception{
//
//        Mockito.verify(empRepo).save(any(Employee.class));
//    }
//
//    @Test
//    public void employeeFindByNameClass() throws Exception{
//        PageRequest pageRequest = new PageRequest(10,1);
//        employeeController.employeeFindByName(anyString(), 10, anyInt());
//
//        Mockito.verify(empRepo.findByName(anyString(),anyObject()));
//    }

    @Test
    public void employeeAdd() throws Exception {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("FirstName");
        newEmployee.setLastName("lastName");
        newEmployee.setEmail("first.last@employee.com");
        newEmployee.setGender("M");
        newEmployee.setMaritalStatus("S");

        mockMvc.perform(post("/api/employee")
                .contentType(jsonContentType)
                .content(this.json(newEmployee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName",equalToIgnoringCase("FirstName")));

/*
    //
    // We also can use something like this as well
    //
        String expectedResult = "{\"firstName\":\"FirstName\",\"lastName\":\"lastName\",\"dob\":null,\"gender\":\"M\",\"maritalStatus\":\"S\",\"phone\":null,\"email\":\"first.last@employee.com\",\"grade\":null,\"location\":null,\"hiredDate\":null,\"employmentStatus\":null,\"nationality\":null,\"businessUnit\":null,\"division\":null,\"jobFamily\":null,\"stream\":null,\"jobTitle\":null,\"retiredDate\":null,\"suspendedDate\":null,\"activeInd\":false,\"dependents\":null,\"locations\":null,\"gradeHistories\":null,\"addresses\":null,\"empHistories\":null,\"id\":2}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/employee")
                .accept(MediaType.APPLICATION_JSON).content(this.json(newEmployee))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expectedResult, response.getContentAsString());*/
    }

    @Test
    public void findEmployeeById () throws Exception {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Employee");
        newEmployee.setLastName("Name");
        newEmployee.setEmail("employee.name@employee.com");
        newEmployee.setGender("M");
        newEmployee.setMaritalStatus("S");

//        String expectedResult = "{\"firstName\":\"Employee\",\"lastName\":\"Name\",\"dob\":null,\"gender\":\"M\",\"maritalStatus\":\"S\",\"phone\":null,\"email\":\"employee.name@employee.com\",\"grade\":null,\"location\":null,\"hiredDate\":null,\"employmentStatus\":null,\"nationality\":null,\"businessUnit\":null,\"division\":null,\"jobFamily\":null,\"stream\":null,\"jobTitle\":null,\"retiredDate\":null,\"suspendedDate\":null,\"activeInd\":false,\"dependents\":[],\"locations\":[],\"gradeHistories\":[],\"addresses\":[],\"empHistories\":[],\"id\":1}";

        Employee savedEmployee = employeeRepository.save(newEmployee);
/*
    //
    // We also can use something like this as well
    //
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/employee/" + employee.getId())
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expectedResult, response.getContentAsString());
*/

        mockMvc.perform(get("/api/employee/" + savedEmployee.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", comparesEqualTo(toIntExact(savedEmployee.getId()))))
                .andExpect(jsonPath("$.firstName", equalToIgnoringCase(newEmployee.getFirstName())));

    }

    @Test
    public void employeeFindByFilter() throws Exception{
        createDummyEmployees();

        FilterCriteria filter = new FilterCriteria();
        // the backend filter only suppoert search by gender, location and grade
        filter.setGender("M");

        mockMvc.perform(post("/api/employees/findbycriteria?page=0&size=10")
                .contentType(jsonContentType)
                .content(this.json(filter)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].firstName",equalToIgnoringCase("Hulk")))
                .andExpect(jsonPath("$.totalElements", comparesEqualTo(2)));

    }

    private void createDummyEmployees(){
        Employee Emp1 = new Employee();
        Emp1.setFirstName("Hulk");
        Emp1.setLastName("Hogan");
        Emp1.setEmail("hulk.hogan@employee.com");
        Emp1.setGender("M");
        Emp1.setMaritalStatus("S");
        Emp1.setLocation("Yogyakarta");
        Emp1.setGrade("AP");

        Employee Emp2 = new Employee();
        Emp2.setFirstName("Angelina");
        Emp2.setLastName("Jolie");
        Emp2.setEmail("angelina.jolie@employee.com");
        Emp2.setGender("F");
        Emp2.setMaritalStatus("M");
        Emp2.setLocation("Yogyakarta");
        Emp2.setGrade("AP");

        Employee Emp3 = new Employee();
        Emp3.setFirstName("Dian");
        Emp3.setLastName("Sastro");
        Emp3.setEmail("dian.sastro@employee.com");
        Emp3.setGender("F");
        Emp3.setMaritalStatus("M");
        Emp3.setLocation("Yogyakarta");
        Emp3.setGrade("AP");

        Employee Emp4 = new Employee();
        Emp4.setFirstName("Andrew");
        Emp4.setLastName("Long");
        Emp4.setEmail("andrew.long@employee.com");
        Emp4.setGender("M");
        Emp4.setMaritalStatus("M");
        Emp4.setLocation("Yogyakarta");
        Emp4.setGrade("AN");

        employeeRepository.save(Emp1);
        employeeRepository.save(Emp2);
        employeeRepository.save(Emp3);
        employeeRepository.save(Emp4);
    }
}
