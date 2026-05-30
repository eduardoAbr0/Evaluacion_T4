package com.example.Proyecto_ABCC_MySQL.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import com.example.Proyecto_ABCC_MySQL.repositories.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService{

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List < AlumnoModel > getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public void saveAlumno(AlumnoModel alumno) {
        this.alumnoRepository.save(alumno);
    }

    @Override
    public AlumnoModel getAlumnoById(long id) {
        Optional < AlumnoModel > optional = alumnoRepository.findById(id);
        AlumnoModel alumno = null;
        if (optional.isPresent()) {
            alumno = optional.get();
        } else {
            throw new RuntimeException(" Alumno not found for id :: " + id);
        }
        return alumno;
    }

    @Override
    public void deleteAlumnoById(long id) {
        this.alumnoRepository.deleteById(id);
    }

}
