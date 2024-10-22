package com.cronograma.Cesurg.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "professor")
public class Professor {
    @Id
    @Column (name = "id")
    private int id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "descricao")
    private String descricao;
    @Column (name = "ativo")
    private boolean ativo = true;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
