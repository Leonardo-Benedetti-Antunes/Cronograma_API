package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.ProfessorUseCase;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProfessorController {
    @Autowired
    private ProfessorUseCase professorUseCase;

    @PostMapping("/professor")
    public void criar(@RequestBody Professor professor) {
        professorUseCase.criar(professor);
    }

    @GetMapping("/professor")
    public List<Professor> listar() {
        return professorUseCase.listar();
    }

    @PutMapping("/professorstatus/{id}")
    public void atualizarStatus(@PathVariable int id,@RequestBody Professor professor) {
        professorUseCase.atualizarStatus(id,professor);
    }

    @PutMapping("/professor/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Professor professor) {
        professorUseCase.atualizar(id, professor);
    }

    @GetMapping("/professor/{id}")
    public Professor listarPorId(@PathVariable int id) {
        return professorUseCase.listarPorId(id);
    }

    @DeleteMapping("/professor/{id}")
    public void deletar(@PathVariable int id) {
        professorUseCase.deletar(id);
    }
}
