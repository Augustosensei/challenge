package com.sooft.chanllenge.challenge.aplicacion.servicio;

import org.springframework.stereotype.Service;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.AdherirEmpresaPuerto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdherirEmpresa {

    private final AdherirEmpresaPuerto adherirEmpresa;

    public Empresa guardarEmpresa(Empresa empresa) {
        return adherirEmpresa.guardar(empresa);
    }

}
