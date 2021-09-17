package com.pakie.hospital_app.service;

import com.pakie.hospital_app.model.EmploymentPosition;

import java.util.List;

public interface EmploymentPositionService {
    List<EmploymentPosition> getAllEmploymentPositions();
    void saveEmploymentPosition(EmploymentPosition employmentPosition);
    EmploymentPosition getEmploymentPositionById(Long id);
    void deleteEmploymentPositionById(Long id);
}
