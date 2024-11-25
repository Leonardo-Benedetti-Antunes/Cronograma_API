package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.ProfessorUseCase;
import com.cronograma.Cesurg.core.domain.entity.Materia;
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
  
    public Professor criar(@RequestBody Professor professor) {
        professorUseCase.criar(professor);
        return professor;
    }

    @GetMapping("/professor")
    public List<Professor> listar() {
        return professorUseCase.listarProfessor();
    }

    @PutMapping("/professorstatus/{id}")
    public void atualizarStatus(@PathVariable int id,@RequestBody Professor professor) {
        professorUseCase.atualizarStatus(id,professor);
    }

    @PutMapping("/professor/{id}")
    public void atualizarProfessor(@PathVariable int id, @RequestBody Professor professor) {
        professorUseCase.atualizarProfesor(id, professor);
    }

    @GetMapping("/professor/{id}")
    public Professor listarPorId(@PathVariable int id) {
        return professorUseCase.listarPorId(id);
    }

    @DeleteMapping("/professor/{id}")
    public void deletar(@PathVariable int id) {
        professorUseCase.deletar(id);
    }

    @PostMapping ("/professor/{idProfessor}/materia/{idMateria}")
    public void adicionarMateriaProfessor(@PathVariable int idProfessor, @PathVariable int idMateria){
        professorUseCase.adicionarMateriaProfessor(idProfessor, idMateria);
    }

    @GetMapping ("/professor/{idProfessor}/materia")
    public List<Materia> listarMateriaProfessor(@PathVariable int idProfessor){
        return professorUseCase.listarMateriaProfessor(idProfessor);
    }
    @DeleteMapping ("/professor/{idProfessor}/materia/{idMateria}")
    public void removerMateriaDoProfessor(@PathVariable int idProfessor, @PathVariable int idMateria){
        professorUseCase.removerMateriaDoProfessor(idProfessor, idMateria);
    }

    @DeleteMapping ("/professor/{idProfessor}/dia/{idDia}")
    public void removerDiaDoProfessor(@PathVariable int idProfessor, @PathVariable int idDia){
        professorUseCase.removerDiaDoProfessor(idProfessor, idDia);
    }
}
