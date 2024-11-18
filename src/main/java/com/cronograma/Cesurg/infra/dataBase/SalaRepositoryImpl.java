package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.SalaRepository;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.dto.SalaCategoriaInput;
import com.cronograma.Cesurg.core.dto.SalaCategoriaOutput;
import com.cronograma.Cesurg.core.dto.SalaTurmaOutput;
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
    public void criar(Sala sala) {
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
    public void deletar(int id) {
        var query = "DELETE FROM sala WHERE id =:id;";

        entityManager.createNativeQuery(query, Sala.class).setParameter("id",id).executeUpdate();

    }

    @Transactional
    @Override
    public void atualizar(int id, Sala sala) {
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
    public List<Sala> listar() {
        var query = "SELECT * FROM sala;";
        return entityManager.createNativeQuery(query, Sala.class).getResultList();
    }

    @Override
    public Sala listarPorID(int id) {
        var query = "SELECT * FROM sala WHERE id = :id;";

        return (Sala) entityManager.createNativeQuery(query, Sala.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void adicionarCategoria(int salaID, int categoriaID) {
        var query = """
                INSERT INTO sala_categoria (id_sala, id_categoria)
                VALUES (:salaID, :categoriaID);
                """;
        entityManager.createNativeQuery(query, Sala.class)
                .setParameter("salaID", salaID)
                .setParameter("categoriaID", categoriaID)
                .executeUpdate();
    }


    @Override
    public SalaCategoriaOutput listarCategoria(int salaID) {
        var query = """
                SELECT s.nome AS sala, c.nome AS categoria FROM sala_categoria sc
                INNER JOIN categoria c ON c.id = sc.id_categoria
                INNER JOIN sala s ON s.id = sc.id_sala
                WHERE id_sala = :salaID
                """;
        return (SalaCategoriaOutput) entityManager.createNativeQuery(query, SalaCategoriaOutput.class)
                .setParameter("salaID", salaID)
                .getSingleResult();
    }

    //REVISAR
    @Transactional
    @Override
    public void atualizarCategoria(int salaID, int categoriaID) {
        var query = """
                UPDATE sala_categoria SET
                id_sala = :id_sala
                WHERE id_sala = :id_sala
                """;

        entityManager.createNativeQuery(query, SalaCategoriaInput.class)
            .setParameter("id_sala", salaID)
            .setParameter("id_categoria", categoriaID)
            .executeUpdate();
    }

    //REVISAR

    //REVISAR
    @Override
    public void deletarCategoria(int id) {

    }
    //REVISAR

    @Transactional
    @Override
    public void adicionarTurma(int salaID, int turmaID) {
        var query = """
                INSERT INTO sala_turma (id_sala, id_turma)
                VALUES (:salaID, :turmaID);
                """;
        entityManager.createNativeQuery(query, Sala.class)
                .setParameter("salaID", salaID)
                .setParameter("turmaID", turmaID)
                .executeUpdate();
    }

    @Override
    public List<SalaTurmaOutput> listarTurma(int salaID) {
        var query = """
                SELECT sala.nome AS sala, turma.nome AS turma, curso.nome AS curso FROM sala_turma st
                INNER JOIN sala ON sala.id = st.id_sala
                INNER JOIN turma ON turma.id = st.id_turma
                INNER JOIN curso ON curso.id = turma.id_curso
                WHERE id_sala = :salaID;
                """;
        return entityManager.createNativeQuery(query, SalaTurmaOutput.class)
                .setParameter("salaID", salaID)
                .getResultList();
    }

    @Override
    public void atualizarTurma(int salaID, Sala sala) {

    }

    @Override
    public void deletarTurma(int id) {

    }

}