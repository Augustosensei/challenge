package com.sooft.chanllenge.challenge.infraestructura.adaptador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasConTransferenciasPuerto;
import com.sooft.chanllenge.challenge.infraestructura.adaptador.mapper.EmpresaMapper;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.TransferenciaRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransferenciaRepositorioAdapter implements ObtenerEmpresasConTransferenciasPuerto {

    private final TransferenciaRepositorio transferenciaRepositorio;
    private final EmpresaMapper empresaMapper;

    @Override
    public List<Empresa> obtenerEmpresasConTransferenciasUltimoMes() {
        LocalDate fechaLimite = LocalDate.now().minusMonths(1);

        return empresaMapper.toDomainList(
            transferenciaRepositorio.findEmpresasConTransferenciasUltimoMes(fechaLimite)
        );
    }
}
