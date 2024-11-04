package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Sala;

import java.util.List;

public interface SalaUseCase {
    public void insert (Sala sala);
    public void delete (int id);
    public void update (int id, Sala sala);
    public List<Sala> fetch();
    public Sala get(int id);
    public void addCategory(int salaID, int categoryID);
    public List<Sala> fetchCategory(int salaID);
    public void addClass(int salaID, int turmaID);
    public List<Sala> fetchClass(int turmaID);
}
