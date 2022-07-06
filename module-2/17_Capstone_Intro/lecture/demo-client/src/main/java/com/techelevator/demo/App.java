package com.techelevator.demo;

import com.techelevator.demo.model.AuthenticatedUser;
import com.techelevator.demo.model.Department;
import com.techelevator.demo.model.Employee;
import com.techelevator.demo.model.UserCredentials;
import com.techelevator.demo.services.AuthenticationService;
import com.techelevator.demo.services.ConsoleService;
import com.techelevator.demo.services.DemoService;
import io.cucumber.java.hu.De;

import java.util.Scanner;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private final DemoService demoService = new DemoService(API_BASE_URL);

    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                listDepartments();
            } else if (menuSelection == 2) {
                listEmployeesForDepartment();
            } else if (menuSelection == 3) {
                createEmployee();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void listDepartments() {
        Department[] departments = demoService.getDepartments();
        displayDepartments(departments);
    }

    private void displayDepartments(Department[] departments) {
        if (departments != null) {
            for (Department department : departments) {
                System.out.println(department.getDepartmentId() + " " + department.getDepartmentName());
            }
        }
    }

    private void createEmployee() {
        String firstName = consoleService.promptForString("Enter first name of new employee: ");
        String lastName = consoleService.promptForString("Enter last name of new employee: ");
        String birthDate = consoleService.promptForString("Enter birthdate of new employee (yyyy-MM-dd): ");

        Employee newEmployee  = new Employee();
        newEmployee.setFirstName(firstName);
        newEmployee.setLastName(lastName);
        newEmployee.setBirthDate(birthDate);

        Department[] departments = demoService.getDepartments();
        displayDepartments(departments);
        Integer deptId = consoleService.promptForInt("Enter department id it list employees for: ");
        for (Department department : departments) {
            if (department.getDepartmentId().equals(deptId)) {
                demoService.createEmployee(newEmployee, deptId);
            }
        }

    }
    private void listEmployeesForDepartment() {
        Department[] departments = demoService.getDepartments();
        displayDepartments(departments);
        Integer deptId = consoleService.promptForInt("Enter department id it list employees for: ");
        for (Department department : departments) {
            if (department.getDepartmentId().equals(deptId)) {
                Employee [] employees = demoService.getEmployeesByDepartmentId(deptId);
                if (employees != null) {
                    for (Employee employee : employees) {
                        System.out.println(employee.getLastName() + ", " + employee.getFirstName() + " " + employee.getBirthDate());
                    }
                }
            }
        }
    }

}
