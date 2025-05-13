package com.shufitapp.shufit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shufitapp.shufit.Models.Rol;

public interface RolRepository extends JpaRepository<Rol,Integer> {

    boolean existsByNombreRol(String nombreRol);

}
