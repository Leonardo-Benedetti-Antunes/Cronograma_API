package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.ProfessorRepository;
import com.cronograma.Cesurg.core.domain.contract.ProfessorUseCase;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorUseCaseImpl implements ProfessorUseCase {
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void insert(Professor professor) {
        professorRepository.insert(professor);
    }

    @Override
    public void delete(int id) {
        professorRepository.delete(id);
    }

    @Override
    public void updateStatus(int id, Professor professor) {
        professorRepository.updateStatus(id, professor);
    }

    @Override
    public void update(int id, Professor professor) {
        professorRepository.update(id, professor);
    }

    @Override
    public List<Professor> fetch() {
        return professorRepository.fetch();
    }

    @Override
    public Professor get(int id) {
        return professorRepository.get(id);
    }
}
