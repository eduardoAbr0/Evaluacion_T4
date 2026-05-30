package com.example.Proyecto_ABCC_MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyecto_ABCC_MySQL.models.UsuarioModel;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByUsername(String username);
}