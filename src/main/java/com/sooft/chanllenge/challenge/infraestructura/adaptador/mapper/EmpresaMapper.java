package com.sooft.chanllenge.challenge.infraestructura.adaptador.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.EmpresaEntity;

@Mapper(componentModel = "spring" , uses = TransferenciaMapper.class)
public interface EmpresaMapper {

    @Mapping(source = "fechaAdhesion", target = "fechaAdhesion")  
    Empresa toDomain(EmpresaEntity entity);

    List<Empresa> toDomainList(List<EmpresaEntity> entities);
   
    @Mapping(source = "fechaAdhesion", target = "fechaAdhesion")  
    EmpresaEntity toEntity(Empresa empresa);

}
