package com.sooft.chanllenge.challenge.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transferencia {

    private Long id;
    private Empresa empresa;
    private BigDecimal importe;
    private String cuentaDebito;
    private String cuentaCredito;
    private LocalDate fecha;

}
