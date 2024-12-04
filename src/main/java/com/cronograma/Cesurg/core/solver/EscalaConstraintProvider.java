package com.cronograma.Cesurg.core.solver;

import com.cronograma.Cesurg.core.domain.entity.Professor;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;


import java.time.DayOfWeek;

public class EscalaConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                teacherAvailabilityConstraint(constraintFactory)
        };
    }

    Constraint teacherAvailabilityConstraint(ConstraintFactory constraintFactory) {
        // Garante que o professor só é alocado nos dias em que está disponível.
        return constraintFactory
                .forEach(Professor.class)
                .filter(professor -> {
                    // Verifica a disponibilidade do professor com base nos dias atribuídos.
                    return professor.getAssignedDays().stream().anyMatch(dayOfWeek ->
                            (!professor.isSegunda() && dayOfWeek == DayOfWeek.MONDAY) ||
                                    (!professor.isTerca() && dayOfWeek == DayOfWeek.TUESDAY) ||
                                    (!professor.isQuarta() && dayOfWeek == DayOfWeek.WEDNESDAY) ||
                                    (!professor.isQuinta() && dayOfWeek == DayOfWeek.THURSDAY) ||
                                    (!professor.isSexta() && dayOfWeek == DayOfWeek.FRIDAY)
                    );
                })
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Teacher availability");
    }
}

