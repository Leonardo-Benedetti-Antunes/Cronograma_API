package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.contractCurso.CursoUseCase;
import com.cronograma.Cesurg.core.domain.entity.Curso;
import com.cronograma.Cesurg.core.domain.entity.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoController {
    @Autowired
    private CursoUseCase cursoUseCase;

    @PostMapping ("/curso")
    public Curso criar (@RequestBody Curso curso) {
        cursoUseCase.criar(curso);
        return curso;
    }

    @GetMapping ("/curso")
    public List<Curso> listar () {
        return cursoUseCase.listarCursos();
    }

    @DeleteMapping ("/curso/{id}")
    public void deletar (@PathVariable int id) {
        cursoUseCase.deletar(id);
    }

    @PutMapping ("/curso/{id}")
    public void atualizar (@PathVariable int id, @RequestBody Curso curso){
        cursoUseCase.atualizar(id, curso);
    }

    @PostMapping("/curso/{idCurso}/materia/{idMateria}")
    public void inserirMateria(@PathVariable int idCurso, @PathVariable int idMateria){
        cursoUseCase.inserirMateria(idCurso, idMateria);
    }

    @GetMapping("/curso/{idCurso}/materia")
    public List<Materia> listarMateria(@PathVariable int idCurso){
        return cursoUseCase.listarMateria(idCurso);
    }
}
