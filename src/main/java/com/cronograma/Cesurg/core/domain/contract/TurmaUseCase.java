package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Turma;

import java.util.List;

public interface TurmaUseCase {
    public void insert (Turma turma);
    public void delete (int id);
    public void update (int id, Turma turma);
    public List<Turma> fetch();
    public Turma get(int id);
}
