package com.cronograma.Cesurg.core.domain.entity;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Aula {

    private String diaDaSemana;

    @PlanningVariable(valueRangeProviderRefs = "professorRange")
    private Professor professor;

    private int quantidadeDeAulas;

    public int getQuantidadeDeAulas() {
        return quantidadeDeAulas;
    }

    public void setQuantidadeDeAulas(int quantidadeDeAulas) {
        this.quantidadeDeAulas = quantidadeDeAulas;
    }

    public Aula() {}

    public Aula(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}