package com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.EmpresaEntity;

public interface EmpresaRepositorio extends JpaRepository<EmpresaEntity, Long> {

    List<EmpresaEntity> findByFechaAdhesionAfter(LocalDate fecha); // obtiene empresas adheridas

    @Query("SELECT e FROM EmpresaEntity e WHERE MONTH(e.fechaAdhesion) = :mes AND YEAR(e.fechaAdhesion) = :anio")
    List<EmpresaEntity> findEmpresasAdheridasUltimoMes(@Param("mes") int mes, @Param("anio") int anio);

    @Query("SELECT DISTINCT t.empresa FROM TransferenciaEntity t WHERE t.fecha > :fecha")
    List<EmpresaEntity> findEmpresasConTransferenciasUltimoMes(@Param("fecha") LocalDate fecha);

    // @Query("SELECT e FROM EmpresaEntity e WHERE e.fechaAdhesion > :fecha")
    // List<EmpresaEntity> findEmpresasAdheridasUltimoMes(@Param("fecha") LocalDate
    // fecha);

}
