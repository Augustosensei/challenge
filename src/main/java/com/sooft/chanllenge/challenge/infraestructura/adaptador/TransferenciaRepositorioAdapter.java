package com.sooft.chanllenge.challenge.infraestructura.adaptador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasConTransferenciasPuerto;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.TransferenciaRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransferenciaRepositorioAdapter implements ObtenerEmpresasConTransferenciasPuerto {

    private final TransferenciaRepositorio transferenciaRepositorio;

    @Override
    public List<Empresa> obtenerEmpresasConTransferenciasUltimoMes() {
        return transferenciaRepositorio.findEmpresasConTransferenciasUltimoMes(LocalDate.now().minusMonths(1));
    }
}
