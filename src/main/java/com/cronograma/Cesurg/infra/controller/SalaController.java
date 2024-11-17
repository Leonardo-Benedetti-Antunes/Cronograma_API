package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.SalaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.dto.SalaCategoriaOutput;
import com.cronograma.Cesurg.core.dto.SalaTurmaOutput;
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

    @PostMapping("/sala")
    public void criar(@RequestBody Sala sala) {
        salaUseCase.criar(sala);
    }

    @DeleteMapping("/sala/{id}")
    public void deletar(@PathVariable int id) {
        salaUseCase.deletar(id);
    }


    @GetMapping("/sala")
    public List<Sala> listar() {
        return salaUseCase.listar();
    }

    @PutMapping("/sala/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Sala sala) {
        salaUseCase.atualizar(id, sala);
    }

    @GetMapping("/sala/{id}")
    public Sala listarPorID(@PathVariable int id) {
        return salaUseCase.listarPorID(id);
    }

    @PostMapping("/sala/{salaID}/categoria/{categoriaID}")
    public ResponseEntity<String> adicionarCategoria(@PathVariable int salaID, @PathVariable int categoriaID) {
        try {
            salaUseCase.adicionarCategoria(salaID, categoriaID);
            return new ResponseEntity<>("Sucesso: Sala e categoria vínculadas.", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Erro: Sala já possui uma vinculação ou ID da sala/categoria não existem."
                    , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/sala/{salaID}/categoria")
    public SalaCategoriaOutput listarCategoria(@PathVariable int salaID) {
        return salaUseCase.listarCategoria(salaID);
    }

    //REVISAR
    @PutMapping("sala/{salaID}/categoria")
    public void atualizarCategoria(@PathVariable int salaID, @RequestBody int categoriaID) {
        salaUseCase.atualizarCategoria(salaID, categoriaID);
    }

    @PostMapping("/sala/{salaID}/turma/{turmaID}")
    public void adicionarTurma(@PathVariable int salaID, @PathVariable int turmaID) {
        salaUseCase.adicionarTurma(salaID, turmaID);
    }

    @GetMapping("/sala/{salaID}/turma")
    public List<SalaTurmaOutput> listarTurma(@PathVariable int salaID) {
        return salaUseCase.listarTurma(salaID);
    }

}
