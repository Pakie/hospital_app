package com.pakie.hospital_app.department;

import com.pakie.hospital_app.department.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    Department getDepartmentById(Long Id);
    void deleteDepartmentById(Long Id);
}
