package com.cronograma.Cesurg.infra.controller;


import com.cronograma.Cesurg.core.domain.contract.TurmaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurmaController {

    @Autowired
    private TurmaUseCase turmaUseCase;

    @PostMapping("/turma")
    public void insert(@RequestBody Turma turma) {
        turmaUseCase.insert(turma);
    }

    @DeleteMapping("/turma/{id}")
    public void delete(@PathVariable int id) {
        turmaUseCase.delete(id);
    }

    @PutMapping("/turma/{id}")
    public void update(@PathVariable int id, @RequestBody Turma turma) {
        turmaUseCase.update(id, turma);
    }

    @GetMapping("/turma")
    public List<Turma> fetch() {
        return turmaUseCase.fetch();
    }

    @GetMapping("/turma/{id}")
    public Turma get(@PathVariable int id) {
        return turmaUseCase.get(id);
    }
}
