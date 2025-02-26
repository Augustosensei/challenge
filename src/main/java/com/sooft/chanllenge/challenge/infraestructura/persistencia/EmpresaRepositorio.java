package com.sooft.chanllenge.challenge.infraestructura.persistencia;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {

    List<Empresa> findByFechaAdhesionAfter(LocalDate fecha);
}
