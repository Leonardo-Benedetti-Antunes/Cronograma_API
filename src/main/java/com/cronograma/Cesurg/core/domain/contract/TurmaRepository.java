package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Turma;

import java.util.List;

public interface TurmaRepository {
    public void criar(Turma turma);
    public void deletar(int id);
    public void atualizar(int id, Turma turma);
    public List<Turma> listar();
    public Turma listarPorID(int id);
}
