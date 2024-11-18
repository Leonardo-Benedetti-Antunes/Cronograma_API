package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.MateriaRepository;
import com.cronograma.Cesurg.core.domain.entity.Materia;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MateriaRepositoryImpl implements MateriaRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void criar(Materia materia) {
        var query = """
                INSERT INTO materia (nome)
                VALUES (:nome);
                """;
        entityManager.createNativeQuery(query, Materia.class)
                .setParameter("nome", materia.getNome())
                .executeUpdate();
    }
    @Transactional
    @Override
    public void atualizar(int id, Materia materia) {
        var query = """
                UPDATE materia SET
                nome = :nome 
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Materia.class)
                .setParameter("nome", materia.getNome())
                .setParameter("id", id)
                .executeUpdate();
    }
    @Transactional
    @Override
    public void deletar(int id) {
        var query = """
                DELETE FROM materia WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Materia.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Materia> listarMateria() {
        var query = """
                SELECT * FROM materia;
                """;
        return entityManager.createNativeQuery(query, Materia.class)
                .getResultList();
    }
}

