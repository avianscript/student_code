package com.techelevator.demo.services;

import com.techelevator.demo.model.AuthenticatedUser;
import com.techelevator.demo.model.Department;
import com.techelevator.demo.model.Employee;
import com.techelevator.util.BasicLogger;
import com.techelevator.util.WebUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class DemoService {

    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public DemoService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Department [] getDepartments() {
        try {
            return restTemplate.getForObject(baseUrl + "departments", Department[].class);
        } catch (RestClientResponseException | ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Employee[] getEmployeesByDepartmentId(Integer deptId, AuthenticatedUser user) {
        try {
//            return restTemplate.getForObject(baseUrl + "departments/" + deptId + "/employees", Employee[].class);
            ResponseEntity<Employee[]> response = restTemplate.exchange(baseUrl + "departments/" + deptId + "/employees",
                    HttpMethod.GET, makeGetEntity(user), Employee[].class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException ex) {
            String message = WebUtils.getResponseErrorMessage(ex.getMessage());
            BasicLogger.log(message);
            System.out.println(message);
            return null;
        }
    }

    public void createEmployee(Employee newEmployee, Integer deptId, AuthenticatedUser ussr) {
        try {
            Employee employee = restTemplate.postForObject(baseUrl + "departments/" + deptId + "/employees",
                    makeEmployeeEntity(newEmployee, ussr),
                    Employee.class);
            System.out.println("Employee saved.");
        } catch (RestClientResponseException | ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public HttpEntity<Employee> makeEmployeeEntity(Employee employee, AuthenticatedUser user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(user.getToken());

        return new HttpEntity<>(employee, headers);
    }

    private HttpEntity<Void> makeGetEntity(AuthenticatedUser user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(user.getToken());

        return new HttpEntity<>(headers);
    }

}
