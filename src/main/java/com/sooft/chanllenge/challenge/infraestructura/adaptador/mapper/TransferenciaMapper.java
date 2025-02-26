package com.sooft.chanllenge.challenge.infraestructura.adaptador.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sooft.chanllenge.challenge.dominio.modelo.Transferencia;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.TransferenciaEntity;

@Mapper(componentModel = "spring")
public interface TransferenciaMapper {

  
    @Mapping(target = "empresa", ignore = true)
    TransferenciaEntity toEntity(Transferencia transferencia);

    @Mapping(target = "empresa", ignore = true)
    Transferencia toDomain(TransferenciaEntity transferenciaEntity);
}
