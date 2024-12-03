package com.cronograma.Cesurg.core.dto;

public record SalaCategoriaOutput(
        int id,
        int idSala,
        int idCategoria,
        String nomeSala,
        int quantidade_maxima,
        String nomeCategoria
) {
}