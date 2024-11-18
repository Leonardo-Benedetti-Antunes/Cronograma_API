package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.CursoRepository;
import com.cronograma.Cesurg.core.domain.entity.Curso;

import com.cronograma.Cesurg.core.domain.entity.Materia;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void criar(Curso curso) {
        var query = """
                INSERT INTO curso(nome)
                VALUES (:nome);
                """;
        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("nome",curso.getNome())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletar(int id) {
        var query = """
                DELETE FROM curso WHERE id = :id
                """;
        entityManager.createNativeQuery(query,  Curso.class)
                .setParameter("id", id)
                .executeUpdate();

    }

    @Transactional
    @Override
    public void atualizar(int id, Curso curso) {
        var query = """
                UPDATE curso SET 
                nome = :nome
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("nome", curso.getNome())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Curso> listarCursos() {
        var query = " SELECT * FROM curso;";
        return entityManager.createNativeQuery(query, Curso.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void inserirMateria(int idCurso, int idMateria) {
        var query = """
                INSERT INTO curso_materias (id_curso, id_materia)
                VALUES (:id_curso, :id_materia)
                """;
        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("id_curso", idCurso)
                .setParameter("id_materia", idMateria)
                .executeUpdate();

    }

    @Transactional
    @Override
    public void deletarMateria(int idCurso, int idMateria) {
        var query = """
                DELETE FROM curso_materias
                WHERE id_curso = :idCurso and id_materia = :idMateria
                """;
        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("idCurso", idCurso)
                .setParameter("idMateria", idMateria)
                .executeUpdate();
    }

    @Override
    public List<Materia> listarMateria(int idCurso) {
        var query = """
                SELECT m.id, m.nome FROM curso_materias cm
                INNER JOIN materia m ON m.id = cm.id_materia
                WHERE id_curso = :idCurso;
                """;
        return (List<Materia>) entityManager.createNativeQuery(query, Materia.class)
                .setParameter("idCurso", idCurso)
                .getResultList();

    }
}
