package com.pakie.hospital_app.repository;

import com.pakie.hospital_app.model.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentTypeRepository extends JpaRepository<EmploymentType, Long> {

}
