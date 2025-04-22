package com.linuxtips.descomplicandojavaespring.estudante_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity //esta classe representa uma tabela
@Table (name = "estudante") //declara que esta classe representa a table "estudante"*
@Getter
@Setter

public class Estudante {

       //gerando os campos:

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String nome;

    @Column(nullable = false,length = 10)
    private String endereco;

    @Column(nullable = false)
    private String curso;

    @CreationTimestamp
    @Column (name="criado_em", nullable = false, updatable=false)
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    @Column (name="atualizado_em", nullable = false, updatable=false)
    private LocalDateTime atualizadoEm;

   @OneToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="dadosBancarios_id", referencedColumnName ="id")
   @JsonManagedReference
   private DadosBancarios dadosBancarios;



    }
