package com.sooft.chanllenge.challenge.infraestructura.adaptador;

import org.springframework.stereotype.Component;

import com.sooft.chanllenge.challenge.dominio.modelo.Transferencia;
import com.sooft.chanllenge.challenge.dominio.puerto.CrearTransferenciaPuerto;
import com.sooft.chanllenge.challenge.infraestructura.adaptador.mapper.TransferenciaMapper;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.EmpresaRepositorio;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.TransferenciaRepositorio;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.EmpresaEntity;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.TransferenciaEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransferenciaRepositorioAdapter implements CrearTransferenciaPuerto {

    private final TransferenciaRepositorio transferenciaRepositorio;
    private final TransferenciaMapper transferenciaMapper;
    private final EmpresaRepositorio empresaRepositorio;

    @Override
    public Transferencia crearTransferencia(Transferencia transferencia) {

        EmpresaEntity empresaEntity = empresaRepositorio.findById(transferencia.getEmpresa().getId())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        TransferenciaEntity transferenciaEntity = transferenciaMapper.toEntity(transferencia);

        transferenciaEntity.setEmpresa(empresaEntity);
        transferenciaEntity = transferenciaRepositorio.save(transferenciaEntity);

        return transferenciaMapper.toDomain(transferenciaEntity);
    }

}
