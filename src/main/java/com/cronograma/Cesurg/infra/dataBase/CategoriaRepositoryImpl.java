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
    public void criar(Categoria categoria) {
        var query = """
                INSERT INTO categoria(nome)
                VALUES (:nome)
                """;

        entityManager.createNativeQuery(query, Categoria.class)
                .setParameter("nome",categoria.getNome())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletar(int id) {
        var query = "DELETE FROM categoria WHERE id =:id;";
        entityManager.createNativeQuery(query, Categoria.class).setParameter("id",id).executeUpdate();
    }

    @Transactional
    @Override
    public void atualizar(int id, Categoria categoria) {
        var query = """
                UPDATE categoria SET
                nome = :nome
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Categoria.class)
                .setParameter("nome", categoria.getNome())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Categoria> listar() {
        var query = "SELECT * FROM categoria";

        return entityManager.createNativeQuery(query, Categoria.class).getResultList();
    }

    @Override
    public Categoria listarPorID(int id) {
        var query = "SELECT * FROM categoria WHERE id = :id";

        return (Categoria) entityManager.createNativeQuery(query, Categoria.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
