package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Categoria;
import com.cronograma.Cesurg.core.domain.entity.Turma;

import java.util.List;

public interface CategoriaRepository {
    public void criar(Categoria categoria);
    public void deletar(int id);
    public void atualizar(int id, Categoria categoria);
    public List<Categoria> listar();
    public Categoria listarPorID(int id);
}
