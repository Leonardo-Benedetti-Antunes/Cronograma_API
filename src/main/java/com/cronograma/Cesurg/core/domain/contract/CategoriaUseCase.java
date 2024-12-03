package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Categoria;

import java.util.List;

public interface CategoriaUseCase {
    public Categoria criar(Categoria categoria);
    public Categoria deletar(int id);
    public Categoria atualizar(int id, Categoria categoria);
    public List<Categoria> listar();
    public Categoria listarPorID(int id);
}
