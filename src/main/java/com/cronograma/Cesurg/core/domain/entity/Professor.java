package com.cronograma.Cesurg.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

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
    private boolean segunda;
    private boolean terca;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;

    @ElementCollection
    private Set<DayOfWeek> assignedDays = new HashSet<>();


    public Professor() {}

    public Professor(String nome, boolean disponibilidadeSegunda, boolean disponibilidadeTerca,
                     boolean disponibilidadeQuarta, boolean disponibilidadeQuinta, boolean disponibilidadeSexta) {
        this.nome = nome;
        this.segunda = disponibilidadeSegunda;
        this.terca = disponibilidadeTerca;
        this.quarta = disponibilidadeQuarta;
        this.quinta = disponibilidadeQuinta;
        this.sexta = disponibilidadeSexta;
    }

    public boolean isSegunda() {
        return segunda;
    }

    public void setSegunda(boolean segunda) {
        this.segunda = segunda;
    }

    public boolean isTerca() {
        return terca;
    }

    public void setTerca(boolean terca) {
        this.terca = terca;
    }

    public boolean isQuarta() {
        return quarta;
    }

    public void setQuarta(boolean quarta) {
        this.quarta = quarta;
    }

    public boolean isQuinta() {
        return quinta;
    }

    public void setQuinta(boolean quinta) {
        this.quinta = quinta;
    }

    public boolean isSexta() {
        return sexta;
    }

    public void setSexta(boolean sexta) {
        this.sexta = sexta;
    }

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

    public Set<DayOfWeek> getAssignedDays() {
        return assignedDays;
    }

    public void setAssignedDays(Set<DayOfWeek> assignedDays) {
        this.assignedDays = assignedDays;
    }
}
