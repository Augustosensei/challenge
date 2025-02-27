package com.sooft.chanllenge.challenge.aplicacion.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasAdheridasUltimoMesPuerto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ObtenerEmpresasAdheridasUltimoMes {

    private final ObtenerEmpresasAdheridasUltimoMesPuerto obtenerEmpresasAdheridasPuerto;

    public List<Empresa> listarEmpresasAdheridasUltimoMes() {
        return obtenerEmpresasAdheridasPuerto.obtenerEmpresasAdheridasUltimoMes();
    }

}
