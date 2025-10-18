package unilak.ac.rw.mis_project.service;


import unilak.ac.rw.mis_project.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    Department getDepartmentById(int id);
    List<Department> getAllDepartments();
    void deleteDepartmentById(int id);
    Department updateDepartment(Department department);
}