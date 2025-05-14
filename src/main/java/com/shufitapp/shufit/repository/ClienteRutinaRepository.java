package com.shufitapp.shufit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.ClienteRutina;
import com.shufitapp.shufit.Models.ClienteRutinaId;

@Repository
public interface ClienteRutinaRepository extends JpaRepository<ClienteRutina, ClienteRutinaId> {

    List<ClienteRutina> findByClienteId(Integer clienteId);

    List<ClienteRutina> findByRutinaId(Integer rutinaId);

    boolean existsByClienteIdAndRutinaId(Integer clienteId, Integer rutinaId);

}
