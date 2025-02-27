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
import com.sooft.chanllenge.challenge.aplicacion.servicio.ObtenerUltimaEmpresaAdherida;
import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaControlador {

    private final ObtenerEmpresasConTransferencias obtenerEmpresasConTransferencias;
    private final ObtenerEmpresasAdheridasUltimoMes obtenerEmpresasAdheridas;
    private final AdherirEmpresa adherirEmpresa;
    private final ObtenerUltimaEmpresaAdherida obtenerUltimaEmpresaAdherida;

    @PostMapping("/crear-empresa")
    public Empresa adherirEmpresa(@RequestBody Empresa empresa) {
        return adherirEmpresa.guardarEmpresa(empresa);
    }

    @GetMapping("/empresas-adherida-ultimo-mes")
    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        return obtenerEmpresasAdheridas.listarEmpresasAdheridasUltimoMes();
    }

    @GetMapping("/empresas-con-transferencia")
    public List<Empresa> obtenerEmpresasConTransferencias() {
        return obtenerEmpresasConTransferencias.listarEmpresasConTransferenciasUltimoMes();
    }

    @GetMapping("/ultima-empresa-adherida")
    public Empresa ultimaEmpresaAdherida() {
        return obtenerUltimaEmpresaAdherida.ultimaEmpresaAdherida();
    }

}
