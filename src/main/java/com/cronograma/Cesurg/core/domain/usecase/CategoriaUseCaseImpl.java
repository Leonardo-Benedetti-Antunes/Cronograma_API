package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.CategoriaRepository;
import com.cronograma.Cesurg.core.domain.contract.CategoriaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaUseCaseImpl implements CategoriaUseCase {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria criar(Categoria categoria) {
        return categoriaRepository.criar(categoria);
    }

    @Override
    public Categoria deletar(int id) {
        return categoriaRepository.deletar(id);
    }

    @Override
    public Categoria atualizar(int id, Categoria categoria) {
        return categoriaRepository.atualizar(id, categoria);
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.listar();
    }

    @Override
    public Categoria listarPorID(int id) {
        return categoriaRepository.listarPorID(id);
    }
}
