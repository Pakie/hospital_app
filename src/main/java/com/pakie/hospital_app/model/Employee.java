package com.pakie.hospital_app.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
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
    private String image;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date employmentDate;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "employment_type_id", insertable = false, updatable = false)
    private EmploymentType employmentType;

    @ManyToOne
    @JoinColumn(name = "employment_position_id",insertable = false, updatable = false)
    private EmploymentPosition employmentPosition;

    //Constructor

    public Employee(String firstName, String lastName, String email, String image, Date employmentDate, Department department, EmploymentType employmentType, EmploymentPosition employmentPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
