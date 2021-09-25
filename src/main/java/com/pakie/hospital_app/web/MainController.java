package com.pakie.hospital_app.web;

import com.pakie.hospital_app.model.Department;
import com.pakie.hospital_app.model.Employee;
import com.pakie.hospital_app.model.EmploymentPosition;
import com.pakie.hospital_app.model.EmploymentType;
import com.pakie.hospital_app.repository.DepartmentRepository;
import com.pakie.hospital_app.repository.EmployeeRepository;
import com.pakie.hospital_app.repository.EmploymentPositionRepository;
import com.pakie.hospital_app.repository.EmploymentTypeRepository;
import com.pakie.hospital_app.service.DepartmentService;
import com.pakie.hospital_app.service.EmployeeService;
import com.pakie.hospital_app.service.EmploymentPositionService;
import com.pakie.hospital_app.service.EmploymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmploymentPositionService employmentPositionService;

    @Autowired
    private EmploymentTypeService employmentTypeService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "index.html";
    }

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

    //List Departments
    @GetMapping("/departments")
    //public String departments(){
    public String getAllDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments/departments";
    }

    @GetMapping("/add-department")
    public String addDepartment(Model model){
        Department department = new Department();
        model.addAttribute("department", department);
        return "departments/add_department";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department){
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }
    @GetMapping("/update-department/{id}")
    public String updateDepartment(@PathVariable(value = "id") Long id, Model model){
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);

        return "departments/update_department";
    }
    @GetMapping("/delete-department/{id}")
    public String deleteDepartment(@PathVariable(value = "id") Long id, Model model){
        this.departmentService.deleteDepartmentById(id);
        return "redirect:/departments";
    }
    //Employment Positions
    @GetMapping("/employment-positions")
    public String getEmploymentPositions(Model model) {
        model.addAttribute("employmentPositions", employmentPositionService.getAllEmploymentPositions());
        return "employment_positions/employment_positions";
    }
    @GetMapping("/add-employment-position")
    public String addEmploymentPosition(Model model){
        EmploymentPosition employmentPosition = new EmploymentPosition();
        model.addAttribute("employmentPosition", employmentPosition);
        return "employment_positions/add_employment_position";
    }
    @PostMapping("/saveEmploymentPosition")
    public String saveEmploymentPosition(@ModelAttribute("employment_position") EmploymentPosition employmentPosition) {
        employmentPositionService.saveEmploymentPosition(employmentPosition);
        return "redirect:/employment-positions";
    }
    @GetMapping("/update-employment-position/{id}")
    public String updateEmploymentPosition(@PathVariable(value = "id") Long id, Model model) {
        EmploymentPosition employmentPosition = employmentPositionService.getEmploymentPositionById(id);
        model.addAttribute("employmentPosition", employmentPosition);
        return "employee_positions/employee_position";
    }

    @GetMapping("/delete-employment-position/{id}")
    public String deleteEmploymentPosition(@PathVariable(value = "id") Long id, Model model) {
        this.employmentPositionService.deleteEmploymentPositionById(id);
        return "redirect:/employment-positions";
    }

    //Employment Type
    @GetMapping("/employment-types")
    public String employmentTypes(Model model) {
        model.addAttribute("employmentTypes", employmentTypeService.getAllEmploymentTypes());
        return "employment_types/employment_types";
    }

    @GetMapping("/add-employment-type")
    public String addEmploymentType(Model model) {
        EmploymentType employmentType = new EmploymentType();
        model.addAttribute("employmentType", employmentType);
        return "employment_types/add_employment_type";
    }

    @PostMapping("/saveEmploymentType")
    public String saveEmploymentType(@ModelAttribute("employmentType") EmploymentType employmentType) {
        employmentTypeService.saveEmploymentType(employmentType);
        return "redirect:/employment-types";
    }
    @GetMapping("/update-employment-type/{id}")
    public String updateEmploymentType(@PathVariable(value = "id") Long id, Model model) {
        EmploymentType employmentType = employmentTypeService.getEmploymentTypeById(id);
        model.addAttribute("employmentType", employmentType);
        return "employment_types/update_employment_type";
    }
    @GetMapping("/delete-employment-type/{id}")
    public String deleteEmploymentType(@PathVariable(value = "id") Long id, Model model) {
        this.employmentTypeService.deleteEmploymentTypeById(id);
        return "redirect:/employee-types";
    }
    @GetMapping("/doctors")
    public String doctors(){
        return "doctors";
    }

    @GetMapping("/nurses")
    public String nurses(){
        return "nurses.html";
    }

    @GetMapping("/pharmacists")
    public String pharmacists(){
        return "parmacists.html";
    }

    @GetMapping("/patients")
    public String patients(){
        return "patients.html";
    }
}
