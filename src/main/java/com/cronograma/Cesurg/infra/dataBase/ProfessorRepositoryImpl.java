package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.ProfessorRepository;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void insert(Professor professor) {
        var query = """
                INSERT INTO professor(nome, descricao, ativo)
                VALUES (:nome, :descricao, :ativo)
                """;

        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("nome",professor.getNome())
                .setParameter("descricao",professor.getDescricao())
                .setParameter("ativo",professor.isAtivo())
                .executeUpdate();
    }
    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM professor WHERE id =:id;";

        entityManager.createNativeQuery(query, Professor.class).setParameter("id",id).executeUpdate();
    }
    @Transactional
    @Override
    public void updateStatus(int id,  Professor professor) {
        var query = """
                UPDATE professor SET 
                ativo = :ativo
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("ativo",id)
                .setParameter("ativo",professor.isAtivo())
                .executeUpdate();
    }
    @Transactional
    @Override
    public void update(int id, Professor professor) {
        var query = """
                UPDATE professor SET
                nome = :nome,
                descricao = :descricao
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query,Professor.class)
                .setParameter("nome",professor.getNome())
                .setParameter("descricao",professor.getDescricao())
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    public List<Professor> fetch() {
        var query = "SELECT * FROM professor;";

        return entityManager.createNativeQuery(query, Professor.class).getResultList();
    }

    @Override
    public Professor get(int id) {
        var query = "SELECT * FROM professor WHERE id = :id;";

        return (Professor) entityManager.createNativeQuery(query, Professor.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
