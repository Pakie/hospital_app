package com.pakie.hospital_app.service;

import com.pakie.hospital_app.model.EmploymentType;

import java.util.List;

public interface EmploymentTypeService {
    List<EmploymentType> getAllEmploymentTypes();
    void saveEmploymentType(EmploymentType employmentType);
    EmploymentType getEmploymentTypeById(Long id);
    void deleteEmploymentTypeById(Long id);
}
