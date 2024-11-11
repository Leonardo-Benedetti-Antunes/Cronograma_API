package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Categoria;
import com.cronograma.Cesurg.core.domain.entity.Turma;

import java.util.List;

public interface CategoriaRepository {
    public void insert (Categoria categoria);
    public void delete (int id);
    public void update (int id, Categoria categoria);
    public List<Categoria> fetch();
    public Categoria get(int id);
}
