package com.pakie.hospital_app.employment;

import com.pakie.hospital_app.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employment_type")
public class EmploymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "employmentType")
    private Set<Employee> employees;

    public EmploymentType(String name, Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public EmploymentType() {

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
