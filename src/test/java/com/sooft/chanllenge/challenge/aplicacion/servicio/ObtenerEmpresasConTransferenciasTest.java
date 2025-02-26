package com.sooft.chanllenge.challenge.aplicacion.servicio;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasConTransferenciasPuerto;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ObtenerEmpresasConTransferenciasTest {

    @Mock
    private ObtenerEmpresasConTransferenciasPuerto puerto;

    @InjectMocks
    private ObtenerEmpresasConTransferencias casoUso;

    @Test
    public void testListarEmpresasConTransferenciasUltimoMes() {
        List<Empresa> empresas = List.of(new Empresa());
        Mockito.when(puerto.obtenerEmpresasConTransferenciasUltimoMes()).thenReturn(empresas);

        List<Empresa> resultado = casoUso.listarEmpresasConTransferenciasUltimoMes();

        assertThat(resultado).hasSize(1);

    }
}
