package com.techelevator.demo.service;

import com.techelevator.demo.dao.DepartmentDao;
import com.techelevator.demo.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentService {

    private DepartmentDao departmentDao;
    private UserService userService;

    public DepartmentService(DepartmentDao departmentDao, UserService userService) {
        this.departmentDao = departmentDao;
        this.userService = userService;
    }

    public List<Department> getDepartments() {
        return departmentDao.list();
    }

    public void addEmployeeToDepartment(Long employeeId, Long deptId) {
        departmentDao.addEmployeeToDepartment(employeeId,deptId);
    }


    /*
    public void validateDepartmentOwner(Long deptId, String username) throws NotDepartmentHeadException {
        try {
            Long departmentHeadId = departmentDao.getDepartmentOwnerId(deptId);
            Long loggedInUserId = userService.findIdByUsername(username);
            if (loggedInUserId != null) {
                if (!departmentHeadId.equals(loggedInUserId)) {
                    throw new NotDepartmentHeadException("You must be the department head to perform this operation.");
                }
            }
        } catch (DepartmentHeadNotFoundException ex) {
            throw new NotDepartmentHeadException("You must be the department head to perform this operation.");
        }
    }
     */
}
