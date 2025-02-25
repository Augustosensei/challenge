package com.sooft.chanllenge.challenge.dominio.puerto;

import java.util.List;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;

public interface ObtenerEmpresasConTransferenciasPuerto {

    List<Empresa> obtenerEmpresasConTransferenciasUltimoMes();
}
