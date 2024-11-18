package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.MateriaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MateriaController {

    @Autowired
    private MateriaUseCase materiaUseCase;

    @PostMapping ("/materia")
    public Materia criar (@RequestBody Materia materia){
        materiaUseCase.criar(materia);
        return (materia);
    }

    @GetMapping ("/materia")
    public List<Materia> listar (){
        return materiaUseCase.listarMateria();
    }

    @DeleteMapping ("/materia/{id}")
    public void deletar (@PathVariable int id){
        materiaUseCase.deletar(id);
    }

    @PutMapping ("/materia/{id}")
    public void update (@PathVariable int id, @RequestBody Materia materia){
        materiaUseCase.atualizar(id, materia);
    }
}
