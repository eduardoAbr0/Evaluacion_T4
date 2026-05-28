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
public class AlumnoController {

    @Autowired
    private AlumnoServiceImp alumnoService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listAlumnos", alumnoService.getAllAlumnos());
        return "list";
    }

    @GetMapping("/showNewAlumnoForm")
    public String showNewAlumnoForm(Model model) {
        // create model attribute to bind form data
        AlumnoModel alumno = new AlumnoModel();
        model.addAttribute("alumno", alumno);
        return "new_alumno";
    }

    @PostMapping("/saveAlumno")
    public String saveEmployee(@ModelAttribute("alumno") AlumnoModel employee, RedirectAttributes redirectAttributes) {
        // save employee to database
        alumnoService.saveAlumno(employee);

        redirectAttributes.addFlashAttribute("mensaje", "Alumno guardado con éxito");
        redirectAttributes.addFlashAttribute("class", "alert alert-success");
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        AlumnoModel alumno = alumnoService.getAlumnoById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("alumno", alumno);
        return "update_alumno";
    }

    @GetMapping("/showFormForDetail/{id}")
    public String showFormForDetail(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        AlumnoModel alumno = alumnoService.getAlumnoById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("alumno", alumno);
        return "detail_alumno";
    }

    @GetMapping("/deleteAlumno/{id}")
    public String deleteAlumno(@PathVariable(value = "id") long id, RedirectAttributes redirectAttributes) {

        // call delete employee method 
        this.alumnoService.deleteAlumnoById(id);

        redirectAttributes.addFlashAttribute("mensaje", "Alumno eliminado con éxito");
        redirectAttributes.addFlashAttribute("class", "alert alert-danger");
        return "redirect:/";
    }
}
