package com.sooft.chanllenge.challenge.aplicacion.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasAdheridasPuerto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObtenerEmpresasAdheridas {

    private final ObtenerEmpresasAdheridasPuerto obtenerEmpresasAdheridas;

    public List<Empresa> listarEmpresasAdheridasUltimoMes() {
        return obtenerEmpresasAdheridas.obtenerEmpresasAdheridasUltimoMes();
    }

}
