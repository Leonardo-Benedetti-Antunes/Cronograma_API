package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.CategoriaUseCase;
import com.cronograma.Cesurg.core.domain.contract.CategoriaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CategoriaController {

    @Autowired
    private CategoriaUseCase categoriaUseCase;

    @PostMapping("/categoria")
    public Categoria criar(@RequestBody Categoria categoria) {
        return categoriaUseCase.criar(categoria);
    }

    @DeleteMapping("/categoria/{id}")
    public Categoria deletar(@PathVariable int id) {
        return categoriaUseCase.deletar(id);
    }

    @PutMapping("/categoria/{id}")
    public Categoria atualizar(@PathVariable int id, @RequestBody Categoria categoria) {
       return categoriaUseCase.atualizar(id, categoria);
    }

    @GetMapping("/categoria")
    public List<Categoria> listar() {
        return categoriaUseCase.listar();
    }

    @GetMapping("/categoria/{id}")
    public Categoria listarPorID(@PathVariable int id) {
        return categoriaUseCase.listarPorID(id);
    }
}
