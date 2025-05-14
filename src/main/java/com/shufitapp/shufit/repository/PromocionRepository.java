package com.shufitapp.shufit.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Promocion;

@Repository
public interface PromocionRepository extends JpaRepository<Promocion, Integer> {

    Optional<Promocion> findByCodigoPromocionIgnoreCase(String codigoPromocion);

    List<Promocion> findByFechaFinAfter(LocalDate today);

    List<Promocion> findByAplicaAIgnoreCase(String aplicaA);

}
