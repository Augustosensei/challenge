package com.sooft.chanllenge.challenge.api.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sooft.chanllenge.challenge.aplicacion.servicio.AdherirEmpresa;
import com.sooft.chanllenge.challenge.aplicacion.servicio.ObtenerEmpresasAdheridas;
import com.sooft.chanllenge.challenge.aplicacion.servicio.ObtenerEmpresasConTransferencias;
import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {

    private final ObtenerEmpresasConTransferencias obtenerEmpresasConTransferencias;
    private final ObtenerEmpresasAdheridas obtenerEmpresasAdheridas;
    private final AdherirEmpresa adherirEmpresa;

    public EmpresaControlador(
            ObtenerEmpresasConTransferencias obtenerEmpresasConTransferencias,
            ObtenerEmpresasAdheridas obtenerEmpresasAdheridas,
            AdherirEmpresa adherirEmpresa) {
        this.obtenerEmpresasConTransferencias = obtenerEmpresasConTransferencias;
        this.obtenerEmpresasAdheridas = obtenerEmpresasAdheridas;
        this.adherirEmpresa = adherirEmpresa;
    }

    @GetMapping("/transferencias-ultimo-mes")
    public List<Empresa> obtenerEmpresasConTransferencias() {
        return obtenerEmpresasConTransferencias.listarEmpresasConTransferenciasUltimoMes();
    }

    @GetMapping("/adhesion-ultimo-mes")
    public List<Empresa> obtenerEmpresasAdheridas() {
        return obtenerEmpresasAdheridas.listarEmpresasAdheridasUltimoMes();
    }

    @PostMapping("/adhesion")
    public Empresa adherirEmpresa(@RequestBody Empresa empresa) {
        return adherirEmpresa.guardarEmpresa(empresa);
    }
}
