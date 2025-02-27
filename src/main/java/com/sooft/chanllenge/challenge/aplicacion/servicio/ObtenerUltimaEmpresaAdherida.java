package com.sooft.chanllenge.challenge.aplicacion.servicio;

import org.springframework.stereotype.Service;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerUltimaEmpreaAdheridaPuerto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObtenerUltimaEmpresaAdherida {

private final ObtenerUltimaEmpreaAdheridaPuerto ultimaEmpreaAdheridaPuerto;

    public Empresa ultimaEmpresaAdherida(){
        return ultimaEmpreaAdheridaPuerto.ultimaEmpreasAdherida();
    }

}
