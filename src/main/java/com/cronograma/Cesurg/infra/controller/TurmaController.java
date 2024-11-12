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
    public void criar(@RequestBody Turma turma) {
        turmaUseCase.criar(turma);
    }

    @DeleteMapping("/turma/{id}")
    public void deletar(@PathVariable int id) {
        turmaUseCase.deletar(id);
    }

    @PutMapping("/turma/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Turma turma) {
        turmaUseCase.atualizar(id, turma);
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
