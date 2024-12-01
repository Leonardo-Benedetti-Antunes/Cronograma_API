package com.cronograma.Cesurg.core.dto;

public record SalaTurmaOutput(
        int id,
        int idSala,
        int idTurma,
        String nomeSala,
        String nomeTurma,
        int idCurso,
        String nomeCurso
) {
}