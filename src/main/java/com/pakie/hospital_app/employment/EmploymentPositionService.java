package com.pakie.hospital_app.employment;

import com.pakie.hospital_app.employment.EmploymentPosition;

import java.util.List;

public interface EmploymentPositionService {
    List<EmploymentPosition> getAllEmploymentPositions();
    void saveEmploymentPosition(EmploymentPosition employmentPosition);
    EmploymentPosition getEmploymentPositionById(Long id);
    void deleteEmploymentPositionById(Long id);
}
