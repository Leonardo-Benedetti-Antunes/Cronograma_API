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
    public void insert(Turma turma) {
        turmaRepository.insert(turma);
    }

    @Override
    public void delete(int id) {
        turmaRepository.delete(id);
    }

    @Override
    public void update(int id, Turma turma) {
        turmaRepository.update(id, turma);
    }

    @Override
    public List<Turma> fetch() {
        return turmaRepository.fetch();
    }

    @Override
    public Turma get(int id) {
        return turmaRepository.get(id);
    }
}
