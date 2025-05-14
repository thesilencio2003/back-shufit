package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.PromocionDTO;

public interface PromocionService {
    List<PromocionDTO> findAll();

    PromocionDTO findById(Integer id);

    PromocionDTO save(PromocionDTO dto);

    PromocionDTO update(Integer id, PromocionDTO dto);

    void deleteById(Integer id);

    PromocionDTO findByCodigo(String codigoPromocion);

    List<PromocionDTO> findActivas();

    List<PromocionDTO> findByAplicaA(String aplicaA);
}
