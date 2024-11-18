package com.cronograma.Cesurg.infra.dataBase;

import com.cronograma.Cesurg.core.domain.contract.contractDias.DiasdaSemanaRepository;
import com.cronograma.Cesurg.core.domain.entity.DiasdaSemana;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiasdaSemanaRepositoryImpl implements DiasdaSemanaRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void atualizarStatus(int id, DiasdaSemana diasDaSemana) {
        var query = """
                UPDATE dias_da_semana SET 
                disponivel = :disponivel
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, DiasdaSemana.class)
                .setParameter("id",id)
                .setParameter("disponivel",diasDaSemana.isDisponivel())
                .executeUpdate();
    }

    @Override
    public List<DiasdaSemana> listarDias() {
        var query = "SELECT * FROM dias_da_semana;";

        return entityManager.createNativeQuery(query, DiasdaSemana.class).getResultList();
    }

    @Override
    public List<Professor> listarDiaProfessor(int idDia) {
        var query = """
           SELECT p.id, p.nome, p.ativo, p.descricao FROM professor_dia pd
           INNER JOIN professor p ON p.id = pd.id_professor
           WHERE id_dia = :diaId;
           """;
        return (List<Professor>) entityManager.createNativeQuery(query, Professor.class)
                .setParameter("diaId", idDia)
                .getResultList();
    }

}
