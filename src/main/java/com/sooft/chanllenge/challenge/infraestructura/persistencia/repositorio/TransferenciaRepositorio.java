package com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.EmpresaEntity;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.TransferenciaEntity;

public interface TransferenciaRepositorio extends JpaRepository<TransferenciaEntity, Long> {

    @Query("SELECT DISTINCT t.empresa FROM TransferenciaEntity t WHERE t.fecha > :fecha")
    List<EmpresaEntity> findEmpresasConTransferenciasUltimoMes(@Param("fecha") LocalDate fecha);
}
