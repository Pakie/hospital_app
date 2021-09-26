package com.pakie.hospital_app.employee;

import com.pakie.hospital_app.department.DepartmentService;
import com.pakie.hospital_app.employment.EmploymentPositionService;
import com.pakie.hospital_app.employment.EmploymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmploymentTypeService employmentTypeService;

    @Autowired
    EmploymentPositionService employmentPositionService;

    //List Employees
    @GetMapping("/employees")
    //public String getEmployees(){
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees/employees";
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("employmentPositions", employmentPositionService.getAllEmploymentPositions());
        model.addAttribute("employmentTypes", employmentTypeService.getAllEmploymentTypes());
        return "employees/add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/update-employee/{id}")
    public String updateEmployee(@PathVariable(value = "id") Long id, Model model){
        //Get Employee from employeeService
        Employee employee = employeeService.getEmployeeById(id);

        //Set employee as an attribute to pre-populate the form
        model.addAttribute("employee", employee);

        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("employmentPositions", employmentPositionService.getAllEmploymentPositions());
        model.addAttribute("employmentTypes", employmentTypeService.getAllEmploymentTypes());

        return "employees/update_employee";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id, Model model) {
        //Call a Delete Method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
