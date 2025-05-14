package com.shufitapp.shufit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Auditoria;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer> {
    List<Auditoria> findByUsuarioContainingIgnoreCase(String usuario);

    List<Auditoria> findByTipoEvento(String tipoEvento);

    List<Auditoria> findByEntidadAfectadaIgnoreCase(String entidadAfectada);

    List<Auditoria> findByFechaHoraEventoBetween(LocalDateTime start, LocalDateTime end);

    List<Auditoria> findByEntidadAfectadaIgnoreCaseAndIdEntidadAfectada(String entidadAfectada,
            Integer idEntidadAfectada);

}
