package com.example.Proyecto_ABCC_MySQL.services;

import java.util.List;

import com.example.Proyecto_ABCC_MySQL.models.UsuarioModel;

public interface UsuarioService {
    UsuarioModel loadUserByUsername(String username);
}
