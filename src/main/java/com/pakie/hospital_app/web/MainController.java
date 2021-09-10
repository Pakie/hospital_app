package com.pakie.hospital_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "index.html";
    }

    @GetMapping("/employees")
    public String employees(){
        return "employees.html";
    }

    @GetMapping("/doctors")
    public String doctors(){
        return "doctors.html";
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
