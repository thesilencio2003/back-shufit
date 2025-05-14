package com.shufitapp.shufit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.CabeceraFactura;

@Repository
public interface CabeceraFacturaRepository extends JpaRepository<CabeceraFactura, Integer>{

}
