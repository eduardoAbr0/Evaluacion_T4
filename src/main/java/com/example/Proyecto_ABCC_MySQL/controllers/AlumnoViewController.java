package com.example.Proyecto_ABCC_MySQL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import com.example.Proyecto_ABCC_MySQL.services.AlumnoServiceImp;

@Controller
public class AlumnoViewController {

    @Autowired
    private AlumnoServiceImp alumnoService;

    @GetMapping("/showNewAlumnoForm")
    public String showNewAlumnoForm(Model model) {
        AlumnoModel alumno = new AlumnoModel();
        model.addAttribute("alumno", alumno);
        return "new_alumno";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        return "update_alumno";
    }

    @GetMapping("/showFormForDetail/{id}")
    public String showFormForDetail(@PathVariable(value = "id") long id, Model model) {
        return "detail_alumno";
    }

}
