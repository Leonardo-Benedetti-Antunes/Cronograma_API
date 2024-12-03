package com.cronograma.Cesurg.core.dto;

public record SalaMateriaOutput (
        int id,
        int idSala,
        int idMateria,
        String nomeSala,
        int quantidadeMaxima,
        String nomeMateria
) {
}
