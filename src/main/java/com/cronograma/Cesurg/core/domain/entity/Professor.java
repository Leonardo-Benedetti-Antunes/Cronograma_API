package com.cronograma.Cesurg.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@PlanningEntity
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
    private boolean disponivelSegunda;
    private boolean disponivelTerca;
    private boolean disponivelQuarta;
    private boolean disponivelQuinta;
    private boolean disponivelSexta;

    public boolean isDisponivelSegunda() {
        return disponivelSegunda;
    }

    public void setDisponivelSegunda(boolean disponivelSegunda) {
        this.disponivelSegunda = disponivelSegunda;
    }

    public boolean isDisponivelTerca() {
        return disponivelTerca;
    }

    public void setDisponivelTerca(boolean disponivelTerca) {
        this.disponivelTerca = disponivelTerca;
    }

    public boolean isDisponivelQuarta() {
        return disponivelQuarta;
    }

    public void setDisponivelQuarta(boolean disponivelQuarta) {
        this.disponivelQuarta = disponivelQuarta;
    }

    public boolean isDisponivelQuinta() {
        return disponivelQuinta;
    }

    public void setDisponivelQuinta(boolean disponivelQuinta) {
        this.disponivelQuinta = disponivelQuinta;
    }

    public boolean isDisponivelSexta() {
        return disponivelSexta;
    }

    public void setDisponivelSexta(boolean disponivelSexta) {
        this.disponivelSexta = disponivelSexta;
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

}
