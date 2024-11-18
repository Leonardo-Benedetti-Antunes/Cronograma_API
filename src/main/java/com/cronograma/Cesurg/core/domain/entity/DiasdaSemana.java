package com.cronograma.Cesurg.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "dias_da_semana")
public class DiasdaSemana {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nome_dia")
    private String nome_dia;
    @Column(name = "disponivel")
    private boolean disponivel = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_dia() {
        return nome_dia;
    }

    public void setNome_dia(String nome_dia) {
        this.nome_dia = nome_dia;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
