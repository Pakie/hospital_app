package com.pakie.hospital_app.employment;

import com.pakie.hospital_app.employee.Employee;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "employment_position")
public class EmploymentPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "employmentPosition")
    private Set<Employee> employees;

    public EmploymentPosition(String name, Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public EmploymentPosition() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
