package com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.EmpresaEntity;

public interface EmpresaRepositorio extends JpaRepository<EmpresaEntity, Long> {

    List<EmpresaEntity> findByFechaAdhesionAfter(LocalDate fecha);
}
