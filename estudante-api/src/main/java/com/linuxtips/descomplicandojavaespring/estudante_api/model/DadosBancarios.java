package com.linuxtips.descomplicandojavaespring.estudante_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.linuxtips.descomplicandojavaespring.estudante_api.model.enums.TipoContaBancaria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dados_bancarios")
@Getter
@Setter

public class DadosBancarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Integer agencia;

    @Column (nullable = true)
    private Integer conta;

    @Column(nullable = false)
    private Integer digito;

    @Column(nullable = false)
    private TipoContaBancaria tipoContaBancaria;

    @OneToOne (mappedBy = "dadosBancarios")
    @JsonBackReference
    private Estudante estudante;

}
