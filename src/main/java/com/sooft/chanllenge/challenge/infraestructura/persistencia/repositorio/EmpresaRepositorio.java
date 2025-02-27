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

    @Query("SELECT e FROM EmpresaEntity e WHERE MONTH(e.fechaAdhesion) = :mes AND YEAR(e.fechaAdhesion) = :anio AND e.transferencias IS NOT EMPTY")
    List<EmpresaEntity> findEmpresasConTransferenciasUltimoMes(@Param("mes") int mes, @Param("anio") int anio);
    

    @Query("SELECT e FROM EmpresaEntity e WHERE e.id = (SELECT MAX(e2.id) FROM EmpresaEntity e2)")
    EmpresaEntity findUltimaEmpresaAdherida();
    


}
