package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.SalaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Categoria;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SalaController {

    @Autowired
    private SalaUseCase salaUseCase;

    //Métodos básico de sala
    @PostMapping("/sala")
    public Sala criar(@RequestBody Sala sala) {
        return salaUseCase.criar(sala);
    }

    @DeleteMapping("/sala/{id}")
    public Sala deletar(@PathVariable int id) {
        return salaUseCase.deletar(id);
    }

    @GetMapping("/sala")
    public List<Sala> listar() {
        return salaUseCase.listar();
    }

    @PutMapping("/sala/{id}")
    public Sala atualizar(@PathVariable int id, @RequestBody Sala sala) {
        return salaUseCase.atualizar(id, sala);
    }

    @GetMapping("/sala/{id}")
    public Sala listarPorID(@PathVariable int id) {
        return salaUseCase.listarPorID(id);
    }

    // Métodos de sala_categoria
    @PostMapping("/sala/{salaID}/categoria/{categoriaID}")
    public SalaCategoriaCreat adicionarCategoria(@PathVariable int salaID, @PathVariable int categoriaID) {
        return salaUseCase.adicionarCategoria(salaID, categoriaID);
    }

    @GetMapping("/sala/{salaID}/categoria")
    public SalaCategoriaOutput listarSalaCategoriaPorID(@PathVariable int salaID) {
        return salaUseCase.listarSalaCategoriaPorID(salaID);
    }

    @GetMapping("/sala-categoria")
    public List<SalaCategoriaOutput> listarSalaCategoria() {
        return salaUseCase.listarSalaCategoria();
    }

    @PutMapping("/sala-categoria/{id}/categoria/{categoriaID}")
    public SalaCategoriaCreat atualizarCategoria(@PathVariable int id, @PathVariable int categoriaID) {
        return salaUseCase.atualizarCategoria(id, categoriaID);
    }

    @DeleteMapping("/sala-categoria/{id}")
    public SalaCategoriaCreat deletarCategoria(@PathVariable int id) {
        return salaUseCase.deletarCategoria(id);
    }

    //Métodos de sala_turma
    @PostMapping("/sala/{salaID}/turma/{turmaID}")
    public SalaTurmaCreat adicionarTurma(@PathVariable int salaID, @PathVariable int turmaID) {
        return salaUseCase.adicionarTurma(salaID, turmaID);
    }

    @GetMapping("/sala/{salaID}/turma")
    public List<SalaTurmaOutput> listarSalaTurmaPorID(@PathVariable int salaID) {
        return salaUseCase.listarSalaTurmaPorID(salaID);
    }

    @GetMapping("/sala-turma")
    public List<SalaTurmaOutput> listarSalaTurma() {
        return salaUseCase.listarSalaTurma();
    }

    @PutMapping("/sala-turma/{id}/turma/{turmaID}")
    public SalaTurmaCreat atualizarTurma(@PathVariable int id, @PathVariable int turmaID) {
        return salaUseCase.atualizarTurma(id, turmaID);
    }

    @DeleteMapping("/sala-turma/{id}")
    public SalaTurmaCreat deletarTurma(@PathVariable int id) {
        return salaUseCase.deletarTurma(id);
    }

    //Métodos de sala_materia
    @PostMapping("/sala/{salaID}/materia/{materiaID}")
    public SalaMateriaCreat adicionarMateria(@PathVariable int salaID, @PathVariable int materiaID) {
        return salaUseCase.adicionarMateria(salaID, materiaID);
    }

    @GetMapping("/sala/{salaID}/materia")
    public List<SalaMateriaOutput> listarSalaMateriaPorID(@PathVariable int salaID) {
        return salaUseCase.listarSalaMateriaPorID(salaID);
    }

    @GetMapping("/sala-materia")
    public List<SalaMateriaOutput> listarSalaMateria() {
        return salaUseCase.listarSalaMateria();
    }

    @PutMapping("/sala-materia/{id}/materia/{materiaID}")
    public SalaMateriaCreat atualizarMateria(@PathVariable int id, @PathVariable int materiaID) {
        return salaUseCase.atualizarMateria(id, materiaID);
    }

    @DeleteMapping("/sala-materia/{id}")
    public SalaMateriaCreat deletarMateria(@PathVariable int id) {
        return salaUseCase.deletarMateria(id);
    }

}
