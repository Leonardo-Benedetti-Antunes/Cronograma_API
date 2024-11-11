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
    public void updateCategory(int salaID, Sala sala);
    public void deleteCategory(int id);
    public void addClass(int salaID, int turmaID);
    public List<Sala> fetchClass(int turmaID);
    public void updateClass(int salaID, Sala sala);
    public void deleteClass(int id);
}
