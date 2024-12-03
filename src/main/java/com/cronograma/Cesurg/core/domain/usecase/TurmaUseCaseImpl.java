package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.TurmaRepository;
import com.cronograma.Cesurg.core.domain.contract.TurmaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaUseCaseImpl implements TurmaUseCase {
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public Turma criar(Turma turma) {
       return turmaRepository.criar(turma);
    }

    @Override
    public Turma deletar(int id) {
        return turmaRepository.deletar(id);
    }

    @Override
    public Turma atualizar(int id, Turma turma) {
        return turmaRepository.atualizar(id, turma);
    }

    @Override
    public List<Turma> listar() {
        return turmaRepository.listar();
    }

    @Override
    public Turma listarPorID(int id) {
        return turmaRepository.listarPorID(id);
    }
}
