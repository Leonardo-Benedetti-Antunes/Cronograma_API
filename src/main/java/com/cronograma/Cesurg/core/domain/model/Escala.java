package com.cronograma.Cesurg.core.domain.model;

import com.cronograma.Cesurg.core.domain.entity.Aula;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import com.cronograma.Cesurg.core.domain.entity.TurmaOptaPlanner;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;

import java.util.List;

@PlanningSolution
public class Escala {
    @PlanningEntityCollectionProperty
    private List<TurmaOptaPlanner> turmas;

    private List<Professor> professores; // Dados fixos, não planejáveis

    @PlanningScore
    private HardSoftScore score;

    public List<TurmaOptaPlanner> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<TurmaOptaPlanner> turmas) {
        this.turmas = turmas;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}