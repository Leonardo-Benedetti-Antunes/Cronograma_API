package com.cronograma.Cesurg.infra.controller;


import com.cronograma.Cesurg.core.domain.model.Escala;
import com.cronograma.Cesurg.core.domain.usecase.EscalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EscalaController {

    @Autowired
    private EscalaService escalaService;

    @PostMapping("/solve")
    public Escala solve(@RequestBody Escala escala) {
        return escalaService.solve(escala);
    }
}
