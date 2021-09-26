package com.pakie.hospital_app.employment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmploymentController {

    @Autowired
    EmploymentPositionService employmentPositionService;

    @Autowired
    EmploymentTypeService employmentTypeService;

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

}
