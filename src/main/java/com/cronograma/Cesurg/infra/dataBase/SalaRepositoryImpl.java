package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.SalaRepository;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.dto.*;
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
    public SalaCategoriaOutput listarSalaCategoriaPorID(int salaID) {
        var query = """
                SELECT sc.id, sc.id_sala, sc.id_categoria, s.nome AS sala, s.quantidade_maxima, c.nome AS categoria FROM sala_categoria sc
                INNER JOIN categoria c ON c.id = sc.id_categoria
                INNER JOIN sala s ON s.id = sc.id_sala
                WHERE id_sala = :salaID
                """;
        return (SalaCategoriaOutput) entityManager.createNativeQuery(query, SalaCategoriaOutput.class)
                .setParameter("salaID", salaID)
                .getSingleResult();
    }

    @Override
    public List<SalaCategoriaOutput> listarSalaCategoria() {
        var query = """
                SELECT sc.id, sc.id_sala, sc.id_categoria, s.nome AS sala, s.quantidade_maxima, c.nome AS categoria FROM sala_categoria sc
                INNER JOIN categoria c ON c.id = sc.id_categoria
                INNER JOIN sala s ON s.id = sc.id_sala
                """;
        return entityManager.createNativeQuery(query, SalaCategoriaOutput.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void atualizarCategoria(int id, int categoriaID) {
        var query = """
                UPDATE sala_categoria SET
                id_categoria = :categoriaID
                WHERE id = :id
                """;

        entityManager.createNativeQuery(query, SalaCategoriaOutput.class)
            .setParameter("id", id)
            .setParameter("categoriaID", categoriaID)
            .executeUpdate();

    }

    @Transactional
    @Override
    public void deletarCategoria(int id) {
        var query = "DELETE FROM sala_categoria WHERE id =:id;";

        entityManager.createNativeQuery(query, SalaCategoriaOutput.class).setParameter("id",id).executeUpdate();

    }

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
    public List<SalaTurmaOutput> listarSalaTurmaPorID(int salaID) {
        var query = """
                SELECT st.id, st.id_sala, st.id_turma, sala.nome AS sala, turma.nome AS turma, curso.id, curso.nome AS curso FROM sala_turma st
                INNER JOIN sala ON sala.id = st.id_sala
                INNER JOIN turma ON turma.id = st.id_turma
                INNER JOIN curso ON curso.id = turma.id_curso
                WHERE id_sala = :salaID;
                """;
        return entityManager.createNativeQuery(query, SalaTurmaOutput.class)
                .setParameter("salaID", salaID)
                .getResultList();
    }

    public List<SalaTurmaOutput> listarSalaTurma() {
        var query = """
                SELECT st.id, st.id_sala, st.id_turma, sala.nome AS sala, turma.nome AS turma, curso.id, curso.nome AS curso FROM sala_turma st
                INNER JOIN sala ON sala.id = st.id_sala
                INNER JOIN turma ON turma.id = st.id_turma
                INNER JOIN curso ON curso.id = turma.id_curso
                """;
        return entityManager.createNativeQuery(query, SalaTurmaOutput.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void atualizarTurma(int id, int turmaID) {
        var query = """
                UPDATE sala_turma SET
                id_turma = :turmaID
                WHERE id = :id
                """;

        entityManager.createNativeQuery(query, SalaTurmaOutput.class)
                .setParameter("id", id)
                .setParameter("turmaID", turmaID)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletarTurma(int id) {
        var query = "DELETE FROM sala_turma WHERE id =:id;";

        entityManager.createNativeQuery(query, SalaTurmaOutput.class).setParameter("id",id).executeUpdate();

    }

    @Transactional
    @Override
    public void adicionarMateria(int salaID, int materiaID) {
        var query = """
                INSERT INTO materia_sala(id_sala, id_materia)
                VALUES (:salaID, :materiaID);
                """;
        entityManager.createNativeQuery(query, Sala.class)
                .setParameter("salaID", salaID)
                .setParameter("materiaID", materiaID)
                .executeUpdate();
    }

    @Override
    public List<SalaMateriaOutput> listarSalaMateriaPorID(int salaID) {
        var query = """
                SELECT sm.id, sm.id_sala, sm.id_materia, sala.nome AS sala, sala.quantidade_maxima, materia.nome AS materia FROM materia_sala sm
                INNER JOIN sala ON sala.id = sm.id_sala
                INNER JOIN materia ON materia.id = sm.id_materia
                WHERE id_sala = :salaID
                """;
        return entityManager.createNativeQuery(query, SalaMateriaOutput.class)
                .setParameter("salaID", salaID)
                .getResultList();
    }

    @Override
    public List<SalaMateriaOutput> listarSalaMateria() {
        var query = """
                SELECT sm.id, sm.id_sala, sm.id_materia, sala.nome AS sala, sala.quantidade_maxima, materia.nome AS materia FROM materia_sala sm
                INNER JOIN sala ON sala.id = sm.id_sala
                INNER JOIN materia ON materia.id = sm.id_materia
                """;
        return entityManager.createNativeQuery(query, SalaMateriaOutput.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void atualizarMateria(int id, int materiaID) {
        var query = """
                UPDATE materia_sala SET
                id_materia = :materiaID
                WHERE id = :id
                """;

        entityManager.createNativeQuery(query, SalaMateriaOutput.class)
                .setParameter("id", id)
                .setParameter("materiaID", materiaID)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletarMateria(int id) {
        var query = "DELETE FROM materia_sala WHERE id =:id;";

        entityManager.createNativeQuery(query, SalaMateriaOutput.class).setParameter("id",id).executeUpdate();

    }


}