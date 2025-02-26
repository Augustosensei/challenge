package com.sooft.chanllenge.challenge.dominio.modelo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Empresa {


    private Long id;
    private String cuit;
    private String razonSocial;
    private LocalDate fechaAdhesion;

}
