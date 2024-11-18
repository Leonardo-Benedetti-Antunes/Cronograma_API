package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.DiasdaSemanaUseCase;
import com.cronograma.Cesurg.core.domain.entity.DiasdaSemana;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiasdaSemanaController{

    @Autowired
    private DiasdaSemanaUseCase diasdaSemanaUseCase;

    @GetMapping ("/dias_da_semana")
    public List<DiasdaSemana> listar() { return diasdaSemanaUseCase.listarDias();}

    @PutMapping ("/dias_da_semana/{id}")
    public void atualizarStatus (@PathVariable int id, @RequestBody DiasdaSemana diasdaSemana) {
        diasdaSemanaUseCase.atualizarStatus(id,diasdaSemana);
    }

    @GetMapping("/dias_da_semana/{idDia}/professor")
    public List<Professor> listarProfessor(@PathVariable int idDia) {
        return diasdaSemanaUseCase.listarDiaProfessor(idDia);
    }

}