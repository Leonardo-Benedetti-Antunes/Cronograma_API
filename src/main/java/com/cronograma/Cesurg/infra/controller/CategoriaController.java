package com.cronograma.Cesurg.infra.controller;

import com.cronograma.Cesurg.core.domain.contract.CategoriaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CategoriaController {

    @Autowired
    private CategoriaUseCase categoriaUseCase;
}
