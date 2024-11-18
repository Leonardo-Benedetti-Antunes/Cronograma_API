package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Categoria;

import java.util.List;

public interface CategoriaUseCase {
    public void criar(Categoria categoria);
    public void deletar(int id);
    public void atualizar(int id, Categoria categoria);
    public List<Categoria> listar();
    public Categoria listarPorID(int id);
}
