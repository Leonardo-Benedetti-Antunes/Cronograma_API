package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.CategoriaRepository;
import com.cronograma.Cesurg.core.domain.entity.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void insert(Categoria categoria) {

    }

    @Transactional
    @Override
    public void delete(int id) {

    }

    @Transactional
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
