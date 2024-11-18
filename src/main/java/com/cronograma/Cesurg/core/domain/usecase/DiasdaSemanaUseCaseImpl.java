package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.contractDias.DiasdaSemanaRepository;
import com.cronograma.Cesurg.core.domain.contract.contractDias.DiasdaSemanaUseCase;
import com.cronograma.Cesurg.core.domain.entity.DiasdaSemana;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiasdaSemanaUseCaseImpl implements DiasdaSemanaUseCase {

    @Autowired
    private DiasdaSemanaRepository diasdaSemanaRepository;

    @Override
    public void atualizarStatus(int id, DiasdaSemana diasDaSemana) {
        diasdaSemanaRepository.atualizarStatus(id, diasDaSemana);
    }

    @Override
    public List<DiasdaSemana> listarDias() {
        return diasdaSemanaRepository.listarDias();
    }

    @Override
    public List<Professor> listarDiaProfessor(int idDia) {
        return diasdaSemanaRepository.listarDiaProfessor(idDia);
    }
}
