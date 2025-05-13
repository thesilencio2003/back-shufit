package com.shufitapp.shufit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shufitapp.shufit.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

        boolean existsByNombreUsuario(String nombreUsuario);

}
