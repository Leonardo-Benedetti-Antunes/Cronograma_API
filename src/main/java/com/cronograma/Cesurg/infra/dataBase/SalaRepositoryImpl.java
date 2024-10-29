package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.SalaRepository;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaRepositoryImpl implements SalaRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void insert(Sala sala) {
        var query = """
                INSERT INTO sala(nome, quantidade_maxima)
                VALUES (:nome, :quantidade_maxima)
                """;

        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("nome",sala.getNome())
                .setParameter("quantidade_maxima",sala.getQuantidadeMaxima())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM sala WHERE id =:id;";

        entityManager.createNativeQuery(query, Sala.class).setParameter("id",id).executeUpdate();

    }

    @Transactional
    @Override
    public void update(int id, Sala sala) {
        var query = """
                UPDATE sala SET
                nome = :nome,
                quantidade_maxima = :quantidade_maxima
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query,Sala.class)
                .setParameter("nome",sala.getNome())
                .setParameter("quantidade_maxima",sala.getQuantidadeMaxima())
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    public List<Sala> fetch() {
        var query = "SELECT * FROM sala;";
        return entityManager.createNativeQuery(query, Sala.class).getResultList();
    }

    @Override
    public Sala get(int id) {
        var query = "SELECT * FROM sala WHERE id = :id;";

        return (Sala) entityManager.createNativeQuery(query, Sala.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
