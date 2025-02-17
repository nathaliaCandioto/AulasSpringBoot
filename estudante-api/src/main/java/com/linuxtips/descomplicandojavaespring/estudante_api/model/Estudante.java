package com.linuxtips.descomplicandojavaespring.estudante_api.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity //esta classe representa uma tabela
@Table (name = "estudante") //declara que esta classe representa a table "estudante"*

public class Estudante {

       //gerando os campos:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(Long meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(nullable = false,unique = true)
    private String nome;

    @Column(nullable = false,length = 10)
    private String endereco;

    @Column(nullable = false)
    private Long meioPagamento;

    @Column(nullable = false)
    private String curso;


}
