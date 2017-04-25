package com.bootcamp;

import com.bootcamp.entities.Employee;
import com.bootcamp.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

    @Test
    public void employeeAdd() throws Exception {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("FirstName");
        newEmployee.setLastName("lastName");
        newEmployee.setEmail("first.last@employee.com");
        newEmployee.setGender("M");
        newEmployee.setMaritalStatus("S");

        String expectedResult = "{\"firstName\":\"FirstName\",\"lastName\":\"lastName\",\"dob\":null,\"gender\":\"M\",\"maritalStatus\":\"S\",\"phone\":null,\"email\":\"first.last@employee.com\",\"grade\":null,\"location\":null,\"hiredDate\":null,\"employmentStatus\":null,\"nationality\":null,\"businessUnit\":null,\"division\":null,\"jobFamily\":null,\"stream\":null,\"jobTitle\":null,\"retiredDate\":null,\"suspendedDate\":null,\"activeInd\":false,\"dependents\":null,\"locations\":null,\"gradeHistories\":null,\"addresses\":null,\"empHistories\":null,\"id\":1}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/employee")
                .accept(MediaType.APPLICATION_JSON).content(this.json(newEmployee))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void findEmployeeById () throws Exception {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Employee");
        newEmployee.setLastName("Name");
        newEmployee.setEmail("employee.name@employee.com");
        newEmployee.setGender("M");
        newEmployee.setMaritalStatus("S");

        String expectedResult = "{\"firstName\":\"Employee\",\"lastName\":\"Name\",\"dob\":null,\"gender\":\"M\",\"maritalStatus\":\"S\",\"phone\":null,\"email\":\"employee.name@employee.com\",\"grade\":null,\"location\":null,\"hiredDate\":null,\"employmentStatus\":null,\"nationality\":null,\"businessUnit\":null,\"division\":null,\"jobFamily\":null,\"stream\":null,\"jobTitle\":null,\"retiredDate\":null,\"suspendedDate\":null,\"activeInd\":false,\"dependents\":[],\"locations\":[],\"gradeHistories\":[],\"addresses\":[],\"empHistories\":[],\"id\":1}";

        Employee savedEmployee = employeeRepository.save(newEmployee);
/*
    --
    -- We also can use something like this as well
    --
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
}
