package com.pakie.hospital_app.employee;

import com.pakie.hospital_app.department.Department;
import com.pakie.hospital_app.employment.EmploymentPosition;
import com.pakie.hospital_app.employment.EmploymentType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date employmentDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "employment_type_id")
    private EmploymentType employmentType;

    @ManyToOne
    @JoinColumn(name = "employment_position_id")
    private EmploymentPosition employmentPosition;

    //Constructor

    public Employee(String firstName, String lastName, String email, Date employmentDate, Department department, EmploymentType employmentType, EmploymentPosition employmentPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.employmentDate = employmentDate;
        this.department = department;
        this.employmentType = employmentType;
        this.employmentPosition = employmentPosition;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public EmploymentPosition getEmploymentPosition() {
        return employmentPosition;
    }

    public void setEmploymentPosition(EmploymentPosition employmentPosition) {
        this.employmentPosition = employmentPosition;
    }
}
