package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Turma;

import java.util.List;

public interface TurmaRepository {
    public Turma criar(Turma turma);
    public Turma deletar(int id);
    public Turma atualizar(int id, Turma turma);
    public List<Turma> listar();
    public Turma listarPorID(int id);
}
