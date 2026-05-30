package com.example.Proyecto_ABCC_MySQL.controllers;

import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import com.example.Proyecto_ABCC_MySQL.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoRestController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<AlumnoModel>> listarAlumnos() {
        return ResponseEntity.ok(alumnoService.getAllAlumnos());
    }

    @PostMapping
    public ResponseEntity<String> guardarAlumno(@RequestBody AlumnoModel alumno) {
        alumnoService.saveAlumno(alumno);
        return ResponseEntity.ok("Alumno guardado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoModel> obtenerAlumno(@PathVariable long id) {
        return ResponseEntity.ok(alumnoService.getAlumnoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAlumno(@PathVariable long id) {
        alumnoService.deleteAlumnoById(id);
        return ResponseEntity.ok("Alumno eliminado");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAlumno(@PathVariable long id, @RequestBody AlumnoModel alumnoActualizado) {
        alumnoActualizado.setId((int) id); 
        alumnoService.saveAlumno(alumnoActualizado);
        return ResponseEntity.ok("Alumno actualizado");
    }
}