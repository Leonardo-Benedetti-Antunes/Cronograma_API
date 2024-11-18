package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.ProfessorRepository;
import com.cronograma.Cesurg.core.domain.entity.DiasdaSemana;
import com.cronograma.Cesurg.core.domain.entity.Materia;
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
    public void criar(Professor professor) {
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
    public void deletar(int id) {
        var query = "DELETE FROM professor WHERE id =:id;";

        entityManager.createNativeQuery(query, Professor.class).setParameter("id",id).executeUpdate();
    }
    @Transactional
    @Override
    public void atualizarStatus(int id,  Professor professor) {
        var query = """
                UPDATE professor SET 
                ativo = :ativo
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("id",id)
                .setParameter("ativo",professor.isAtivo())
                .executeUpdate();
    }
    @Transactional
    @Override
    public void atualizarProfesor(int id, Professor professor) {
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
    public List<Professor> listarProfessor() {
        var query = "SELECT * FROM professor;";

        return entityManager.createNativeQuery(query, Professor.class).getResultList();
    }

    @Override
    public Professor listarPorId(int id) {
        var query = "SELECT * FROM professor WHERE id = :id;";

        return (Professor) entityManager.createNativeQuery(query, Professor.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    @Override
    public List<DiasdaSemana> listarProfessorDia(int idProfessor) {
        var query = """
           SELECT ds.id, ds.nome_dia, ds.disponivel FROM professor_dia pd
           INNER JOIN dias_da_semana ds ON ds.id = pd.id_dia
           WHERE id_professor = :idProfessor;
           """;
        return (List<DiasdaSemana>) entityManager.createNativeQuery(query, DiasdaSemana.class)
                .setParameter("idProfessor", idProfessor)
                .getResultList();
    }

    @Transactional
    @Override
    public void adicionarDiaProfessor(int idProfessor, int idDia) {
        var query = """
            INSERT INTO professor_dia (id_professor, id_dia) 
            VALUES (:idProfessor, :idDia);
            """;

        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("idProfessor", idProfessor)
                .setParameter("idDia", idDia)
                .executeUpdate();
    }
    @Transactional
    @Override
    public void adicionarMateriaProfessor(int idProfessor, int idMateria) {
        var query = """
                INSERT INTO professor_materia (id_materia, id_professor)
                VALUES (:idMateria, :idProfessor)
                """;
        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("idMateria", idMateria)
                .setParameter("idProfessor", idProfessor)
                .executeUpdate();
    }

    @Override
    public List<Materia> listarMateriaProfessor(int idProfessor) {
        var query = """ 
                SELECT m.id, m.nome FROM professor_materia pm
                INNER JOIN materia m ON m.id = pm.id_materia
                WHERE id_professor = :idProfessor;
                """;
        return (List<Materia>) entityManager.createNativeQuery(query, Materia.class)
                .setParameter("idProfessor", idProfessor)
                .getResultList();

    }
    @Transactional
    @Override
    public void removerDiaDoProfessor(int idProfessor, int idDia) {
        var query = "DELETE FROM professor_dia WHERE id_dia =:idDia and id_professor = :idProfessor;";

        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("idProfessor",idProfessor)
                .setParameter("idDia",idDia)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void removerMateriaDoProfessor(int idProfessor, int idMateria) {
        var query = "DELETE FROM professor_materia WHERE id_materia = :idMateria and id_professor = :idProfessor;";

        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("idProfessor",idProfessor)
                .setParameter("idMateria",idMateria)
                .executeUpdate();
    }
}

