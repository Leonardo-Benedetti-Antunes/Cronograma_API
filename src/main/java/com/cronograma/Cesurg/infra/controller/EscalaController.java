package com.cronograma.Cesurg.infra.controller;


import com.cronograma.Cesurg.core.domain.model.Escala;
import com.cronograma.Cesurg.core.domain.usecase.EscalaService;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/escala")
public class EscalaController {

    private final SolverManager<Escala, Long> solverManager;

    public EscalaController(SolverManager<Escala, Long> solverManager) {
        this.solverManager = solverManager;
    }

    @PostMapping("/resolver")
    public Escala resolverEscala(@RequestBody Escala escala) throws ExecutionException, InterruptedException {
        SolverJob<Escala, Long> solverJob = solverManager.solve(1L, escala);
        Escala escalaResolvida = solverJob.getFinalBestSolution();
        return escalaResolvida;
    }
}
