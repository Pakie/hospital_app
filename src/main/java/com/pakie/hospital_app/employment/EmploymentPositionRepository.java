package com.pakie.hospital_app.employment;

import com.pakie.hospital_app.employment.EmploymentPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentPositionRepository extends JpaRepository<EmploymentPosition, Long> {

}
