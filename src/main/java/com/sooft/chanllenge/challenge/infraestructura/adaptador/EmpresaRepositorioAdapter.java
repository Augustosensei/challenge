package com.sooft.chanllenge.challenge.infraestructura.adaptador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.AdherirEmpresaPuerto;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasAdheridasPuerto;
import com.sooft.chanllenge.challenge.infraestructura.adaptador.mapper.EmpresaMapper;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.EmpresaRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpresaRepositorioAdapter implements ObtenerEmpresasAdheridasPuerto, AdherirEmpresaPuerto {

    private final EmpresaRepositorio empresaRepositorio;
    private final EmpresaMapper empresaMapper;

    @Override
    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        LocalDate fechaLimite = LocalDate.now().minusMonths(1);

        return empresaMapper.toDomainList(
            empresaRepositorio.findByFechaAdhesionAfter(fechaLimite)
        );
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return empresaMapper.toDomain(
            empresaRepositorio.save(empresaMapper.toEntity(empresa))
        );
    }
}
