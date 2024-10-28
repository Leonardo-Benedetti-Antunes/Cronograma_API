package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.ProfessorUseCase;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorUseCase professorUseCase;

    @PostMapping("/professor")
    public Professor insert(@RequestBody Professor professor) {
        professorUseCase.insert(professor);
        return professor;
    }

    @GetMapping("/professor")
    public List<Professor> fetch() {
        return professorUseCase.fetch();
    }

    @PutMapping("/professorstatus/{id}")
    public void updateStatus(@PathVariable int id,@RequestBody Professor professor) {
        professorUseCase.updateStatus(id,professor);
    }

    @PutMapping("/professor/{id}")
    public void uptade(@PathVariable int id, @RequestBody Professor professor) {
        professorUseCase.update(id, professor);
    }

    @GetMapping("/professor/{id}")
    public Professor get(@PathVariable int id) {
        return professorUseCase.get(id);
    }

    @DeleteMapping("/professor/{id}")
    public void delete(@PathVariable int id) {
        professorUseCase.delete(id);
    }
}
