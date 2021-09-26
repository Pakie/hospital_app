package com.pakie.hospital_app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
