package com.pakie.hospital_app.service;

import com.pakie.hospital_app.model.Department;
import com.pakie.hospital_app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        this.departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        Optional<Department> optional = departmentRepository.findById(id);
        Department department = null;
        if (optional.isPresent()){
            department = optional.get();
        } else {
            throw new RuntimeException("The department with ID " + id + " does not exist");
        }
        return department;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        this.departmentRepository.deleteById(id);
    }
}
