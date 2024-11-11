package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.CategoriaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaUseCaseImpl implements CategoriaUseCase {

    @Override
    public void insert(Categoria categoria) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Categoria categoria) {

    }

    @Override
    public List<Categoria> fetch() {
        return List.of();
    }

    @Override
    public Categoria get(int id) {
        return null;
    }
}
