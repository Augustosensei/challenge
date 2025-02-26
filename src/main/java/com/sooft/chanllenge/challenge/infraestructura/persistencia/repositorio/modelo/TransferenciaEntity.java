package com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private EmpresaEntity empresa;

    private BigDecimal importe;
    private String cuentaDebito;
    private String cuentaCredito;
    private LocalDate fecha;

}
