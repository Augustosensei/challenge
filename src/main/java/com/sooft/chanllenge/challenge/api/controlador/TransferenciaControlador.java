package com.sooft.chanllenge.challenge.api.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sooft.chanllenge.challenge.aplicacion.servicio.CrearTransferencia;

import com.sooft.chanllenge.challenge.dominio.modelo.Transferencia;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transferencias")
@RequiredArgsConstructor
public class TransferenciaControlador {

    private final CrearTransferencia crearTransferencia;

    @PostMapping("/crear-transferencia")
    public Transferencia realiazTransferencia(@RequestBody Transferencia transferencia) {
        return crearTransferencia.crearTransferencia(transferencia);
    }

}
