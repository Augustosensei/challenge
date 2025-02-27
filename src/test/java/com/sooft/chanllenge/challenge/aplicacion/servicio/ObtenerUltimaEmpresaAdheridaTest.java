package com.sooft.chanllenge.challenge.aplicacion.servicio;



import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerUltimaEmpreaAdheridaPuerto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerUltimaEmpresaAdheridaTest {

    @Mock
    private ObtenerUltimaEmpreaAdheridaPuerto ultimaEmpreaAdheridaPuerto;

    @InjectMocks
    private ObtenerUltimaEmpresaAdherida casoUso;

    private Empresa empresa;

    @BeforeEach
    void setUp() {
        empresa = new Empresa();  
    }

    @Test
    void testObtenerUltimaEmpresaAdherida() {
    
        when(ultimaEmpreaAdheridaPuerto.ultimaEmpreasAdherida()).thenReturn(empresa);

        Empresa resultado = casoUso.ultimaEmpresaAdherida();
        assertThat(resultado)
            .isNotNull()
            .isEqualTo(empresa);

        verify(ultimaEmpreaAdheridaPuerto, times(1)).ultimaEmpreasAdherida();
    }
}
