package com.sooft.chanllenge.challenge.aplicacion.servicio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.AdherirEmpresaPuerto;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AdherirEmpresaTest {

    @Mock
    private AdherirEmpresaPuerto puerto;

    @InjectMocks
    private AdherirEmpresa casoUso;

    @Test
    public void testGuardarEmpresa() {
        Empresa empresa = new Empresa();
        Mockito.when(puerto.guardar(Mockito.any())).thenReturn(empresa);

        Empresa resultado = casoUso.guardarEmpresa(new Empresa());
        assertThat(resultado).isNotNull();
    }

}
