package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.SalaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.domain.usecase.SalaUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaController {

    @Autowired
    private SalaUseCase salaUseCase;

    @PostMapping("/sala")
    public Sala insert(@RequestBody Sala sala) {
        salaUseCase.insert(sala);
        return sala;
    }

    @DeleteMapping("/sala/{id}")
    public void delete(@PathVariable int id) {
        salaUseCase.delete(id);
    }


    @GetMapping("/sala")
    public List<Sala> fetch() {
        return salaUseCase.fetch();
    }

    @PutMapping("/sala/{id}")
    public void uptade(@PathVariable int id, @RequestBody Sala sala) {
        salaUseCase.update(id, sala);
    }

    @GetMapping("/sala/{id}")
    public Sala get(@PathVariable int id) {
        return salaUseCase.get(id);
    }


}
