package com.pakie.hospital_app.employment;

import com.pakie.hospital_app.employment.EmploymentType;

import java.util.List;

public interface EmploymentTypeService {
    List<EmploymentType> getAllEmploymentTypes();
    void saveEmploymentType(EmploymentType employmentType);
    EmploymentType getEmploymentTypeById(Long id);
    void deleteEmploymentTypeById(Long id);
}
