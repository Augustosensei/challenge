package com.sooft.chanllenge.challenge.aplicacion.servicio;

import org.springframework.stereotype.Service;

import com.sooft.chanllenge.challenge.dominio.modelo.Transferencia;
import com.sooft.chanllenge.challenge.dominio.puerto.CrearTransferenciaPuerto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CrearTransferencia {

    private final CrearTransferenciaPuerto crearTransferenciaPuerto;

    public Transferencia crearTransferencia(Transferencia transferencia) {
        return crearTransferenciaPuerto.crearTransferencia(transferencia);
    }

}
