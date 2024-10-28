package com.cronograma.Cesurg.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "sala")
public class Sala {
    @Id
    @Column(name = "id")
    private int id;
    @Column (name = "nome")
    private String nome;
    @Column (name ="quantidade_maxima")
    private int quantidade_maxima;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade_maxima() {
        return quantidade_maxima;
    }

    public void setQuantidade_maxima(int quantidade_maxima) {
        this.quantidade_maxima = quantidade_maxima;
    }
}
