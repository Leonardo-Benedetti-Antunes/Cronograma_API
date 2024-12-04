package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.model.Escala;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscalaService {

    @Autowired
    private SolverFactory<Escala> solverFactory;

    public Escala solve(Escala escala) {
        Solver<Escala> solver = solverFactory.buildSolver();
        return solver.solve(escala);
    }
}