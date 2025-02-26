package com.sooft.chanllenge.challenge.aplicacion.servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.AdherirEmpresaPuerto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdherirEmpresaTest {

    @Mock
    private AdherirEmpresaPuerto adherirEmpresaPuerto;

    @InjectMocks
    private AdherirEmpresa adherirEmpresa;

    private Empresa empresa;

    @BeforeEach
    void setUp() {
        empresa = new Empresa(); 
    }

    @Test
    void testGuardarEmpresa() {
      
        when(adherirEmpresaPuerto.guardar(any(Empresa.class))).thenReturn(empresa);

        Empresa resultado = adherirEmpresa.guardarEmpresa(new Empresa());

        assertThat(resultado)
        .isNotNull()
        .isEqualTo(empresa);
        
        verify(adherirEmpresaPuerto, times(1)).guardar(any(Empresa.class));
    }
}
