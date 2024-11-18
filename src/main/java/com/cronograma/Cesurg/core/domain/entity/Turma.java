package com.cronograma.Cesurg.core.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name = "turma")
public class Turma {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_curso")
    private int idCurso;

    @Column(name = "nome")
    private String nome;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "data_inicio") //year, month, day
    private LocalDate dataInicio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
}
