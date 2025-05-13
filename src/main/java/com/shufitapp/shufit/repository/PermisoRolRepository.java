package com.shufitapp.shufit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.PermisoRol;

@Repository
public interface PermisoRolRepository extends JpaRepository<PermisoRol, Integer> {

    List<PermisoRol> findByRol_IdRol(Integer rolId);
    Optional<PermisoRol> findByRol_IdRolAndNombrePermiso(Integer rolId, String nombrePermiso);
    boolean existsByRol_IdRolAndNombrePermiso(Integer rolId, String nombrePermiso);

}
