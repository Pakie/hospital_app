package com.pakie.hospital_app.service;

import com.pakie.hospital_app.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    Department getDepartmentById(Long Id);
    void deleteDepartmentById(Long Id);
}
