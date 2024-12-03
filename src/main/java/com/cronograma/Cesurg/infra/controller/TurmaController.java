package com.cronograma.Cesurg.infra.controller;


import com.cronograma.Cesurg.core.domain.contract.TurmaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TurmaController {

    @Autowired
    private TurmaUseCase turmaUseCase;

    @PostMapping("/turma")
    public Turma criar(@RequestBody Turma turma) {
        return turmaUseCase.criar(turma);
    }

    @DeleteMapping("/turma/{id}")
    public Turma deletar(@PathVariable int id) {
        return turmaUseCase.deletar(id);
    }

    @PutMapping("/turma/{id}")
    public Turma atualizar(@PathVariable int id, @RequestBody Turma turma) {
        return turmaUseCase.atualizar(id, turma);
    }

    @GetMapping("/turma")
    public List<Turma> listar() {
        return turmaUseCase.listar();
    }

    @GetMapping("/turma/{id}")
    public Turma listarPorID(@PathVariable int id) {
        return turmaUseCase.listarPorID(id);
    }
}
