package com.sooft.chanllenge.challenge.api.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sooft.chanllenge.challenge.aplicacion.servicio.AdherirEmpresa;
import com.sooft.chanllenge.challenge.aplicacion.servicio.ObtenerEmpresasAdheridasUltimoMes;
import com.sooft.chanllenge.challenge.aplicacion.servicio.ObtenerEmpresasConTransferencias;
import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaControlador {

    private final ObtenerEmpresasConTransferencias obtenerEmpresasConTransferencias;
    private final ObtenerEmpresasAdheridasUltimoMes obtenerEmpresasAdheridas;
    private final AdherirEmpresa adherirEmpresa;

    @PostMapping("/crear-empresa")
    public Empresa adherirEmpresa(@RequestBody Empresa empresa) {
        return adherirEmpresa.guardarEmpresa(empresa);
    }

    @GetMapping("/empresas-adherida-ultimo-mes")
    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        return obtenerEmpresasAdheridas.listarEmpresasAdheridasUltimoMes();
    }

    @GetMapping("/transferenci")
    public List<Empresa> obtenerEmpresasConTransferencias() {
        return obtenerEmpresasConTransferencias.listarEmpresasConTransferenciasUltimoMes();
    }

    @PostMapping("/adhesion")
    public Empresa adherirEmpresa2(@RequestBody Empresa empresa) {
        return adherirEmpresa.guardarEmpresa(empresa);
    }

}
