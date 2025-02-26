package com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.TransferenciaEntity;

public interface TransferenciaRepositorio extends JpaRepository<TransferenciaEntity, Long> {

   
}
