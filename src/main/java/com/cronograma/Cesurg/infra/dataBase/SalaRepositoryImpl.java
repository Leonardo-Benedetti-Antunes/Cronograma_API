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
    public Sala criar(Sala sala) {
        var query = """
                INSERT INTO sala(nome, quantidade_maxima)
                VALUES (:nome, :quantidade_maxima)
                RETURNING *
                """;

        return (Sala) entityManager.createNativeQuery(query, Sala.class)
                .setParameter("nome",sala.getNome())
                .setParameter("quantidade_maxima",sala.getQuantidadeMaxima())
                .getSingleResult();
    }

    @Transactional
    @Override
    public Sala deletar(int id) {
        var query = """
                DELETE FROM sala WHERE id =:id
                RETURNING *""";

        return (Sala) entityManager.createNativeQuery(query, Sala.class).setParameter("id",id).getSingleResult();

    }

    @Transactional
    @Override
    public Sala atualizar(int id, Sala sala) {
        var query = """
                UPDATE sala SET
                nome = :nome,
                quantidade_maxima = :quantidade_maxima
                WHERE id = :id
                RETURNING *
                """;
        return (Sala) entityManager.createNativeQuery(query,Sala.class)
                .setParameter("nome",sala.getNome())
                .setParameter("quantidade_maxima",sala.getQuantidadeMaxima())
                .setParameter("id",id)
                .getSingleResult();
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
    public SalaCategoriaCreat adicionarCategoria(int salaID, int categoriaID) {
        var query = """
                INSERT INTO sala_categoria (id_sala, id_categoria)
                VALUES (:salaID, :categoriaID)
                RETURNING *;
                """;
        return (SalaCategoriaCreat) entityManager.createNativeQuery(query, SalaCategoriaCreat.class)
                .setParameter("salaID", salaID)
                .setParameter("categoriaID", categoriaID)
                .getSingleResult();
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
    public SalaCategoriaCreat atualizarCategoria(int id, int categoriaID) {
        var query = """
                UPDATE sala_categoria SET
                id_categoria = :categoriaID
                WHERE id = :id
                RETURNING *
                """;

        return (SalaCategoriaCreat) entityManager.createNativeQuery(query, SalaCategoriaCreat.class)
            .setParameter("id", id)
            .setParameter("categoriaID", categoriaID)
            .getSingleResult();

    }

    @Transactional
    @Override
    public SalaCategoriaCreat deletarCategoria(int id) {
        var query = """
                DELETE FROM sala_categoria WHERE id =:id
                RETURNING *""";

        return (SalaCategoriaCreat) entityManager.createNativeQuery(query, SalaCategoriaCreat.class).setParameter("id",id).getSingleResult();

    }

    @Transactional
    @Override
    public SalaTurmaCreat adicionarTurma(int salaID, int turmaID) {
        var query = """
                INSERT INTO sala_turma (id_sala, id_turma)
                VALUES (:salaID, :turmaID)
                RETURNING *;
                """;
        return (SalaTurmaCreat) entityManager.createNativeQuery(query, SalaTurmaCreat.class)
                .setParameter("salaID", salaID)
                .setParameter("turmaID", turmaID)
                .getSingleResult();
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
    public SalaTurmaCreat atualizarTurma(int id, int turmaID) {
        var query = """
                UPDATE sala_turma SET
                id_turma = :turmaID
                WHERE id = :id
                RETURNING *
                """;

        return (SalaTurmaCreat) entityManager.createNativeQuery(query, SalaTurmaCreat.class)
                .setParameter("id", id)
                .setParameter("turmaID", turmaID)
                .getSingleResult();
    }

    @Transactional
    @Override
    public SalaTurmaCreat deletarTurma(int id) {
        var query = """
                DELETE FROM sala_turma WHERE id =:id
                RETURNING *""";

        return (SalaTurmaCreat) entityManager.createNativeQuery(query, SalaTurmaCreat.class).setParameter("id",id).getSingleResult();

    }

    @Transactional
    @Override
    public SalaMateriaCreat adicionarMateria(int salaID, int materiaID) {
        var query = """
                INSERT INTO materia_sala(id_sala, id_materia)
                VALUES (:salaID, :materiaID)
                RETURNING *;
                """;
        return (SalaMateriaCreat) entityManager.createNativeQuery(query, SalaMateriaCreat.class)
                .setParameter("salaID", salaID)
                .setParameter("materiaID", materiaID)
                .getSingleResult();
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
    public SalaMateriaCreat atualizarMateria(int id, int materiaID) {
        var query = """
                UPDATE materia_sala SET
                id_materia = :materiaID
                WHERE id = :id
                RETURNING *
                """;

        return (SalaMateriaCreat) entityManager.createNativeQuery(query, SalaMateriaCreat.class)
                .setParameter("id", id)
                .setParameter("materiaID", materiaID)
                .getSingleResult();
    }

    @Transactional
    @Override
    public SalaMateriaCreat deletarMateria(int id) {
        var query = """
                DELETE FROM materia_sala WHERE id =:id
                RETURNING *""";

        return (SalaMateriaCreat) entityManager.createNativeQuery(query, SalaMateriaCreat.class).setParameter("id",id).getSingleResult();

    }


}