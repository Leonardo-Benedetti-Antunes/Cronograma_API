package com.cronograma.Cesurg.core.solver;

import com.cronograma.Cesurg.core.domain.entity.Professor;
import com.cronograma.Cesurg.core.domain.entity.TurmaOptaPlanner;
import org.optaplanner.core.api.score.stream.*;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.ConstraintProvider;



public class EscalaConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                professorDeveEstarDisponivel(constraintFactory),
                evitarConflitoDeHorarios(constraintFactory),
                balancearCargaDeTurmas(constraintFactory)
        };
    }

    private Constraint professorDeveEstarDisponivel(ConstraintFactory constraintFactory) {
        return constraintFactory.from(TurmaOptaPlanner.class)
                .join(Professor.class, Joiners.equal(TurmaOptaPlanner::getProfessor, Professor::getId))
                .filter((turma, professor) -> !professorEstaDisponivel(turma, professor))
                .penalize("Professor indisponível", HardSoftScore.ONE_HARD);
    }

    private boolean professorEstaDisponivel(TurmaOptaPlanner turma, Professor professor) {
        switch (turma.getDiaSemana()) {
            case "Segunda": return professor.isDisponivelSegunda();
            case "Terça": return professor.isDisponivelTerca();
            case "Quarta": return professor.isDisponivelQuarta();
            case "Quinta": return professor.isDisponivelQuinta();
            case "Sexta": return professor.isDisponivelSexta();
            default: return false;
        }
    }

    private Constraint evitarConflitoDeHorarios(ConstraintFactory constraintFactory) {
        return constraintFactory.from(TurmaOptaPlanner.class)
                .groupBy(TurmaOptaPlanner::getProfessor, TurmaOptaPlanner::getDiaSemana, ConstraintCollectors.count())
                .filter((professor, dia, count) -> count > 1)
                .penalize("Conflito de horários", HardSoftScore.ONE_HARD);
    }

    private Constraint balancearCargaDeTurmas(ConstraintFactory constraintFactory) {
        int cargaIdeal = cargaIdeal(constraintFactory);
        return constraintFactory.from(TurmaOptaPlanner.class)
                .groupBy(TurmaOptaPlanner::getProfessor, ConstraintCollectors.count())
                .penalize("Carga desbalanceada", HardSoftScore.ONE_SOFT,
                        (professor, count) -> Math.abs(count - cargaIdeal));
    }

    private int cargaIdeal(ConstraintFactory constraintFactory) {
        // Conta o número total de turmas
        Integer totalTurmas = constraintFactory.from(TurmaOptaPlanner.class)
                .groupBy(ConstraintCollectors.count())
                .findFirst() // Retorna o número de turmas
                .orElse(0);  // Caso não haja turmas, retorna 0

        // Conta o número total de professores
        Integer totalProfessores = constraintFactory.from(Professor.class)
                .groupBy(ConstraintCollectors.count())
                .findFirst() // Retorna o número de professores
                .orElse(1);  // Evita divisão por zero

        return Math.max(1, totalTurmas / totalProfessores);
    }
}

