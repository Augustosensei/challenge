package com.sooft.chanllenge.challenge.infraestructura.adaptador;

import org.springframework.stereotype.Component;

import com.sooft.chanllenge.challenge.dominio.modelo.Transferencia;
import com.sooft.chanllenge.challenge.dominio.puerto.CrearTransaccionPuerto;
import com.sooft.chanllenge.challenge.infraestructura.adaptador.mapper.TransferenciaMapper;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.TransferenciaRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransferenciaRepositorioAdapter implements CrearTransaccionPuerto {


    private final TransferenciaRepositorio transferenciaRepositorio;
    private final TransferenciaMapper transferenciaMapper;

    @Override
    public Transferencia crearTransaccion(Transferencia transferencia) {
        return transferenciaMapper.toDomain(
            transferenciaRepositorio.save(transferenciaMapper.toEntity(transferencia))
        );
    }
}
