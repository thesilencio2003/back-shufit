package com.shufitapp.shufit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer> {
     List<Bodega> findByNombreIgnoreCaseContaining(String nombre);
}
