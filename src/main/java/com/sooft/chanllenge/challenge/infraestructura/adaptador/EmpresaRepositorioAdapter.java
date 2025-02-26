package com.sooft.chanllenge.challenge.infraestructura.adaptador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.AdherirEmpresaPuerto;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasAdheridasPuerto;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.EmpresaRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpresaRepositorioAdapter implements ObtenerEmpresasAdheridasPuerto, AdherirEmpresaPuerto {

    private final EmpresaRepositorio empresaRepositorio;

    @Override
    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        return empresaRepositorio.findByFechaAdhesionAfter(LocalDate.now().minusMonths(1));
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return empresaRepositorio.save(empresa);
    }

}
