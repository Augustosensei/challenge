package com.sooft.chanllenge.challenge.aplicacion.servicio;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasConTransferenciasPuerto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerEmpresasConTransferenciasTest {

    @Mock
    private ObtenerEmpresasConTransferenciasPuerto puerto;

    @InjectMocks
    private ObtenerEmpresasConTransferencias casoUso;

    private List<Empresa> empresas;

    @BeforeEach
    void setUp() {
        empresas = List.of(new Empresa());
    }

    @Test
    void testListarEmpresasConTransferenciasUltimoMes() {
     
        when(puerto.obtenerEmpresasConTransferenciasUltimoMes()).thenReturn(empresas);

        List<Empresa> resultado = casoUso.listarEmpresasConTransferenciasUltimoMes();

        assertThat(resultado)
        .isNotNull()
        .hasSize(1)
        .containsExactlyElementsOf(empresas);

        verify(puerto, times(1)).obtenerEmpresasConTransferenciasUltimoMes();
    }
}
