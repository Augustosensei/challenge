package com.sooft.chanllenge.challenge.aplicacion.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasConTransferenciasPuerto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObtenerEmpresasConTransferencias {

    private final ObtenerEmpresasConTransferenciasPuerto obtenerEmpresasConTransferenciasPuerto;

    public List<Empresa> listarEmpresasConTransferenciasUltimoMes() {
        return obtenerEmpresasConTransferenciasPuerto.obtenerEmpresasConTransferenciasUltimoMes();
    }
}
