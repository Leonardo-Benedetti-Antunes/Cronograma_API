package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.TurmaRepository;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.domain.entity.Turma;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurmaRepositoryImpl implements TurmaRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void criar(Turma turma) {
        var query = """
                INSERT INTO turma(id_curso, nome, quantidade, data_inicio)
                VALUES (:id_curso, :nome, :quantidade, :data_inicio)
                """;

        entityManager.createNativeQuery(query, Turma.class)
                .setParameter("id_curso", turma.getIdCurso())
                .setParameter("nome", turma.getNome())
                .setParameter("quantidade", turma.getQuantidade())
                .setParameter("data_inicio", turma.getDataInicio())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletar(int id) {
        var query = "DELETE FROM turma WHERE id =:id;";

        entityManager.createNativeQuery(query, Turma.class).setParameter("id",id).executeUpdate();
    }

    @Transactional
    @Override
    public void atualizar(int id, Turma turma) {
        var query = """
                UPDATE turma SET
                id_curso = :id_curso,
                nome = :nome,
                quantidade = :quantidade,
                data_inicio = :data_inicio
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query,Sala.class)
                .setParameter("id_curso", turma.getIdCurso())
                .setParameter("nome", turma.getNome())
                .setParameter("quantidade", turma.getQuantidade())
                .setParameter("data_inicio", turma.getDataInicio())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Turma> listar() {
        var query = """
                SELECT * FROM turma
                INNER JOIN curso c ON c.id = turma.curso_id
                """;
        return entityManager.createNativeQuery(query, Turma.class).getResultList();
    }

    @Override
    public Turma listarPorID(int id) {
        var query = "SELECT * FROM turma WHERE id = :id;";

        return (Turma) entityManager.createNativeQuery(query, Turma.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
