package com.sooft.chanllenge.challenge.infraestructura.persistencia;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.modelo.Transferencia;

public interface TransferenciaRepositorio extends JpaRepository<Transferencia, Long> {

    @Query("SELECT DISTINCT t.empresa FROM Transferencia t WHERE t.fecha > :fecha")
    List<Empresa> findEmpresasConTransferenciasUltimoMes(@Param("fecha") LocalDate fecha);
}
