package com.pakie.hospital_app.employment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentTypeServiceImpl implements EmploymentTypeService {

    @Autowired
    public EmploymentTypeRepository employmentTypeRepository;

    @Override
    public List<EmploymentType> getAllEmploymentTypes() {
        return employmentTypeRepository.findAll();
    }

    @Override
    public void saveEmploymentType(EmploymentType employmentType) {
        this.employmentTypeRepository.save(employmentType);
    }

    @Override
    public EmploymentType getEmploymentTypeById(Long id) {
        Optional<EmploymentType> optional = employmentTypeRepository.findById(id);
        EmploymentType employmentType = null;
        if (optional.isPresent()) {
            employmentType = optional.get();
        } else {
            throw new RuntimeException("The Employment Type with ID " + id + " doesn't exist");
        }
        return employmentType;
    }

    @Override
    public void deleteEmploymentTypeById(Long id) {
        employmentTypeRepository.deleteById(id);
    }
}
