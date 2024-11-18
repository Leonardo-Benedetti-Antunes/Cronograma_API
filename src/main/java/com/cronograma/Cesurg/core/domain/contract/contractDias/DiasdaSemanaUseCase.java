package com.cronograma.Cesurg.core.domain.contract.contractDias;

import com.cronograma.Cesurg.core.domain.entity.DiasdaSemana;
import com.cronograma.Cesurg.core.domain.entity.Professor;

import java.util.List;

public interface DiasdaSemanaUseCase {
    // atualizar status do dia
    public void atualizarStatus(int id, DiasdaSemana diasDaSemana);

    public List<DiasdaSemana> listarDias();

    // listar os professores no dia
    public List<Professor> listarDiaProfessor(int idDia);
}
