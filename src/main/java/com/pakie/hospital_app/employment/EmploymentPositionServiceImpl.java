package com.pakie.hospital_app.employment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentPositionServiceImpl implements EmploymentPositionService {

    @Autowired
    private EmploymentPositionRepository employmentPositionRepository;

    @Override
    public List<EmploymentPosition> getAllEmploymentPositions() {
        return employmentPositionRepository.findAll();
    }

    @Override
    public void saveEmploymentPosition(EmploymentPosition employmentPosition) {
        this.employmentPositionRepository.save(employmentPosition);
    }

    @Override
    public EmploymentPosition getEmploymentPositionById(Long id) {
        Optional<EmploymentPosition> optional = employmentPositionRepository.findById(id);
        EmploymentPosition employmentPosition = null;
        if (optional.isPresent()) {
            employmentPosition = optional.get();
        } else {
            throw new RuntimeException("The employment postition with ID " + id + " doesn't exist" );
        }
        return employmentPosition;
    }

    @Override
    public void deleteEmploymentPositionById(Long id) {
        this.employmentPositionRepository.deleteById(id);
    }
}
