package com.cronograma.Cesurg.core.domain.model;

import com.cronograma.Cesurg.core.domain.entity.Aula;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;

import java.util.List;

@PlanningSolution
public class Escala {

    @ValueRangeProvider(id = "professorRange")
    @ProblemFactCollectionProperty
    private List<Professor> professores;

    @PlanningEntityCollectionProperty
    private List<Aula> aulas;

    // Adicione o campo para o score
    @PlanningScore
    private HardSoftScore score;

    public Escala() {}

    public Escala(List<Professor> professores, List<Aula> aulas) {
        this.professores = professores;
        this.aulas = aulas;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}